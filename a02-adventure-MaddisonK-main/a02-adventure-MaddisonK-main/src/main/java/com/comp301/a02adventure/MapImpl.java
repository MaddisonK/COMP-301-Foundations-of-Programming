package com.comp301.a02adventure;

public class MapImpl implements Map {
  private int width;
  private int height;
  private int numItems;
  private Cell[][] grid;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }

    this.width = width;
    this.height = height;
    this.numItems = numItems;
    grid = new Cell[width][height];
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if ((x >= width) || (x < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if ((y >= height) || (y < 0)) {
      throw new IndexOutOfBoundsException();
    }
    return grid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if ((position.getX() >= width) || (position.getX() < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if ((position.getY() >= height) || (position.getY() < 0)) {
      throw new IndexOutOfBoundsException();
    }
    return getCell(position.getX(), position.getY());
  }

  @Override
  public void initCell(int x, int y) {
    if ((x >= width) || (x < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if ((y >= height) || (y < 0)) {
      throw new IndexOutOfBoundsException();
    }
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
