package org.belldj;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Immutables.FoobarValue}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code TFoobarValue.builder()}.
 */
@Generated(from = "Immutables.FoobarValue", generator = "Immutables")
@SuppressWarnings({"all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class TFoobarValue implements Immutables.FoobarValue {
  private final int id;
  private final int foo;
  private final @Nullable String bar;
  private final List<Integer> buz;
  private final Set<Long> crux;

  private TFoobarValue(
      int id,
      int foo,
      @Nullable String bar,
      List<Integer> buz,
      Set<Long> crux) {
    this.id = id;
    this.foo = foo;
    this.bar = bar;
    this.buz = buz;
    this.crux = crux;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   * @return The value of the {@code foo} attribute
   */
  @Override
  public int getFoo() {
    return foo;
  }

  /**
   * @return The value of the {@code bar} attribute
   */
  @Override
  public Optional<String> getBar() {
    return Optional.ofNullable(bar);
  }

  /**
   * @return The value of the {@code buz} attribute
   */
  @Override
  public List<Integer> getBuz() {
    return buz;
  }

  /**
   * @return The value of the {@code crux} attribute
   */
  @Override
  public Set<Long> getCrux() {
    return crux;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Immutables.FoobarValue#getId() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final TFoobarValue withId(int value) {
    if (this.id == value) return this;
    return new TFoobarValue(value, this.foo, this.bar, this.buz, this.crux);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Immutables.FoobarValue#getFoo() foo} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for foo
   * @return A modified copy of the {@code this} object
   */
  public final TFoobarValue withFoo(int value) {
    if (this.foo == value) return this;
    return new TFoobarValue(this.id, value, this.bar, this.buz, this.crux);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Immutables.FoobarValue#getBar() bar} attribute.
   * @param value The value for bar
   * @return A modified copy of {@code this} object
   */
  public final TFoobarValue withBar(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "bar");
    if (Objects.equals(this.bar, newValue)) return this;
    return new TFoobarValue(this.id, this.foo, newValue, this.buz, this.crux);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Immutables.FoobarValue#getBar() bar} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for bar
   * @return A modified copy of {@code this} object
   */
  public final TFoobarValue withBar(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.bar, value)) return this;
    return new TFoobarValue(this.id, this.foo, value, this.buz, this.crux);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Immutables.FoobarValue#getBuz() buz}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final TFoobarValue withBuz(int... elements) {
    ArrayList<Integer> wrappedList = new ArrayList<>(elements.length);
    for (int element : elements) {
      wrappedList.add(element);
    }
    List<Integer> newValue = createUnmodifiableList(false, wrappedList);
    return new TFoobarValue(this.id, this.foo, this.bar, newValue, this.crux);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Immutables.FoobarValue#getBuz() buz}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of buz elements to set
   * @return A modified copy of {@code this} object
   */
  public final TFoobarValue withBuz(Iterable<Integer> elements) {
    if (this.buz == elements) return this;
    List<Integer> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new TFoobarValue(this.id, this.foo, this.bar, newValue, this.crux);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Immutables.FoobarValue#getCrux() crux}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final TFoobarValue withCrux(long... elements) {
    ArrayList<Long> wrappedList = new ArrayList<>(elements.length);
    for (long element : elements) {
      wrappedList.add(element);
    }
    Set<Long> newValue = createUnmodifiableSet(wrappedList);
    return new TFoobarValue(this.id, this.foo, this.bar, this.buz, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Immutables.FoobarValue#getCrux() crux}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of crux elements to set
   * @return A modified copy of {@code this} object
   */
  public final TFoobarValue withCrux(Iterable<Long> elements) {
    if (this.crux == elements) return this;
    Set<Long> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new TFoobarValue(this.id, this.foo, this.bar, this.buz, newValue);
  }

  /**
   * This instance is equal to all instances of {@code TFoobarValue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof TFoobarValue
        && equalTo((TFoobarValue) another);
  }

  private boolean equalTo(TFoobarValue another) {
    return id == another.id
        && foo == another.foo
        && Objects.equals(bar, another.bar)
        && buz.equals(another.buz)
        && crux.equals(another.crux);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code foo}, {@code bar}, {@code buz}, {@code crux}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id;
    h += (h << 5) + foo;
    h += (h << 5) + Objects.hashCode(bar);
    h += (h << 5) + buz.hashCode();
    h += (h << 5) + crux.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code FoobarValue} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("FoobarValue{");
    builder.append("id=").append(id);
    builder.append(", ");
    builder.append("foo=").append(foo);
    if (bar != null) {
      builder.append(", ");
      builder.append("bar=").append(bar);
    }
    builder.append(", ");
    builder.append("buz=").append(buz);
    builder.append(", ");
    builder.append("crux=").append(crux);
    return builder.append("}").toString();
  }

  /**
   * Creates an immutable copy of a {@link Immutables.FoobarValue} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FoobarValue instance
   */
  public static TFoobarValue copyOf(Immutables.FoobarValue instance) {
    if (instance instanceof TFoobarValue) {
      return (TFoobarValue) instance;
    }
    return TFoobarValue.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link TFoobarValue TFoobarValue}.
   * <pre>
   * TFoobarValue.builder()
   *    .id(int) // required {@link Immutables.FoobarValue#getId() id}
   *    .foo(int) // required {@link Immutables.FoobarValue#getFoo() foo}
   *    .bar(String) // optional {@link Immutables.FoobarValue#getBar() bar}
   *    .addBuz|addAllBuz(int) // {@link Immutables.FoobarValue#getBuz() buz} elements
   *    .addCrux|addAllCrux(long) // {@link Immutables.FoobarValue#getCrux() crux} elements
   *    .build();
   * </pre>
   * @return A new TFoobarValue builder
   */
  public static TFoobarValue.Builder builder() {
    return new TFoobarValue.Builder();
  }

  /**
   * Builds instances of type {@link TFoobarValue TFoobarValue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Immutables.FoobarValue", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_FOO = 0x2L;
    private long initBits = 0x3L;

    private int id;
    private int foo;
    private @Nullable String bar;
    private List<Integer> buz = new ArrayList<Integer>();
    private List<Long> crux = new ArrayList<Long>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FoobarValue} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Immutables.FoobarValue instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.getId());
      foo(instance.getFoo());
      Optional<String> barOptional = instance.getBar();
      if (barOptional.isPresent()) {
        bar(barOptional);
      }
      addAllBuz(instance.getBuz());
      addAllCrux(instance.getCrux());
      return this;
    }

    /**
     * Initializes the value for the {@link Immutables.FoobarValue#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(int id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Immutables.FoobarValue#getFoo() foo} attribute.
     * @param foo The value for foo 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder foo(int foo) {
      this.foo = foo;
      initBits &= ~INIT_BIT_FOO;
      return this;
    }

    /**
     * Initializes the optional value {@link Immutables.FoobarValue#getBar() bar} to bar.
     * @param bar The value for bar
     * @return {@code this} builder for chained invocation
     */
    public final Builder bar(String bar) {
      this.bar = Objects.requireNonNull(bar, "bar");
      return this;
    }

    /**
     * Initializes the optional value {@link Immutables.FoobarValue#getBar() bar} to bar.
     * @param bar The value for bar
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder bar(Optional<String> bar) {
      this.bar = bar.orElse(null);
      return this;
    }

    /**
     * Adds one element to {@link Immutables.FoobarValue#getBuz() buz} list.
     * @param element A buz element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addBuz(int element) {
      this.buz.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Immutables.FoobarValue#getBuz() buz} list.
     * @param elements An array of buz elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addBuz(int... elements) {
      for (int element : elements) {
        this.buz.add(element);
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Immutables.FoobarValue#getBuz() buz} list.
     * @param elements An iterable of buz elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder buz(Iterable<Integer> elements) {
      this.buz.clear();
      return addAllBuz(elements);
    }

    /**
     * Adds elements to {@link Immutables.FoobarValue#getBuz() buz} list.
     * @param elements An iterable of buz elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllBuz(Iterable<Integer> elements) {
      for (int element : elements) {
        this.buz.add(Objects.requireNonNull(element, "buz element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link Immutables.FoobarValue#getCrux() crux} set.
     * @param element A crux element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCrux(long element) {
      this.crux.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Immutables.FoobarValue#getCrux() crux} set.
     * @param elements An array of crux elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCrux(long... elements) {
      for (long element : elements) {
        this.crux.add(element);
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Immutables.FoobarValue#getCrux() crux} set.
     * @param elements An iterable of crux elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder crux(Iterable<Long> elements) {
      this.crux.clear();
      return addAllCrux(elements);
    }

    /**
     * Adds elements to {@link Immutables.FoobarValue#getCrux() crux} set.
     * @param elements An iterable of crux elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllCrux(Iterable<Long> elements) {
      for (long element : elements) {
        this.crux.add(Objects.requireNonNull(element, "crux element"));
      }
      return this;
    }

    /**
     * Builds a new {@link TFoobarValue TFoobarValue}.
     * @return An immutable instance of FoobarValue
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public TFoobarValue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new TFoobarValue(id, foo, bar, createUnmodifiableList(true, buz), createUnmodifiableSet(crux));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_FOO) != 0) attributes.add("foo");
      return "Cannot build FoobarValue, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }

  /** Unmodifiable set constructed from list to avoid rehashing. */
  private static <T> Set<T> createUnmodifiableSet(List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptySet();
    case 1: return Collections.singleton(list.get(0));
    default:
      Set<T> set = new LinkedHashSet<>(list.size());
      set.addAll(list);
      return Collections.unmodifiableSet(set);
    }
  }
}
