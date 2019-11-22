package org.belldj.mntest.immutables;

import static org.assertj.core.api.Assertions.assertThat;
import org.immutables.value.Value;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

class Test4 {

	@Value.Style(typeImmutable = "T*")
	public @interface Transport { /* empty */ }

	@Transport
	@Value.Immutable
	@JsonSerialize(as = TSimpleValue4.class)
	@JsonDeserialize(as = TSimpleValue4.class)
	public interface SimpleValue4 {
	  int getId();
	  String getName();
	}

	@Test
	void testJsonToImmutablesBuilder() throws Exception {

		TSimpleValue4 src = TSimpleValue4.builder()
				.id(1)
				.name("darren")
				.build();

		// first convert to a json string....

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(src);

		// now lets convert it back again

		TSimpleValue4 obj = objectMapper.readValue(json, TSimpleValue4.class);

		assertThat(obj).isEqualTo(src);

	}

}
