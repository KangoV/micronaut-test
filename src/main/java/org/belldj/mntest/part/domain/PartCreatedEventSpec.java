/**
 *
 */
package org.belldj.mntest.part.domain;

import org.belldj.mntest.util.Event;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface PartCreatedEventSpec { 
  @Value.Parameter(order = 1)
  Part getPart();
}
