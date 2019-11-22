package org.belldj.mntest.parts.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.parts.domain.Part;
import org.belldj.mntest.parts.domain.PartApi;
import org.belldj.mntest.parts.domain.PartService;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller(value = "/parts", produces = MediaType.APPLICATION_JSON)
@Tag(name = "parts")
@Validated
public class PartController {

  @Transport
  @Value.Immutable
  @JsonSerialize(as = AddPartCommandT.class)
  @JsonDeserialize(as = AddPartCommandT.class)
  @Schema(name = "AddPartCommand", description = "The part to be added")
  public interface AddPartCommandSpec extends PartApi.AddPartCommand {
    @Override
    @JsonRawValue
    default String getAttributes() {
      return "{}";
    }
  }

  @Transport
  @Value.Immutable
  @JsonSerialize(as = PartT.class)
  @JsonDeserialize(as = PartT.class)
  @JsonInclude(Include.NON_NULL)
  @Schema(name = "RegisteredBuild", description = "The registered Build")
  public interface PartSpec {
    UUID getId();
    String getName();
    @JsonRawValue
    @Value.Default
    default String getAttributes() {
      return "{}";
    }
    LocalDateTime getCreatedDate();
  }

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface PartControllerMapper {
    @Mapping(target = "attributes", defaultValue = "{}")
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
  public HttpResponse<PartT> add(@Body @NotNull final AddPartCommandT command) {
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
