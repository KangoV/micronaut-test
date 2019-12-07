package org.belldj.mntest.part;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.belldj.mntest.part.domain.Part;
import org.belldj.mntest.part.domain.PartRespository;
import org.belldj.mntest.part.infrastructure.PartE;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import org.junit.jupiter.api.Test;

class PartToFromPartEMappingTest {

  private UUID PART_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  @Test
  void test() {

    @SuppressWarnings("preview")
    var original_part = Part.builder()
      .id(PART_ID)
      .category(Category.ITEM)
      .type(Type.SYMBOL)
      .name("darren")
      .data(
        """
        {"name":"main"}
        """
      )
      .createdDate(NOW)
      .properties(Map.of("part_key1", "part_value1"))
      .build();

    PartE part_e = PartRespository.mapper.map(original_part);
    Part part = PartRespository.mapper.map(part_e);

//    Assertions.assertThat(part).isEqualTo(original_part);

  }

}
