package org.belldj.mntest.parts.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.belldj.mntest.parts.infrastructure.PartDao;
import org.belldj.mntest.parts.infrastructure.PartE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class PartRespository {

  @Mapper
  public interface PartRepositoryMapper {
    Part  map(PartE src);
    PartE map(Part src);
    PartE map(Part src, @MappingTarget PartE target);
  }

  public static final PartRepositoryMapper mapper = Mappers.getMapper(PartRepositoryMapper.class);

  private final PartDao partDao;
  private final ApplicationEventPublisher eventBus;

  @Inject
  public PartRespository(PartDao partDao, ApplicationEventPublisher eventBus) {
    this.partDao = partDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public Part create(Part part) {
    if (partDao.existsById(part.getId())) {
      throw new PartException(String.format("Part with id \"%s\" already exists", part.getId()));
    }
    var parte = partDao.save(mapper.map(part));
    var result = mapper.map(parte);
    eventBus.publishEvent(PartCreatedEvent.of(part));
    return result;
  }

  public List<Part> all() {
    return partDao
        .findAll()
        .stream()
        .map(mapper::map).collect(Collectors.toList());
  }

}
