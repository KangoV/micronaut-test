package org.belldj.mntest.util;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonModule extends SimpleModule {

  public JacksonModule() {
    setDeserializerModifier(new JsonRawValueDeserializerModifier());
  }

  private static class JsonRawValueDeserializerModifier extends BeanDeserializerModifier {
    @Override
    public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc, BeanDeserializerBuilder builder) {
      builder.getProperties().forEachRemaining(property -> {
        if (property.getAnnotation(JsonRawValue.class) != null) {
          builder.addOrReplaceProperty(property.withValueDeserializer(JsonRawValueDeserializer.INSTANCE), true);
        }
      });
      return builder;
    }
  }

  private static class JsonRawValueDeserializer extends JsonDeserializer<String> {
    private static final JsonDeserializer<String> INSTANCE = new JsonRawValueDeserializer();
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      return p.readValueAsTree().toString();
    }
  }

}
