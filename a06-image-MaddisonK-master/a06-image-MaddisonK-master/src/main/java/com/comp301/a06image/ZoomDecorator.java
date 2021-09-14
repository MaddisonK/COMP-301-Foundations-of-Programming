package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {
  Image image;
  int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (multiplier < 1 || image == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    return image.getPixelColor(x / multiplier, y / multiplier);
  }

  @Override
  public int getWidth() {
    return image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
