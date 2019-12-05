package org.belldj.mntest.module.domain;

import static java.util.Objects.requireNonNullElseGet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import com.fasterxml.uuid.Generators;

public final class PartRef {

  private static final String NULL_MODULE_ID = "Part references must belong to a mofule. Module ID cannot be null";
  private static final String NULL_PART_ID = "Part references must reference a Part. Part ID cannot be null";
  private static final String NULL_DATA = "Data cannot be null. Must have at least an empty object ({}).";

  public static PartRef.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    
    private UUID id;
    private UUID moduleId;
    private UUID partId;
    private String data;
    private Map<String, String> properties;
    private LocalDateTime createdDate;

    public PartRef.Builder id(UUID id)                               { this.id = id; return this; }
    public PartRef.Builder partId(UUID partId)                       { this.moduleId = partId; return this; }
    public PartRef.Builder moduleId(UUID moduleId)                   { this.moduleId = moduleId; return this; }
    public PartRef.Builder data(String data)                         { this.data = data; return this; }
    public PartRef.Builder properties(Map<String,String> properties) { this.properties = properties; return this; }
    public PartRef.Builder createdDate(LocalDateTime created)        { this.createdDate = created; return this; }

    public PartRef build() {
      Objects.requireNonNull(moduleId, NULL_MODULE_ID);
      Objects.requireNonNull(partId, NULL_PART_ID);
      Objects.requireNonNull(data, NULL_DATA);
      return new PartRef(this);
    }
    
  }

  private final UUID id;
  private final UUID moduleId;
  private final UUID partId;
  private final String data;
  private final Map<String, String> properties;
  private final LocalDateTime createdDate;

  private PartRef(PartRef.Builder b) {
    assert b.moduleId != null : NULL_MODULE_ID;
    assert b.partId != null : NULL_PART_ID;
    assert b.data != null : NULL_DATA;
    this.id = requireNonNullElseGet(b.id, Generators.timeBasedGenerator()::generate);
    this.moduleId = b.moduleId;
    this.partId = b.moduleId;
    this.data = b.data;
    this.properties = requireNonNullElseGet(b.properties, HashMap::new);
    this.createdDate = requireNonNullElseGet(b.createdDate, LocalDateTime::now);
  }

  public UUID getId()                       { return this.id; }
  public UUID getPartId()                   { return this.partId; }
  public UUID getModuleId()                 { return this.moduleId; }
  public String getData()                   { return this.data; }
  public Map<String,String> getProperties() { return this.properties; }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }

}
