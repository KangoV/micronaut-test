package org.belldj.mntest.part.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;

public interface PartApi {

  public interface PartAddCommand {
    Type getType();
    String getName();
    String getData();
    Set<UUID> getElements();
    Set<PartRef> getRelations();
    Map<String,String> properties();
  }

  public interface PartRef {
    Type getType();
    UUID getPartId();
  }

  Part create(PartAddCommand build);
  List<Part> findAll();

}
