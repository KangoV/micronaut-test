package org.belldj.mntest.builds.infrastructure;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import org.belldj.mntest.LabelType;

@Entity
public final class ComponentE {

	@Id
	private UUID id;

	@Column(name = "name")
	private String name;

	@JoinColumn(name = "component_def_id")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ComponentDefE.class)
	private UUID componentDefId;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "build_dependency", joinColumns = { @JoinColumn(name = "build_id", referencedColumnName = "id") })
	@Column(name = "component_name")
	private Set<String> dependencies;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "build_label", joinColumns = { @JoinColumn(name = "build_id", referencedColumnName = "id") })
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "label_type")
	@Column(name = "label_name")
	private Map<LabelType, String> labels;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "build_property", joinColumns = { @JoinColumn(name = "build_id", referencedColumnName = "id") })
	@MapKeyColumn(name = "property_key")
	@Column(name = "property_name")
	private Map<String, String> properties;

	@Column(name = "created")
	private LocalDateTime createdDate;

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime created) {
		this.createdDate = created;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getComnponentDefId() {
		return id;
	}

	public void setComponentDefId(UUID componentDefId) {
		this.componentDefId = componentDefId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<String> dependencies) {
		this.dependencies = dependencies;
	}

	public Map<LabelType, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<LabelType, String> labels) {
		this.labels = labels;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}