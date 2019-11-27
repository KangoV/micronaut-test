package org.belldj.mntest.parts.infrastructure;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "part")
public final class PartE {

  @Id
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "type", nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private Type type;

  @Column(name = "subtype", nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private SubType subType;

  @Column(name = "name", nullable = true)
  private String name;

  @Column(name = "created", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column(name = "attributes", nullable = false)
  private String attributes;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "part_element", joinColumns = {@JoinColumn(name = "part_id", referencedColumnName = "id")})
  @Column(name = "element_ref_id")
  private Set<UUID> elements;

  @OneToMany(mappedBy = "partId")
  private Set<PartRelE> relations;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "part_property", joinColumns = {@JoinColumn(name = "part_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "property_key")
  @Column(name = "property_name")
  private Map<String, String> properties;

  /*
   * ### ### getters/ setters ###
   */

  public Set<PartRelE> getRelations() {
    return relations;
  }

  public void setRelations(Set<PartRelE> relations) {
    this.relations = relations;
  }

  public Set<UUID> getElements() {
    return this.elements;
  }

  public void setElements(Set<UUID> elements) {
    this.elements = elements;
  }

  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public SubType getSubType() {
    return subType;
  }

  public void setSubType(SubType subType) {
    this.subType = subType;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
