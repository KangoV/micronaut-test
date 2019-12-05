package org.belldj.mntest.module.domain;

import static java.util.Objects.requireNonNullElseGet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import com.fasterxml.uuid.Generators;

public final class Module {

  private static final String NULL_NAME = "Name is null. A module must have a name";
  
  public static Module.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    
    private UUID id;
    private String name;
    private Set<PartRef> relations;
    private Map<String, String> properties;
    private LocalDateTime createdDate;

    public Module.Builder id(UUID id)                                { this.id = id; return this; }
    public Module.Builder name(String name)                          { this.name = name; return this; }
    public Module.Builder parts(Set<PartRef> relations)              { this.relations = relations; return this; }
    public Module.Builder properties(Map<String, String> properties) { this.properties = properties; return this; }
    public Module.Builder createdDate(LocalDateTime created)         { this.createdDate = created; return this; }

    public Module build() {
      Objects.requireNonNull(NULL_NAME);
      return new Module(this);
    }

  }

  private final UUID id;
  private final String name;
  private final Set<PartRef> parts;
  private final Map<String, String> properties;
  private final LocalDateTime createdDate;

  private Module(Module.Builder b) {
    assert b.name != null : NULL_NAME;
    this.id          = requireNonNullElseGet(b.id, Generators.timeBasedGenerator()::generate);
    this.name        = b.name;
    this.parts       = (b.relations == null) ? new HashSet<>() : b.relations;
    this.properties  = requireNonNullElseGet(b.properties, HashMap::new);
    this.createdDate = requireNonNullElseGet(b.createdDate, LocalDateTime::now);
  }

  public UUID getId()                       { return this.id; }
  public String getName()                   { return this.name;  }
  public Set<PartRef> getRelations()        { return this.parts; }
  public Map<String,String> getProperties() { return this.properties; }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }

}
