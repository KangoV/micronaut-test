package org.belldj.mntest.immutables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = RooBarValue.RooBarValueBuilder.class)
public final class RooBarValue {

	public static final RooBarValue.RooBarValueBuilder builder() {
		return new RooBarValueBuilder();
	}

	// we are telling Jackson that our setters do not have a "set" prefix

	@JsonPOJOBuilder(withPrefix = "")
	public static final class RooBarValueBuilder {
		private int id;
		private int foo;
		private Optional<String> bar;
		private List<Integer> buz = new ArrayList<>();
		private Set<Long> crux = new HashSet<>();
		public RooBarValue.RooBarValueBuilder id(final int id)             { this.id = id; return this; }
		public RooBarValue.RooBarValueBuilder foo(final int foo)           { this.foo = foo; return this; }
		public RooBarValue.RooBarValueBuilder bar(final String bar)        { this.bar = Optional.ofNullable(bar); return this; }
		public RooBarValue.RooBarValueBuilder buz(final List<Integer> buz) { this.buz = buz; return this; }
		public RooBarValue.RooBarValueBuilder addBuz(final Integer buz)    { this.buz.add(buz); return this; }
		public RooBarValue.RooBarValueBuilder crux(final Set<Long> crux)   { this.crux = crux; return this; }
		public RooBarValue.RooBarValueBuilder addCrux(final Long crux)     { this.crux.add(crux); return this; }
		public RooBarValue                    build()                      { return new RooBarValue(this); }
	}

	private final int id;
	private final int foo;
	private final Optional<String> bar;
	private final List<Integer> buz;
	private final Set<Long> crux;

	protected RooBarValue(final RooBarValue.RooBarValueBuilder b) {
		this.id = b.id;
		this.foo = b.foo;
		this.bar = b.bar;
		this.buz = b.buz;
		this.crux = b.crux;
	}

	public int              getId()   { return id; }
	public int              getFoo()  { return foo; }
	public Optional<String> getBar()  { return bar; }
	public List<Integer>    getBuz()  { return buz; }
	public Set<Long>        getCrux() { return crux; }

	@Override
	public int hashCode() {
		return Objects.hash(bar, buz, crux, foo, id);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		RooBarValue other = (RooBarValue) obj;
		return
				Objects.equals(bar, other.bar) &&
				Objects.equals(buz, other.buz) &&
				Objects.equals(crux, other.crux) &&
				foo == other.foo &&
				id == other.id;
	}


}