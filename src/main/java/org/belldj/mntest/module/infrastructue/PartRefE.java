package org.belldj.mntest.module.infrastructue;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.belldj.mntest.parts.infrastructure.PartE;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "partref")
public final class PartRefE {

  @Id
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @OneToOne(targetEntity = PartE.class)
  @JoinColumn(name = "module_id", referencedColumnName = "id")
  private UUID moduleId;

  @OneToOne(targetEntity = PartE.class)
  @JoinColumn(name = "part_id", referencedColumnName = "id")
  private UUID partId;

  @Column(name = "data", nullable = false)
  private String attributes;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
    name = "partref_property", 
    joinColumns = { @JoinColumn(name = "partref_id", referencedColumnName = "id") })
  @MapKeyColumn(name = "property_key")
  @Column(name = "property_name")
  private Map<String, String> properties;

  @Column(name = "created", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdDate;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime created) {
    this.createdDate = created;
  }

  public UUID getPartId() {
    return partId;
  }

  public void setPartId(UUID partId) {
    this.partId = partId;
  }

  public UUID getModuleId() {
    return moduleId;
  }

  public void setModuleId(UUID moduleId) {
    this.moduleId = moduleId;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
