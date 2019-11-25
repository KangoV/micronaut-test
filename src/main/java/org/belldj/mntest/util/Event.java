package org.belldj.mntest.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.immutables.value.Value;

@Target(ElementType.TYPE)
@Value.Style(
  typeAbstract = "*Spec",
  typeImmutable = "*",
  visibility = Value.Style.ImplementationVisibility.PUBLIC)
public @interface Event {
  // empty
}
