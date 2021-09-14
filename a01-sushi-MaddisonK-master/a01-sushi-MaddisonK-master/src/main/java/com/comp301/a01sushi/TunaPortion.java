package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortionImpl {
  public TunaPortion(double amount) {
    super(amount, new Tuna());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("tuna")) {
      return new TunaPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
