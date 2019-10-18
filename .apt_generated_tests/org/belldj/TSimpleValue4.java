package org.belldj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Test4.SimpleValue4}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code TSimpleValue4.builder()}.
 */
@Generated(from = "Test4.SimpleValue4", generator = "Immutables")
@SuppressWarnings({"all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class TSimpleValue4 implements Test4.SimpleValue4 {
  private final int id;
  private final String name;

  private TSimpleValue4(int id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public int getId() {
    return id;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Test4.SimpleValue4#getId() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final TSimpleValue4 withId(int value) {
    if (this.id == value) return this;
    return new TSimpleValue4(value, this.name);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Test4.SimpleValue4#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final TSimpleValue4 withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new TSimpleValue4(this.id, newValue);
  }

  /**
   * This instance is equal to all instances of {@code TSimpleValue4} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof TSimpleValue4
        && equalTo((TSimpleValue4) another);
  }

  private boolean equalTo(TSimpleValue4 another) {
    return id == another.id
        && name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id;
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SimpleValue4} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "SimpleValue4{"
        + "id=" + id
        + ", name=" + name
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Test4.SimpleValue4", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Test4.SimpleValue4 {
    int id;
    boolean idIsSet;
    @Nullable String name;
    @JsonProperty("id")
    public void setId(int id) {
      this.id = id;
      this.idIsSet = true;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @Override
    public int getId() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static TSimpleValue4 fromJson(Json json) {
    TSimpleValue4.Builder builder = TSimpleValue4.builder();
    if (json.idIsSet) {
      builder.id(json.id);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Test4.SimpleValue4} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SimpleValue4 instance
   */
  public static TSimpleValue4 copyOf(Test4.SimpleValue4 instance) {
    if (instance instanceof TSimpleValue4) {
      return (TSimpleValue4) instance;
    }
    return TSimpleValue4.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link TSimpleValue4 TSimpleValue4}.
   * <pre>
   * TSimpleValue4.builder()
   *    .id(int) // required {@link Test4.SimpleValue4#getId() id}
   *    .name(String) // required {@link Test4.SimpleValue4#getName() name}
   *    .build();
   * </pre>
   * @return A new TSimpleValue4 builder
   */
  public static TSimpleValue4.Builder builder() {
    return new TSimpleValue4.Builder();
  }

  /**
   * Builds instances of type {@link TSimpleValue4 TSimpleValue4}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Test4.SimpleValue4", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private int id;
    private @Nullable String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code SimpleValue4} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Test4.SimpleValue4 instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.getId());
      name(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link Test4.SimpleValue4#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("id")
    public final Builder id(int id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Test4.SimpleValue4#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link TSimpleValue4 TSimpleValue4}.
     * @return An immutable instance of SimpleValue4
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public TSimpleValue4 build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new TSimpleValue4(id, name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build SimpleValue4, some of required attributes are not set " + attributes;
    }
  }
}
