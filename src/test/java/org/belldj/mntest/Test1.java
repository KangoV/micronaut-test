package org.belldj.mntest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Test1 {

	/**
	 * Very simple test to show how an immutable object can be used. This test will create a new
	 * instance based upon another one using "from" in the builder.
	 *
	 * Notice that Junit5 (jupiter) does not require public. Package level is sufficient.
	 */
	@Test
	void testImmutables() {

		TFoobarValue fooBar1 = TFoobarValue.builder()
			.id(1)
			.foo(1)
			.bar("darren")
			.addBuz(1)
			.addCrux(1)
			.build();

		assertThat(fooBar1).isEqualTo(TFoobarValue.copyOf(fooBar1));

		TFoobarValue fooBar2 = TFoobarValue.builder()
			.from(fooBar1)
			.build();

		assertThat(fooBar1).isEqualTo(fooBar2);

	}

}
