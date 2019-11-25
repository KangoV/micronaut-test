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
  public interface PartServiceMappers {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "type", source = "subType.type")
    Part map(PartAddCommand command);
  }

  public static final PartServiceMappers mapper = Mappers.getMapper(PartServiceMappers.class);
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
  public Part create(PartAddCommand command) {
    var part = mapper.map(command);
    return repository.create(part);
  }

}
