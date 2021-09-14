package com.comp301.a01sushi;

public class Nigiri extends SushiImpl {
  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  };

  private IngredientPortion seafood;

  public Nigiri(NigiriType type) {
    super(type);
    seafood = ingredients[0];
  }

  @Override
  public String getName() {
    return seafood.getName() + " " + "nigiri";
  }
}
