package com.comp301.a01sushi;

public class IngredientImpl implements Ingredient {
  private String name;
  private double calPerDollar;
  private int calPerOunce;
  private double pricePerOunce;
  private boolean isVegetarian;
  private boolean isRice;
  private boolean isShellfish;

  public IngredientImpl(
      String name,
      double pricePerOunce,
      int calPerOunce,
      boolean isVegetarian,
      boolean isRice,
      boolean isShellfish) {
    this.name = name;
    this.calPerOunce = calPerOunce;
    this.pricePerOunce = pricePerOunce;
    this.isVegetarian = isVegetarian;
    this.isRice = isRice;
    this.isShellfish = isShellfish;
    this.calPerDollar = calPerOunce / pricePerOunce;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return this.calPerDollar;
  }

  @Override
  public int getCaloriesPerOunce() {
    return this.calPerOunce;
  }

  @Override
  public double getPricePerOunce() {
    return this.pricePerOunce;
  }

  @Override
  public boolean getIsVegetarian() {
    return this.isVegetarian;
  }

  @Override
  public boolean getIsRice() {
    return this.isRice;
  }

  @Override
  public boolean getIsShellfish() {
    return this.isShellfish;
  }

  @Override
  public boolean equals(Ingredient other) {
    return name.equals(other.getName());
  }
}
