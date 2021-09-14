package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortionImpl {
  public CrabPortion(double amount) {
    super(amount, new Crab());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("crab")) {
      return new CrabPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
