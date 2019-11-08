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
  @Join(value = "dependencies", type = Join.Type.FETCH)
  @Join(value = "properties", type = Join.Type.FETCH)
  @Join(value = "labels", type = Join.Type.FETCH)
  @Query(value = "from BuildE as build left join build.dependencies left join build.properties left join build.labels")
  List<BuildE> findAll(); // empty

}

