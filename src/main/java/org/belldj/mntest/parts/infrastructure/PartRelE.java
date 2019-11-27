package org.belldj.mntest.parts.infrastructure;

import java.time.LocalDateTime;
import java.util.Map;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.belldj.mntest.shared.SubType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "partrel")
public final class PartRelE {

  @Id
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "subtype", nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private SubType subType;

  @OneToOne(targetEntity = PartE.class)
  @JoinColumn(name = "part_id", referencedColumnName = "id")
  private UUID partId;

  @Column(name = "created", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdDate;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
    name = "partrel_property",
    joinColumns = {@JoinColumn(name = "partrel_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "property_key")
  @Column(name = "property_name")
  private Map<String, String> properties;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SubType getSubType() {
    return subType;
  }

  public void setSubType(SubType subType) {
    this.subType = subType;
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

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
