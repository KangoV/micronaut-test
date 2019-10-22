/**
 * 
 */
package org.belldj.mntest.builds.domain;

import org.immutables.value.Value;

@Value.Style(typeAbstract = "*Def", typeImmutable = "*", allParameters = true)
@Value.Immutable(builder = false)
public interface BuildCreatedEventDef {
  Build getBuild();
}
