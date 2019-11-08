package org.belldj.mntest.builds.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.builds.infrastructure.BuildE;
import org.belldj.mntest.builds.infrastructure.BuildsDao;
import org.belldj.mntest.domain.BuildCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class BuildsRespository {

  @Mapper
  interface BuildsRepositoryMapper {
    Build  map(BuildE src);
    BuildE map(Build src);
    BuildE map(Build src, @MappingTarget BuildE target);
  }

  private static final BuildsRepositoryMapper mapper = Mappers.getMapper(BuildsRepositoryMapper.class);
  private final BuildsDao buildsDao;
  private final ApplicationEventPublisher eventBus;

  @SuppressWarnings("hiding")
  @Inject
  public BuildsRespository(BuildsDao buildsDao, ApplicationEventPublisher eventBus) {
    this.buildsDao = buildsDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public Build create(Build build) {
    if (buildsDao.existsById(build.getId())) {
      throw new RuntimeException(String.format("Build with id \"%s\" already exists"));
    }
    BuildE builde = buildsDao.save(mapper.map(build));
    Build result = mapper.map(builde);
    eventBus.publishEvent(BuildCreatedEvent.of(build));
    return result;
  }

  public List<Build> all() {
    return buildsDao
        .findAll()
        .stream()
        .map(mapper::map).collect(Collectors.toList());
  }

}
