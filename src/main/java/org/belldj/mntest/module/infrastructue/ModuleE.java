package org.belldj.mntest.module.infrastructue;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "module")
public final class ModuleE {

  @Id
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @Column(name="name")
  private String name;

  @OneToMany
  @JoinColumn(name="module_id")
  private Set<PartRefE> partRefs;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "module_property", joinColumns = {@JoinColumn(name = "module_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "module_key")
  @Column(name = "module_name")
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

  public Set<PartRefE> getPartRefs() {
    return this.partRefs;
  }

  public void setPartRefs(Set<PartRefE> partRefs) {
    this.partRefs = partRefs;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
