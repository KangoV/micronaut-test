package org.belldj.mntest.builds.domain;

import java.util.List;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Singleton
public class BuildService implements BuildsApi {

  @Mapper
  public interface BuildsServiceMappers {
    Build map(RegisterBuildCommand command);
  }

  public static final BuildsServiceMappers mapper = Mappers.getMapper(BuildsServiceMappers.class);
  private final BuildsRespository repository;

  public BuildService(BuildsRespository respository) {
    this.repository = respository;
  }

  @Override
  public List<Build> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public Build create(RegisterBuildCommand command) {
    return repository.create(mapper.map(command));
  }

}
