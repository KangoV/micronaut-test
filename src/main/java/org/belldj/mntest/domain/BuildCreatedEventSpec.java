/**
 *
 */
package org.belldj.mntest.domain;

import org.belldj.mntest.builds.domain.Build;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface BuildCreatedEventSpec {
  @Value.Parameter(order = 1)
  Build getBuild();
}
