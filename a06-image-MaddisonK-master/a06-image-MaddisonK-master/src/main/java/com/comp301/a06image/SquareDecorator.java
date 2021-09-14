package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {
  Image image;
  int squareX;
  int squareY;
  int squareSize;
  Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if ((squareX <= x && x < (squareSize + squareX))
        && (squareY <= y && y < (squareSize + squareY))) {
      return color;
    }
    return image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
