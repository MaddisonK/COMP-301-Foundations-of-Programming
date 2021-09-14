package com.comp301.a07pizza;

import java.util.List;

public final class PizzaImpl implements Pizza {
  private Size size;
  private Crust crust;
  private Sauce sauce;
  private Cheese cheese;
  private List<Ingredient> toppings;

  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, List<Ingredient> toppings) {
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    this.toppings = toppings;
  }

  @Override
  public boolean isVegetarian() {
    if (crust.isVegetarian() && sauce.isVegetarian() && cheese.isVegetarian()) {
      for (Ingredient item : toppings) {
        if (!item.isVegetarian()) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  @Override
  public boolean isVegan() {
    boolean tops = true;
    for (Ingredient item : toppings) {
      if (!item.isVegetarian()) {
        tops = false;
        break;
      }
    }
    return (crust.isVegan() && sauce.isVegan() && cheese.isVegan() && tops);
  }

  @Override
  public double getPrice() {
    double price = 0.0;
    if (size == Size.SMALL) {
      price = 7.00;
      for (Ingredient item : toppings) {
        price += .25;
      }
    }
    if (size == Size.MEDIUM) {
      price = 9.00;
      for (Ingredient item : toppings) {
        price += .50;
      }
    }
    if (size == Size.LARGE) {
      price = 11.00;
      for (Ingredient item : toppings) {
        price += .75;
      }
    }
    return price;
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public Ingredient getSauce() {
    return sauce;
  }

  @Override
  public Ingredient getCheese() {
    return cheese;
  }

  @Override
  public Ingredient getCrust() {
    return crust;
  }

  @Override
  public Ingredient[] getToppings() {
    Ingredient[] ingredients = new Ingredient[toppings.size()];
    for (int i = 0; i < toppings.size(); i++) {
      ingredients[i] = toppings.get(i);
    }
    return ingredients;
  }

  @Override
  public Ingredient[] getIngredients() {
    Ingredient[] ingredients = new Ingredient[toppings.size() + 3];
    for (int i = 0; i < toppings.size(); i++) {
      ingredients[i] = toppings.get(i);
    }
    ingredients[toppings.size()] = crust;
    ingredients[toppings.size() + 1] = sauce;
    ingredients[toppings.size() + 2] = cheese;
    return ingredients;
  }
}
