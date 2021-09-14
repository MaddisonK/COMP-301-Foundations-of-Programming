package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
  Image image;
  int thiccness;
  Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (image == null || thiccness < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    //
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    if ((x >= 0 && x < thiccness) || (x >= image.getWidth() + thiccness && x < getWidth())) {
      return borderColor;
    }
    if ((y >= 0 && y < thiccness) || (y >= image.getHeight() + thiccness && y < getHeight())) {
      return borderColor;
    }
    return image.getPixelColor(x - thiccness, y - thiccness);
  }

  @Override
  public int getWidth() {
    return image.getWidth() + thiccness * 2;
  }

  @Override
  public int getHeight() {
    return image.getHeight() + thiccness * 2;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
