package org.belldj.mntest.parts.infrastructure;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PartRefDao extends CrudRepository<PartRefE, UUID> {

  @Query(value = "from PartRef as partref where partref.partId = ?")
  List<PartRefE> find(UUID uuid); // empty

}

