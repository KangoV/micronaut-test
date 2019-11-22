/**
 *
 */
package org.belldj.mntest.domain;

import org.belldj.mntest.builds.domain.Build;
import org.belldj.mntest.parts.domain.Part;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface PartCreatedEventSpec {
  @Value.Parameter(order = 1)
  Part getPart();
}
