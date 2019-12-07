package org.belldj.mntest.part.web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.part.domain.Part;
import org.belldj.mntest.part.domain.PartService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller(value = "/parts", produces = MediaType.APPLICATION_JSON)
@Tag(name = "parts")
@Validated
public class PartController {

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface PartControllerMapper {
    @Mapping(target = "data", defaultValue = "{}")
    PartT map(Part part);
  }

  public static final PartControllerMapper mapper = Mappers.getMapper(PartControllerMapper.class);

  private PartService service;

  public PartController(PartService service) {
    this.service = service;
  }

  /**
   * Registers a new build
   *
   * @param build The build to register
   * @return The build that was saved
   */
  @Post(uri = "/")
  public HttpResponse<PartT> add(@Body @NotNull final PartAddCommandT command) {
    Part part = service.create(command);
    return HttpResponse.created(mapper.map(part));
  }

  /**
   * Returns all registered builds
   *
   * @return all registered builds
   */
  @Get(uri = "/")
  public HttpResponse<List<PartT>> all() {
    List<PartT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
