package org.belldj.mntest.parts;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.belldj.mntest.parts.domain.Part;
import org.belldj.mntest.parts.domain.PartRel;
import org.belldj.mntest.parts.domain.PartRespository;
import org.belldj.mntest.parts.infrastructure.PartE;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import org.junit.jupiter.api.Test;

class PartToFromPartEMappingTest {

  private UUID PART_ID = UUID.randomUUID();
  private UUID PART_REL_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  @Test
  void test() {

    var original_part = Part.builder()
      .id(PART_ID)
      .type(Type.ITEM)
      .subType(SubType.SYMBOL)
      .name("darren")
      .attributes("{\"name\":\"main\"}")
      .createdDate(NOW)
      .relations(Set.of(PartRel.builder()
        .id(PART_REL_ID)
        .partId(PART_ID)
        .subType(SubType.SYMBOL)
        .properties(Map.of("part_rel_key1", "part_rel_value1"))
        .build()))
      .properties(Map.of("part_key1", "part_value1"))
      .build();

    PartE part_e = PartRespository.mapper.map(original_part);
    Part part = PartRespository.mapper.map(part_e);

    Assertions.assertThat(part).isEqualTo(original_part);

  }

}