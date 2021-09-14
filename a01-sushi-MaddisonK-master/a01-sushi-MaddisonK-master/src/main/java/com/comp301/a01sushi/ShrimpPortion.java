package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortionImpl {
  public ShrimpPortion(double amount) {
    super(amount, new Shrimp());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("shrimp")) {
      return new ShrimpPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
