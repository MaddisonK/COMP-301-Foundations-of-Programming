package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.List;

public class SushiImpl implements Sushi {
  protected IngredientPortion[] ingredients;

  protected SushiImpl(IngredientPortion[] ingredients) {
    List<String> ingredientNames = new ArrayList<>();
    for (IngredientPortion ing : ingredients) {
      if (ing == null) {
        throw new IllegalArgumentException();
      }
      if (!ingredientNames.contains(ing.getName())) {
        ingredientNames.add(ing.getName());
      }
    }
    IngredientPortion[] ingredientsCondensed = new IngredientPortion[ingredientNames.size()];

    for (int n = 0; n < ingredientNames.size(); n++) {
      for (int i = 0; i < ingredients.length; i++) {
        if (ingredients[i].getName() == ingredientNames.get(n)) {
          if (ingredientsCondensed[n] == null) {
            ingredientsCondensed[n] = ingredients[i];
          } else {
            ingredientsCondensed[n] = ingredientsCondensed[n].combine(ingredients[i]);
          }
        }
      }
    }
    double seaweedAmount = 0;
    boolean seaweedAtAll = false;
    for (int i = 0; i < ingredientsCondensed.length; i++) {
      if (ingredientsCondensed[i].getName() == "seaweed") {
        seaweedAtAll = true;
        seaweedAmount += ingredientsCondensed[i].getAmount();
        if (seaweedAmount < .1) {
          ingredientsCondensed[i] =
              ingredientsCondensed[i].combine(new SeaweedPortion(.1 - seaweedAmount));
        }
      }
    }
    if (seaweedAtAll = true) {
      this.ingredients = ingredientsCondensed;
    }
    if (seaweedAmount == 0) {
      IngredientPortion[] ingredientsCondensedWithSeaweed =
          new IngredientPortion[ingredientsCondensed.length + 1];
      for (int i = 0; i < ingredientsCondensed.length; i++) {
        ingredientsCondensedWithSeaweed[i] = ingredientsCondensed[i];
      }
      ingredientsCondensedWithSeaweed[ingredientsCondensedWithSeaweed.length - 1] =
          new SeaweedPortion(.1);
      this.ingredients = ingredientsCondensedWithSeaweed;
    }
  }

  protected SushiImpl(Sashimi.SashimiType type) {
    IngredientPortion seafood = null;
    if (Sashimi.SashimiType.CRAB.equals(type)) {
      seafood = new CrabPortion(.75);
    } else if (Sashimi.SashimiType.EEL.equals(type)) {
      seafood = new EelPortion(.75);
    } else if (Sashimi.SashimiType.SHRIMP.equals(type)) {
      seafood = new ShrimpPortion(.75);
    } else if (Sashimi.SashimiType.TUNA.equals(type)) {
      seafood = new TunaPortion(.75);
    } else if (Sashimi.SashimiType.YELLOWTAIL.equals(type)) {
      seafood = new YellowtailPortion(.75);
    }
    ingredients = new IngredientPortion[] {seafood};
  }

  protected SushiImpl(Nigiri.NigiriType type) {
    IngredientPortion seafood = null;
    if (Nigiri.NigiriType.CRAB.equals(type)) {
      seafood = new CrabPortion(.75);
    } else if (Nigiri.NigiriType.EEL.equals(type)) {
      seafood = new EelPortion(.75);
    } else if (Nigiri.NigiriType.SHRIMP.equals(type)) {
      seafood = new ShrimpPortion(.75);
    } else if (Nigiri.NigiriType.TUNA.equals(type)) {
      seafood = new TunaPortion(.75);
    } else if (Nigiri.NigiriType.YELLOWTAIL.equals(type)) {
      seafood = new YellowtailPortion(.75);
    }
    ingredients = new IngredientPortion[] {seafood, new RicePortion(.5)};
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return ingredients.clone();
  }

  @Override
  public int getCalories() {
    double calCount = 0;
    for (IngredientPortion ingredient : ingredients) {
      calCount += ingredient.getCalories();
    }
    return round(calCount);
  }

  @Override
  public double getCost() {
    double costCount = 0;
    for (IngredientPortion ingredient : ingredients) {
      costCount += ingredient.getCost();
    }
    return Math.round(costCount * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    for (IngredientPortion ingredient : ingredients) {
      if (ingredient.getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion ingredient : ingredients) {
      if (ingredient.getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (IngredientPortion ingredient : ingredients) {
      if (!ingredient.getIsVegetarian()) {
        return false;
      }
    }
    return true;
  }

  private int round(double d) {
    int n = (int) d;
    if ((d - (double) n) >= .5) {
      return n + 1;
    } else {
      return n;
    }
  }
}
