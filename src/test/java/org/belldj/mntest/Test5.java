package org.belldj.mntest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

class Test5 {

	@Test
	void testJsonToCustomBuilder() throws Exception {

		RooBarValue src = RooBarValue.builder()
				.id(1)
				.foo(1)
				.bar("darren")
				.addBuz(1)
				.addCrux(1l)
				.build();

		// notice that we are adding in the support for Optional among others
		// Micronaut will have already done this.

		ObjectMapper objectMapper = new ObjectMapper().registerModule(new Jdk8Module());
		String json = objectMapper.writeValueAsString(src);


		// now lets convert it back again

		Object obj = objectMapper.readValue(json, RooBarValue.class);

		assertThat(obj).isEqualTo(src);

	}

}
