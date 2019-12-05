package org.belldj.mntest.parts.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.mntest.parts.domain.Part;
import org.belldj.mntest.parts.web.PartAddCommandT;
import org.belldj.mntest.parts.web.PartController;
import org.belldj.mntest.parts.web.PartT;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.util.JacksonModule;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

class PartTest {

  private UUID PART_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  private static final String DATA =
    """
    {
      "name": "main"
    }
    """;

  
  @SuppressWarnings("preview")
  @Test
  void test_AddPartCommand() {

    var part = PartAddCommandT.builder()
      .subType(SubType.SYMBOL)
      .name("Cherry")
      .attributes(DATA)
      .build();
    
    assertThat(part).isNotNull();
    
  }

  @Test
  void testPart() {
    var part = PartT.builder()
      .id(PART_ID)
      .type(Type.ITEM)
      .subType(SubType.SYMBOL)
      .name("Cherry")
      .attributes(DATA)
      .createdDate(LocalDateTime.now())
      .build();
    assertThat(part).isNotNull();
  }

  @Test
  void test_map_from_Part_to_PartT() {

    var part = Part.builder()
      .id(PART_ID)
      .type(Type.ITEM)
      .subType(SubType.SYMBOL)
      .name("darren")
      .attributes(DATA)
      .createdDate(NOW)
      .build();
    assertThat(part).isNotNull();

    var part_t = PartController.mapper.map(part);
    
    assertThat(part_t).isEqualTo(PartT.builder()
        .id(PART_ID)
        .type(Type.ITEM)
        .subType(SubType.SYMBOL)
        .name("darren")
        .attributes(DATA)
        .createdDate(NOW).build());

  }

  @SuppressWarnings("preview")
  @Test
  void test_deserialise_into_PartT() throws Exception {

    var part_json = """
        {
          "subType": "SYMBOL",
          "name": "Cherry",
          "attributes": {
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
            .subType(SubType.SYMBOL)
            .name("Cherry")
            .attributes(DATA)
        .build();
    
    assertThat(part_t).isEqualTo(expected_part_t);
    
  }

}
