package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    return name.equals(obj.toString());
  }

  public String toString() {
    return name;
  }
}
