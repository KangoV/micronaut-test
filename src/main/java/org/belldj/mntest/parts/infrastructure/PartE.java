package org.belldj.mntest.parts.infrastructure;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "part")
public final class PartE {

  @Id
  @Column(columnDefinition = "uuid")
  private UUID id;

  @Column(name = "name", nullable = true)
  private String name;

  @Column(name = "created")
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column(name = "attributes")
  private String attributes;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "part_element",
      joinColumns = {@JoinColumn(name = "part_id", referencedColumnName = "id")})
  @Column(name = "element_ref_id")
  private Set<UUID> elements;

  public String getAttributes() {
    return attributes;
  }

  public Set<UUID> getElements() {
    return this.elements;
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

}
