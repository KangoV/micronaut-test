package org.belldj.mntest.parts.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import org.belldj.mntest.parts.infrastructure.PartDao;
import org.belldj.mntest.parts.infrastructure.PartE;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class PartDaoTest {

  private static final UUID ID = UUID.randomUUID();
  
  @Inject
  private PartDao dao;

  @SuppressWarnings("preview")
  @Test
  void test() {

    var p = new PartE();
    
    p.setId(ID);
    p.setCreatedDate(LocalDateTime.now());
    p.setProperties(Map.of("K1","V1"));
    p.setElements(Set.of(UUID.randomUUID()));
    p.setName("Cherry");
    p.setType(Type.ITEM);
    p.setSubType(SubType.SYMBOL);
    p.setAttributes(
      """
      {
        "code": "CHRY",
        "index": 0
      }
      """
    );

    p = dao.save(p);
    
    assertThat(p).isNotNull();
    
    var opt = dao.findById(ID);
    
    assertThat(opt.isPresent()).isTrue();
    
  }

}
