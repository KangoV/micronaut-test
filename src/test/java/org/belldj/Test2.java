package org.belldj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mapstruct.factory.Mappers.getMapper;
import static org.belldj.TFoobarValue.builder;

import org.belldj.Immutables.Mymapper;
import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void testMappingImmutable() {

		var mapper = getMapper(Mymapper.class);

		var src = builder()
				.id(1)
				.foo(1)
				.bar("darren")
				.addBuz(1)
				.addCrux(1)
				.build();

		var target = mapper.fromFoo2Roo(src);

		assertThat(target).isNotNull();

	}

}
