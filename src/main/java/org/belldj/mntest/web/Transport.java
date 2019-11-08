package org.belldj.mntest.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;
import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Used to annotate an Immutable interface with styles for immutable objects used for converting
 * instances from/to json.
 *
 * @author darren
 */
@Target(ElementType.TYPE)
@Value.Style(
  passAnnotations = {Schema.class},
  typeImmutable = "*T",
  typeAbstract = "*Spec",
  visibility = ImplementationVisibility.PUBLIC)
@Introspected // need this so Jackson will use the annotated object without reflection
public @interface Transport {
  /* empty */ }
