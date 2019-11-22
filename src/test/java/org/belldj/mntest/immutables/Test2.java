package org.belldj.mntest.immutables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mapstruct.factory.Mappers.getMapper;
import org.belldj.mntest.immutables.Immutables.Mymapper;
import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void testMappingImmutable() {

		Mymapper mapper = getMapper(Mymapper.class);

		TFoobarValue src = TFoobarValue.builder()
				.id(1)
				.foo(1)
				.bar("darren")
				.addBuz(1)
				.addCrux(1)
				.build();

		Object target = mapper.fromFoo2Roo(src);

		assertThat(target).isNotNull();

	}

}
