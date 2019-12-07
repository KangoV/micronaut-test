package org.belldj.mntest.shared;

public enum Type {

  SYMBOL     (Category.ITEM),
  REEL       (Category.ITEM),
  AWARD      (Category.ITEM),
  
  SYMBOL_SET (Category.PART),
  REEL_SET   (Category.PART),
  AWARD_SET  (Category.PART);

  private Category catagory;

  private Type(Category category) {
    this.catagory = category;
  }

  public Category getCategory() {
    return this.catagory;
  }
}
