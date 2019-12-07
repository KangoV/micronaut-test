package org.belldj.mntest.part.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import javax.inject.Inject;
import org.belldj.mntest.part.domain.Part;
import org.belldj.mntest.part.domain.PartService;
import org.belldj.mntest.part.web.PartAddCommandT;
import org.belldj.mntest.part.web.PartRelT;
import org.belldj.mntest.shared.Type;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class PartServiceTest {

  @Inject
  private PartService partService;

  @SuppressWarnings("preview")
  @Test
  void testAdd() {

    var cmd = PartAddCommandT.builder()
      .type(Type.SYMBOL)
      .name("main")
      .data(
        """
        { "name": "main" }
        """)
      .addRelations(PartRelT.builder()
        .type(Type.SYMBOL)
        .partId(UUID.randomUUID())
        .build())
      .build();

    Part part = partService.create(cmd);

    assertThat(part).isNotNull();
    assertThat(part.getData()).isEqualTo(
      """
      { "name": "main" }
      """);
  }

  @Test
  void testAll() {
    var parts = partService.findAll();
    assertThat(parts).isNotNull();
  }

}
