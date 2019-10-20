package org.belldj.mntest.domain;

import org.immutables.value.Value;

@Value.Style(
    typeImmutable = "*I",
    strictBuilder = true)
public @interface Command {
  // empty
}
