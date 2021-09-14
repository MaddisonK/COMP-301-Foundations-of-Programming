package com.comp301.a08shopping;

import com.comp301.a08shopping.exceptions.OutOfStockException;

public class ProductImpl implements Product {
  private String name;
  private double basePrice;
  private int quantity;
  private double sellPrice;

  public ProductImpl(String name, double basePrice) {
    if (basePrice <= 0.0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.basePrice = basePrice;
    this.sellPrice = basePrice;
  }

  public ProductImpl(String name, double basePrice, int quantity) {
    if (basePrice <= 0.0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.basePrice = basePrice;
    this.quantity = quantity;
    this.sellPrice = basePrice;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBasePrice() {
    return basePrice;
  }

  public boolean outOfStock() {
    return (quantity == 0);
  }

  public int getQuantity() {
    return quantity;
  }

  public void restockProduct(int amount) {
    quantity += amount;
  }

  public double purchaseProduct() {
    if (quantity > 0) {
      quantity--;
      return sellPrice;
    } else {
      throw new OutOfStockException();
    }
  }

  public double getSellPrice() {
    return sellPrice;
  }

  public void discount(double percentOff) {
    this.sellPrice = basePrice * ((1.0 - percentOff));
  }

  public void revert() {
    this.sellPrice = this.basePrice;
  }
}
