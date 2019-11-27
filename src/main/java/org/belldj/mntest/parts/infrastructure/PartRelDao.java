package org.belldj.mntest.parts.infrastructure;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PartRelDao extends CrudRepository<PartRelE, UUID> {

  @Query(value = "from PartRef as partref where partref.partId = ?")
  List<PartRelE> find(UUID uuid); // empty

}

