package com.comp301.a01sushi;

public class RicePortion extends IngredientPortionImpl {
  public RicePortion(double amount) {
    super(amount, new Rice());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("rice")) {
      return new RicePortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
