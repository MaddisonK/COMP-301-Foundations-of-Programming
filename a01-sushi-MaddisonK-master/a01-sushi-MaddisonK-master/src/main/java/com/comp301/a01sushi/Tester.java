package com.comp301.a01sushi;

public class Tester {
  public static void main(String[] args) {
    Sushi eel_roll =
        new Roll(
            "eel roll",
            new IngredientPortion[] {
              new EelPortion(5),
              new RicePortion(3),
              new AvocadoPortion(2),
              new EelPortion(5),
              new SeaweedPortion(.05)
            });
    for (IngredientPortion ingred : eel_roll.getIngredients()) {
      System.out.println(ingred.getAmount());
    }
  }
}
