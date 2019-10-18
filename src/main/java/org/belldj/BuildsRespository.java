package org.belldj;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Singleton
public class BuildsRespository {

	@Mapper
	interface BuildsRepositoryMapper {
		BuildD map(BuildE src);
		BuildE map(BuildD src);
		BuildE map(BuildD src, @MappingTarget BuildE target);
	}
	private static final BuildsRepositoryMapper mapper = Mappers.getMapper(BuildsRepositoryMapper.class);
	
	@Inject
	private BuildsDao buildsDao;
	
//	@Transactional
	public BuildD save(BuildD build) {
		BuildE saved = buildsDao
			.findById(build.getId())
			.map(b -> buildsDao.save(mapper.map(build, b)))
			.orElseGet(() -> buildsDao.save(mapper.map(build)));
		return mapper.map(saved);
	}
	
	public Iterable<BuildD> all() {
		return StreamSupport
			.stream(buildsDao.findAll().spliterator(), false)
			.map(mapper::map).collect(Collectors.toList());
	}
}
