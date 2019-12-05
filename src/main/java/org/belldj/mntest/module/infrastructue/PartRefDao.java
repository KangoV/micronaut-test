package org.belldj.mntest.module.infrastructue;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PartRefDao extends CrudRepository<PartRefE, UUID> {

  @Query(value = "from partref as pr where pr.partId = ?")
  List<PartRefE> find(UUID uuid); // empty

}

