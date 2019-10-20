package org.belldj.mntest.web;

import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Used to annotate an Immutable interface with styles for immutable objects used for converting
 * instances from/to json.
 * 
 * @author darren
 */
@Value.Style(
    passAnnotations = { Schema.class }, 
    typeImmutable = "*T",
    visibility = ImplementationVisibility.PUBLIC)
public @interface Transport { /* empty */ }