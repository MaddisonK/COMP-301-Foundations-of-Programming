package com.comp301.a01sushi;

public class Sashimi extends SushiImpl {
  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  };

  private IngredientPortion seafood;

  public Sashimi(SashimiType type) {
    super(type);
    seafood = ingredients[0];
  }

  @Override
  public String getName() {
    return seafood.getName() + " " + "sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {seafood};
  }
}
