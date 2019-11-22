package org.belldj.mntest.parts;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.mntest.parts.domain.Part;
import org.belldj.mntest.parts.web.PartController;
import org.belldj.mntest.parts.web.PartT;
import org.junit.jupiter.api.Test;

class PartTest {

  @Test
  void testPart() {
    PartT part = PartT.builder()
      .id(UUID.randomUUID())
      .name("darren")
      .createdDate(LocalDateTime.now())
      .build();
    assertThat(part).isNotNull();
  }

  @Test
  void test_map_from_Part_to_PartT() {

    Part part = Part.builder()
      .id(UUID.randomUUID())
      .name("darren")
      .createdDate(LocalDateTime.now())
      .build();
    assertThat(part).isNotNull();

    PartT part_t = PartController.mapper.map(part);
    assertThat(part_t).isNotNull();

  }

}
