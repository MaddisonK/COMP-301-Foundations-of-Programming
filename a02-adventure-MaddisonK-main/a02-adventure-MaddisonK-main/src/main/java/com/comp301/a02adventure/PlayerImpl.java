package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private String name;
  private Position position;
  private Inventory inventory;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.position = new PositionImpl(startX, startY);
    this.inventory = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Inventory getInventory() {
    return inventory;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void move(Direction direction) {
    position = position.getNeighbor(direction);
  }
}
