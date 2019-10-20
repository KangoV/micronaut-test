package org.belldj.mntest.builds.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.builds.infrastructure.BuildE;
import org.belldj.mntest.builds.infrastructure.BuildsDao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Singleton
public class BuildsRespository {

	@Mapper
	interface BuildsRepositoryMapper {
		Build  map(BuildE src);
		BuildE map(Build src);
		BuildE map(Build src, @MappingTarget BuildE target);
	}
	private static final BuildsRepositoryMapper mapper = Mappers.getMapper(BuildsRepositoryMapper.class);
	
	@Inject
	private BuildsDao buildsDao;
	
	@Transactional
	public Build save(Build build) {
		BuildE saved = buildsDao
			.findById(build.getId())
			.map(b -> buildsDao.save(mapper.map(build, b)))
			.orElseGet(() -> buildsDao.save(mapper.map(build)));
		return mapper.map(saved);
	}
	
	public List<Build> all() {
		return buildsDao
			.findAll()
			.stream()
			.map(mapper::map).collect(Collectors.toList());
	}
}
