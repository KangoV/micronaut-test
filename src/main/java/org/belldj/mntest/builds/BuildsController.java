package org.belldj.mntest.builds;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.LabelType;
import org.belldj.mntest.builds.domain.Build;
import org.belldj.mntest.builds.domain.BuildService;
import org.belldj.mntest.builds.domain.BuildsApi;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
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

@Controller("/builds")
@Validated
public class BuildsController {

  @Transport
  @Value.Immutable
  @JsonSerialize(as = RegisterBuildCommandT.class)
  @JsonDeserialize(as = RegisterBuildCommandT.class)
  @Schema(name = "RegisterBuildCommand", description = "The build to be registered")
  public interface RegisterBuildCommandSpec extends BuildsApi.RegisterBuildCommand {
    // empty
  }

  @Transport
  @Value.Immutable
  @JsonSerialize(as = RegisteredBuildT.class)
  @JsonDeserialize(as = RegisteredBuildT.class)
  @Schema(name = "RegisteredBuild", description = "The registered Build")
  public interface RegisteredBuildSpec {
    UUID getId();
    String getName();
    Set<String> getDependencies();
    Map<String, String> getProperties();
    Map<LabelType, String> getLabels();
    LocalDateTime getCreatedDate();
  }

  @Mapper
  public interface BuildsMapper {
    @Mapping(target = "putLabels", ignore = true)
    @Mapping(target = "putAllLabels", ignore = true)
    @Mapping(target = "putProperties", ignore = true)
    @Mapping(target = "putAllProperties", ignore = true)
    RegisteredBuildT map(Build build);
  }

  public static final BuildsMapper mapper = Mappers.getMapper(BuildsMapper.class);

  private BuildService service;

  public BuildsController(BuildService service) {
    this.service = service;
  }

  /**
   * Registers a new build
   * 
   * @param build The build to register
   * @return The build that was saved
   */
  @Tag(name = "builds")
  @Post(uri = "/", consumes = MediaType.APPLICATION_JSON)
  public HttpResponse<RegisteredBuildT> add(@Body @Nonnull @NotNull final RegisterBuildCommandT cmd) {
    Build build = service.create(cmd);
    return HttpResponse.created(mapper.map(build));
  }

  /**
   * Returns all registered builds
   * 
   * @return all registered builds
   */
  @Tag(name = "builds")
  @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
  public HttpResponse<List<RegisteredBuildT>> all() {
    List<RegisteredBuildT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
