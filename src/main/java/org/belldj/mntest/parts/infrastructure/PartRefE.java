package org.belldj.mntest.parts.infrastructure;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.belldj.mntest.shared.SubType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "partref")
public final class PartRefE {

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

}
