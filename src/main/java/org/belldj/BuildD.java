package org.belldj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class BuildD {
	
	public static final BuildD.Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private long id;
		private String name;
		private Set<String> dependencies;
		private Map<String,String> properties = new HashMap<>();
		private Map<LabelType,String> labels = new HashMap<>();

		public BuildD.Builder id(int id) {
			this.id = id;
			return this;
		}

		public BuildD.Builder name(String name) {
			this.name = name;
			return this;
		}

		public BuildD.Builder dependencies(Set<String> dependencies) {
			this.dependencies = dependencies;
			return this;
		}

		public BuildD.Builder properties(Map<String, String> properties) {
			this.properties = properties;
			return this;
		}

		public BuildD.Builder labels(Map<LabelType,String> labels) {
			this.labels = labels;
			return this;
		}

		public BuildD build() {
			return new BuildD(this);
		}
	}
 
	private final long id;
	private final String name;
	private final Set<String> dependencies;
	private final Map<String,String> properties;
	private final Map<LabelType,String> labels;

	private BuildD(BuildD.Builder b) {
		this.id = b.id;
		this.name = b.name;
		this.dependencies = (b.dependencies==null) ? Set.of() : b.dependencies;
		this.properties = (b.properties==null) ? Map.of() : b.properties;
		this.labels = (b.labels==null) ? Map.of() : b.labels;
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Set<String> getDependencies() {
		return dependencies;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public Map<LabelType, String> getLabels() {
		return labels;
	}

}