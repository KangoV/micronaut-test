package org.belldj.mntest.parts.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.SubType;
import org.belldj.mntest.shared.Type;
import com.fasterxml.uuid.Generators;

public final class PartRel {

  public static PartRel.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    
    private UUID id;
    private SubType subType;
    private UUID partId;
    private Map<String, String> properties;
    private LocalDateTime createdDate;

    public PartRel.Builder id(UUID id)                               { this.id = id; return this; }
    public PartRel.Builder subType(SubType subType)                  { this.subType = subType; return this; }
    public PartRel.Builder partId(UUID partId)                       { this.partId = partId; return this; }
    public PartRel.Builder properties(Map<String,String> properties) { this.properties = properties; return this; }
    public PartRel.Builder createdDate(LocalDateTime created)        { this.createdDate = created; return this; }

    public PartRel build() {
      return new PartRel(this);
    }
    
  }

  private final UUID id;
  private final SubType subType;
  private final UUID partId;
  private final Map<String, String> properties;
  private final LocalDateTime createdDate;

  private PartRel(PartRel.Builder b) {
    this.id = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.subType = b.subType;
    this.partId = b.partId;
    this.properties = (b.properties == null) ? new HashMap<>() : b.properties;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
  }

  public UUID getId()                       { return this.id; }
  public SubType getSubType()               { return this.subType; }
  public UUID getPartId()                   { return this.partId; }
  public Map<String,String> getProperties() { return this.properties; }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }

}
