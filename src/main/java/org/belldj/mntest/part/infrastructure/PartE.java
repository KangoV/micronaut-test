package org.belldj.mntest.part.infrastructure;

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
import javax.persistence.Table;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "part")
public final class PartE {

  @Id
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "category", nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private Category category;

  @Column(name = "type", nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private Type type;

  @Column(name = "name", nullable = true)
  private String name;

  @Column(name = "created", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column(name = "data", nullable = false)
  private String data;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "part_element", joinColumns = {@JoinColumn(name = "part_id", referencedColumnName = "id")})
  @Column(name = "element_ref_id")
  private Set<UUID> elements;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "part_property", joinColumns = {@JoinColumn(name = "part_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "property_key")
  @Column(name = "property_name")
  private Map<String, String> properties;

  /*
   * ### ### getters/ setters ###
   */

  public Set<UUID> getElements() {
    return this.elements;
  }

  public void setElements(Set<UUID> elements) {
    this.elements = elements;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
