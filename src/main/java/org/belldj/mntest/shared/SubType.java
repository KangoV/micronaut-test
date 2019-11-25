package org.belldj.mntest.shared;

public enum SubType {

  SYMBOL(Type.ITEM),
  SYMBOL_SET(Type.PART);

  private Type type;

  private SubType(Type type) {
    this.type = type;
  }

  public Type getType() {
    return this.type;
  }
}
