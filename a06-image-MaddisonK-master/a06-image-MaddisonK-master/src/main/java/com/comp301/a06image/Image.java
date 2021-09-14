package com.comp301.a06image;

import java.awt.Color;

public interface Image {
  /**
   * Getter method to retrieve the color of a particular pixel in the image. Parameters x and y must
   * be non-negative, and must be less than the width and height of the image, respectively.
   *
   * @param x The x coordinate of the pixel
   * @param y The y coordinate of the pixel
   * @return The color of the pixel located at position (x, y)
   */
  Color getPixelColor(int x, int y);

  /** Getter method for the number of pixels in the horizontal direction of the image */
  int getWidth();

  /** Getter method for the number of pixels in the vertical direction of the image */
  int getHeight();

  /** Getter method for the number of layers in the image */
  int getNumLayers();
}
