package org.belldj.mntest.module.infrastructue;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ModuleDao extends CrudRepository<ModuleE, UUID> {

  @Override
  @Query(value = "from modulee as m")
  List<ModuleE> findAll(); // empty

}

