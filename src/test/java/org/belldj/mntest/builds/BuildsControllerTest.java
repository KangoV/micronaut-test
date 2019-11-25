package org.belldj.mntest.builds;

import java.util.List;
import javax.inject.Inject;
import org.assertj.core.api.Assertions;
import org.belldj.mntest.builds.web.RegisterBuildCommandT;
import org.junit.jupiter.api.Test;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

class BuildsControllerTest extends BaseContainerTest {

  @Client(value = "/builds")
  public interface BuildsClient {
    @Get(value = "/")
    List<RegisterBuildCommandT> findAll();
  }

  @Inject
  private BuildsClient client;

  @Test
  void testFindAll() {
    List<RegisterBuildCommandT> user = client.findAll();
    Assertions.assertThat(user).isNotNull();
  }

}
