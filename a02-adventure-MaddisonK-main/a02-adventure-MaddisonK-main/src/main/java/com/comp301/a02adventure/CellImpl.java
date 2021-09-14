package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private Position position;
  private String name;
  private String desc;
  private Inventory chest;
  private boolean visited = false;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    if (description == null) {
      throw new IllegalArgumentException();
    }
    position = new PositionImpl(x, y);
    this.name = name;
    this.desc = description;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return desc;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Inventory getChest() {
    return chest;
  }

  @Override
  public boolean getIsVisited() {
    return visited;
  }

  @Override
  public boolean hasChest() {
    return (!(chest == null));
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException();
    }
    desc = description;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException();
    }
    this.chest = chest;
  }

  @Override
  public void visit() {
    visited = true;
  }
}
