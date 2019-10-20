package org.belldj.mntest.builds.infrastructure;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface BuildsDao extends CrudRepository<BuildE, UUID> {

  @Override
  @Join(value = "dependencies")
  @Join(value = "properties")
  @Join(value = "labels")
  @Query(value = "from BuildE as build left join build.dependencies left join build.properties left join build.labels")
  List<BuildE> findAll(); // empty

}

