package org.belldj.mntest.builds.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.belldj.mntest.LabelType;

public interface BuildsApi {

  public interface RegisterBuildCommand {
    String getName();
    Set<String> getDependencies();
    Map<String, String> getProperties();
    Map<LabelType, String> getLabels();
  }

  Build create(RegisterBuildCommand build);
  List<Build> findAll();

}
