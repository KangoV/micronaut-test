/**
 *
 */
package org.belldj.mntest.domain;

import org.belldj.mntest.parts.domain.Part;
import org.belldj.mntest.util.Event;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface PartCreatedEvent {

  @Value.Parameter(order = 1)
	Part getPart();
}
