package org.belldj.mntest.part.web;

import org.belldj.mntest.part.domain.PartApi;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = PartRelT.class)
@JsonDeserialize(as = PartRelT.class)
@Schema(name = "Part ref", description = "A relation for a part")
public interface PartRelSpec extends PartApi.PartRef {
}