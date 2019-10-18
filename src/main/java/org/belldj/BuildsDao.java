package org.belldj;

import java.util.List;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface BuildsDao extends CrudRepository<BuildE, Long> {
	
	@Override
    List<BuildE> findAll();  // empty
	
}

