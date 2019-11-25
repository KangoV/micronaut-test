package org.belldj.mntest.components.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.LabelType;
import com.fasterxml.uuid.Generators;

public final class ComponentDef {

  public static final ComponentDef.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID id;
    private String name;
    private LocalDateTime createdDate;

    public ComponentDef.Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public ComponentDef.Builder name(String name) {
      this.name = name;
      return this;
    }

    public ComponentDef.Builder createdDate(LocalDateTime created) {
      this.createdDate = created;
      return this;
    }

    public ComponentDef build() {
      return new ComponentDef(this);
    }
  }

  private final UUID id;
  private final String name;
  private final LocalDateTime createdDate;

  private ComponentDef(ComponentDef.Builder b) {
    this.id = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.name = b.name;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
  }

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public LocalDateTime getCreatedDate() {
    return this.createdDate;
  }

}
