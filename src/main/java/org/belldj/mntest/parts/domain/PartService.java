package org.belldj.mntest.parts.domain;

import java.util.List;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import io.micronaut.context.event.ApplicationEventPublisher;

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
	private ApplicationEventPublisher publisher;

	public PartService(PartRespository respository, ApplicationEventPublisher publisher) {
    this.repository = respository;
		this.publisher = publisher;
  }

  @Override
  public List<Part> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public Part create(PartAddCommand command) {
    var part = mapper.map(command);
	part = repository.create(part);
	publisher.publishEvent(PartCreatedEvent.of(part));
	return part;
  }

}
