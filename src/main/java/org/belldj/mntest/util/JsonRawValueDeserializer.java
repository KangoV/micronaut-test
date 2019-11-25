package org.belldj.mntest.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonRawValueDeserializer extends JsonDeserializer<String> {
  @Override public String deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
    return jp.readValueAsTree().toString();
  }
}