package org.belldj;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import org.immutables.value.Value;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/builds")
public class BuildsController {

  @Value.Style(typeImmutable = "*T")
  public @interface Transport {
    /* empty */ }

  @Transport
  @Value.Immutable
  @JsonSerialize(as = BuildT.class)
  @JsonDeserialize(as = BuildT.class)
  public interface Build {
    int getId();
    String getName();
    Set<String> getDependencies();
    Map<String, String> getProperties();
    Map<LabelType, String> getLabels();
  }

  @Mapper
  public interface BuildsControllerMappers {
    @Mapping(target = "putLabels", ignore = true)
    @Mapping(target = "putAllLabels", ignore = true)
    @Mapping(target = "putProperties", ignore = true)
    @Mapping(target = "putAllProperties", ignore = true)
    BuildT map(BuildD buildd);
    BuildD map(BuildT buildt);
    @Named("unwrap")
    static <T> T unwrap(Optional<T> optional) {
      return optional.orElse(null);
    }
  }

  public static final BuildsControllerMappers mapper = Mappers.getMapper(BuildsControllerMappers.class);

  private BuildsRespository respository;
  
  public BuildsController(BuildsRespository respository) {
	this.respository = respository;
  }

  @Post("/")
  public HttpResponse<BuildT> add(@Body @Nonnull @NotNull final BuildT buildt) {
    var buildd = mapper.map(buildt);
    buildd = respository.save(buildd);
    return HttpResponse.ok(mapper.map(buildd));
  }

  @Get("/")
  public HttpResponse<List<BuildT>> all() {
    var result = StreamSupport
        .stream(respository.all().spliterator(), false)
        .map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
