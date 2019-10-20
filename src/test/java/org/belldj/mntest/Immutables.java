package org.belldj.mntest;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.immutables.value.Value;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

abstract class Immutables {

	@Value.Style(typeImmutable = "T*")
	public @interface Transport { /* empty */ }

	@Transport
	@Value.Immutable
	@JsonSerialize(as = TSimpleValue.class)
	@JsonDeserialize(as = TSimpleValue.class)
	public interface SimpleValue {
	  int getId();
	  String getName();
	}

	@Value.Immutable
	@Transport
	public interface FoobarValue {
	  int getId();
	  int getFoo();
		Optional<String> getBar();
		List<Integer> getBuz();
		Set<Long> getCrux();
	}

	@Value.Immutable
	@Transport
	public interface ToobarValue {
	  int getId();
	  int getToo();
	  String getBar();
		List<Integer> getBuz();
		Set<Long> getCrux();
	}

	@Mapper
	public interface Mymapper {

		@Mapping(source = "foo", target = "too")
		@Mapping(source = "bar", target = "bar", qualifiedByName = "unwrap")
		TToobarValue fromFoo2Too(TFoobarValue src);

		RooBarValue fromFoo2Roo(TFoobarValue src);

		public static <T> T unwrapOptional(final Optional<T> optional) {
			return optional.orElse(null);
		}

	}

}
