package org.belldj.mntest.builds.infrastructure;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ComponentsDefDao extends CrudRepository<BuildE, UUID> {

  @Override
  List<BuildE> findAll(); // empty

}

