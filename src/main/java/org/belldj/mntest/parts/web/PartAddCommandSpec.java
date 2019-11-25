package org.belldj.mntest.parts.web;

import org.belldj.mntest.parts.domain.PartApi;
import org.belldj.mntest.util.JsonRawValueDeserializer;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = PartAddCommandT.class)
@JsonDeserialize(as = PartAddCommandT.class)
@Schema(name = "AddPartCommand", description = "The part to be added")
public interface PartAddCommandSpec extends PartApi.PartAddCommand {

  @Override
  @JsonRawValue
  @Value.Default
  @JsonDeserialize(using = JsonRawValueDeserializer.class)
  default String getAttributes() {
    return "{}";
  }

}