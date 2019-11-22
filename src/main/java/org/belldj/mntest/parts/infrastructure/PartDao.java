package org.belldj.mntest.parts.infrastructure;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PartDao extends CrudRepository<PartE, UUID> {

  @Override
  @Query(value = "from PartE as part")
  List<PartE> findAll(); // empty

}

