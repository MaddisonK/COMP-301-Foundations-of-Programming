package com.comp301.a01sushi;

public class AvocadoPortion extends IngredientPortionImpl {
  public AvocadoPortion(double amount) {
    super(amount, new Avocado());
  }

  @Override
  public AvocadoPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (other.getName().equals("avocado")) {
      return new AvocadoPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}

