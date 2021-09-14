package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private List<Item> items;

  public InventoryImpl() {
    this.items = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    return items.isEmpty();
  }

  @Override
  public int getNumItems() {
    return items.size();
  }

  @Override
  public List<Item> getItems() {
    return new ArrayList<Item>(items);
  }

  @Override
  public void addItem(Item item) {
    items.add(item);
  }

  @Override
  public void removeItem(Item item) {
    items.remove(item);
  }

  @Override
  public void clear() {
    items.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    for (Item item : other.getItems()) {
      items.add(item);
    }
    other.clear();
  }
}
