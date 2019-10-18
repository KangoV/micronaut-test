package org.belldj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.belldj.BuildT.builder;

import java.util.Optional;

import org.belldj.BuildD;
import org.belldj.BuildT;
import org.belldj.LabelType;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

class TestBuildT {

	@Mapper
	public interface BuildsControllerMappers {
		
		@Mapping(target="putAllLabels", ignore = true)
		@Mapping(target="putAllProperties", ignore = true)
		@Mapping(target="putLabels", ignore = true)
		@Mapping(target="putProperties", ignore = true)
		BuildT map(BuildD buildd);
		
		BuildD map(BuildT buildt);
		
		@Named("unwrap") static <T> T unwrap(Optional<T> optional) {
	        return optional.orElse(null);
	    }
		
	}

	/**
	 * Very simple test to show how an immutable object can be used. This test will create a new
	 * instance based upon another one using "from" in the builder.
	 *
	 * Notice that Junit5 (jupiter) does not require public. Package level is sufficient.
	 */
	@Test
	void testBuildT() {

		var buildt1 = builder()
			.id(1)
			.name("red_hot_gambler")
			.putLabels(LabelType.GAME, "redhotgambler")
			.putProperties("key", "value")
			.addDependencies("rootPlugin")
			.build();

		assertThat(buildt1).isNotNull();

		var mapper = Mappers.getMapper(BuildsControllerMappers.class);
		
		var buildd = mapper.map(buildt1);
		
		assertThat(buildd).isNotNull();
		
		var buildt2 = mapper.map(buildd);
		
		assertThat(buildt2).isEqualTo(buildt1);
		
	}

}
