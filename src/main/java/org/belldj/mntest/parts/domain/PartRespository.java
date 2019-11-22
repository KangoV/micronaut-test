package org.belldj.mntest.parts.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.domain.PartCreatedEvent;
import org.belldj.mntest.parts.infrastructure.PartDao;
import org.belldj.mntest.parts.infrastructure.PartE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class PartRespository {

  @Mapper
  interface PartRepositoryMapper {
    Part  map(PartE src);
    PartE map(Part src);
    PartE map(Part src, @MappingTarget PartE target);
  }

  private static final PartRepositoryMapper mapper = Mappers.getMapper(PartRepositoryMapper.class);
  private final PartDao partDao;
  private final ApplicationEventPublisher eventBus;

  @SuppressWarnings("hiding")
  @Inject
  public PartRespository(PartDao buildsDao, ApplicationEventPublisher eventBus) {
    this.partDao = buildsDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public Part create(Part part) {
    if (partDao.existsById(part.getId())) {
      throw new RuntimeException(String.format("Build with id \"%s\" already exists"));
    }
    PartE builde = partDao.save(mapper.map(part));
    Part result = mapper.map(builde);
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
