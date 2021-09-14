package com.comp301.a01sushi;

public class YellowtailPortion extends IngredientPortionImpl {
  public YellowtailPortion(double amount) {
    super(amount, new Yellowtail());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("yellowtail")) {
      return new YellowtailPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
