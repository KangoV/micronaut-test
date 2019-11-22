package org.belldj.mntest.parts.domain;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PartApi {

  public interface AddPartCommand {
    String getName();
    String getAttributes();

    Set<UUID> getElements();
  }

  Part create(AddPartCommand build);

  List<Part> findAll();

}
