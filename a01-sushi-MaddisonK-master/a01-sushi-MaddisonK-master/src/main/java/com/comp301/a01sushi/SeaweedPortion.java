package com.comp301.a01sushi;

public class SeaweedPortion extends IngredientPortionImpl {
  public SeaweedPortion(double amount) {
    super(amount, new Seaweed());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("seaweed")) {
      return new SeaweedPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
