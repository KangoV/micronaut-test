package org.belldj.mntest.builds.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.LabelType;
import com.fasterxml.uuid.Generators;

public final class Build {

  public static final Build.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID id;
    private String name;
    private Set<String> dependencies;
    private Map<String, String> properties = new HashMap<>();
    private Map<LabelType, String> labels = new HashMap<>();
    private LocalDateTime createdDate;

    public Build.Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Build.Builder name(String name) {
      this.name = name;
      return this;
    }

    public Build.Builder dependencies(Set<String> dependencies) {
      this.dependencies = dependencies;
      return this;
    }

    public Build.Builder properties(Map<String, String> properties) {
      this.properties = properties;
      return this;
    }

    public Build.Builder labels(Map<LabelType, String> labels) {
      this.labels = labels;
      return this;
    }

    public Build.Builder createdDate(LocalDateTime created) {
      this.createdDate = created;
      return this;
    }

    public Build build() {
      return new Build(this);
    }
  }

  private final UUID id;
  private final String name;
  private final Set<String> dependencies;
  private final Map<String, String> properties;
  private final Map<LabelType, String> labels;
  private final LocalDateTime createdDate;

  private Build(Build.Builder b) {
    this.id = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.name = b.name;
    this.dependencies = (b.dependencies == null) ? new HashSet<>() : b.dependencies;
    this.properties = (b.properties == null) ? new HashMap<>() : b.properties;
    this.labels = (b.labels == null) ? new HashMap<>() : b.labels;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
  }

  public UUID getId() {
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

  public LocalDateTime getCreatedDate() {
    return this.createdDate;
  }

}
