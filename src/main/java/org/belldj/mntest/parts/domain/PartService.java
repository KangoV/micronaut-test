package org.belldj.mntest.parts.domain;

import java.util.List;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Singleton
public class PartService implements PartApi {

  @Mapper
  public interface BuildsServiceMappers {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    Part map(AddPartCommand command);
  }

  public static final BuildsServiceMappers mapper = Mappers.getMapper(BuildsServiceMappers.class);
  private final PartRespository repository;

  public PartService(PartRespository respository) {
    this.repository = respository;
  }

  @Override
  public List<Part> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public Part create(AddPartCommand command) {
    return repository.create(mapper.map(command));
  }

}
