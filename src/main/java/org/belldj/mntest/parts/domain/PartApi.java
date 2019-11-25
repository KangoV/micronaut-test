package org.belldj.mntest.parts.domain;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.SubType;

public interface PartApi {

  public interface PartAddCommand {
    SubType getSubType();
    String getName();
    String getAttributes();
    Set<UUID> getElements();
    Set<PartRef> getRelations();
  }

  public interface PartRef {
    SubType getSubType();
    UUID getPartId();
  }

  Part create(PartAddCommand build);
  List<Part> findAll();

}
