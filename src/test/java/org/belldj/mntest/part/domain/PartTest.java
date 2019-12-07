package org.belldj.mntest.part.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.mntest.part.domain.Part;
import org.belldj.mntest.part.web.PartAddCommandT;
import org.belldj.mntest.part.web.PartController;
import org.belldj.mntest.part.web.PartT;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import org.belldj.mntest.util.JacksonModule;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

class PartTest {

  private UUID PART_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  @SuppressWarnings("preview")
  private static final String DATA =
    """
    {"code":"CHRY"}""";

  
  @Test
  void test_AddPartCommand() {

    var part = PartAddCommandT.builder()
      .type(Type.SYMBOL)
      .name("Cherry")
      .data(DATA)
      .build();
    
    assertThat(part).isNotNull();
    
  }

  @Test
  void testPart() {
    var part = PartT.builder()
      .id(PART_ID)
      .category(Category.ITEM)
      .type(Type.SYMBOL)
      .name("Cherry")
      .data(DATA)
      .createdDate(LocalDateTime.now())
      .build();
    assertThat(part).isNotNull();
  }

  @Test
  void test_map_from_Part_to_PartT() {

    var part = Part.builder()
      .id(PART_ID)
      .category(Category.ITEM)
      .type(Type.SYMBOL)
      .name("darren")
      .data(DATA)
      .createdDate(NOW)
      .build();
    assertThat(part).isNotNull();

    var part_t = PartController.mapper.map(part);
    
    assertThat(part_t).isEqualTo(PartT.builder()
      .id(PART_ID)
      .category(Category.ITEM)
      .type(Type.SYMBOL)
      .name("darren")
      .data(DATA)
      .createdDate(NOW).build());

  }

  @SuppressWarnings("preview")
  @Test
  void test_deserialise_into_PartT() throws Exception {

    var part_json = """
        {
          "type": "SYMBOL",
          "name": "Cherry",
          "data": {
            "code": "CHRY"
          }
        }
        """;

    var mapper = new ObjectMapper();

    // this is required to deserialize into a raw string
    mapper.registerModule(new JacksonModule());

    var part_t = mapper.readValue(part_json, PartAddCommandT.class);
    var expected_part_t =
        PartAddCommandT.builder()
            .type(Type.SYMBOL)
            .name("Cherry")
            .data(DATA)
        .build();
    
    assertThat(part_t).isEqualTo(expected_part_t);
    
  }

}
