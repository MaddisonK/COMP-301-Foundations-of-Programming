package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private int x;
  private int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    if (direction == Direction.EAST) {
      return new PositionImpl(x + 1, y);
    }
    if (direction == Direction.NORTH) {
      return new PositionImpl(x, y + 1);
    }
    if (direction == Direction.WEST) {
      return new PositionImpl(x - 1, y);
    }
    if (direction == Direction.SOUTH) {
      return new PositionImpl(x, y - 1);
    }
    throw new IllegalArgumentException();
  }
}
