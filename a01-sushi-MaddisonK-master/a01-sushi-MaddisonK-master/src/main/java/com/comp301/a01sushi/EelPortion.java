package com.comp301.a01sushi;

public class EelPortion extends IngredientPortionImpl {
  public EelPortion(double amount) {
    super(amount, new Eel());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other.getName().equals("eel")) {
      return new EelPortion(this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
