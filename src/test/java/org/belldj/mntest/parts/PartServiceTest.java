package org.belldj.mntest.parts;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import javax.inject.Inject;
import org.belldj.mntest.parts.domain.PartService;
import org.belldj.mntest.parts.web.PartAddCommandT;
import org.belldj.mntest.parts.web.PartRefT;
import org.belldj.mntest.shared.SubType;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class PartServiceTest {

  @Inject
  private PartService partService;

  @Test
  void testAdd() {
    var cmd = PartAddCommandT.builder()
        .subType(SubType.SYMBOL)
        .name("main")
        .attributes("{\"name\":\"main\"}")
        .addRelations(PartRefT.builder()
            .subType(SubType.SYMBOL)
            .partId(UUID.randomUUID())
            .build())
        .build();
    var part = partService.create(cmd);
    assertThat(part).isNotNull();
    assertThat(part.getAttributes()).isEqualTo("{\"name\":\"main\"}");
  }

  @Test
  void testAll() {
    var parts = partService.findAll();
    assertThat(parts).isNotNull();
  }

}
