package com.comp301.a01sushi;

public class Roll extends SushiImpl {
  private String name;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    super(roll_ingredients);
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
