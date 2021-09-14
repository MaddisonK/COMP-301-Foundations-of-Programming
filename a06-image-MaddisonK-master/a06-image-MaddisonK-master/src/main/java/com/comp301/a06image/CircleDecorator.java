package com.comp301.a06image;

import java.awt.*;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class CircleDecorator implements Image {
  Image image;
  int cx;
  int cy;
  int radius;
  Color color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null || radius < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.cx = cx;
    this.cy = cy;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (distance(x, y, cx, cy) < radius) {
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

  private double distance(int x1, int y1, int x2, int y2) {
    // Calculating distance
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2) * 1.0);
  }
}
