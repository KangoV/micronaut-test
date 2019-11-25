package org.belldj.mntest.parts.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import com.fasterxml.uuid.Generators;

public final class Part {

  public static Part.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID id;
    private Type type;
    private SubType subType;
    private String name;
    private String attributes;
    private Set<UUID> elements;
    private LocalDateTime createdDate;

    public Part.Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Part.Builder type(Type type) {
      this.type = type;
      return this;
    }

    public Part.Builder subType(SubType subType) {
      this.subType = subType;
      return this;
    }

    public Part.Builder name(String name) {
      this.name = name;
      return this;
    }

    public Part.Builder attributes(String attributes) {
      this.attributes = attributes;
      return this;
    }

    public Part.Builder elements(Set<UUID> elements) {
      this.elements = elements;
      return this;
    }

    public Part.Builder createdDate(LocalDateTime created) {
      this.createdDate = created;
      return this;
    }

    public Part build() {
      return new Part(this);
    }
  }

  private final UUID id;
  private final Type type;
  private final SubType subType;
  private final String name;
  private final String attributes;
  private final Set<UUID> elements;
  private final LocalDateTime createdDate;

  private Part(Part.Builder b) {
    this.id = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.type = b.type;
    this.subType = b.subType;
    this.name = b.name;
    this.attributes = b.attributes;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
    this.elements = (b.elements == null) ? new HashSet<>() : b.elements;
  }

  public UUID getId() {
    return this.id;
  }

  public Type getType() {
    return type;
  }

  public SubType getSubType() {
    return subType;
  }

  public String getName() {
    return this.name;
  }

  public String getAttributes() {
    return attributes;
  }

  public Set<UUID> getElements() {
    return this.elements;
  }

  public LocalDateTime getCreatedDate() {
    return this.createdDate;
  }

}
