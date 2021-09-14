package com.comp301.a07pizza;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        List tops = new ArrayList();
        tops.add(Topping.GARLIC);
        tops.add(Topping.MUSHROOMS);
        Pizza first_pizza = new PizzaImpl(Pizza.Size.SMALL, Crust.DEEP_DISH, Sauce.PESTO, Cheese.MOZZARELLA, tops);
        for (Ingredient ingred: first_pizza.getIngredients()) {
            System.out.println(ingred.getName());
        }
        assertTrue( true );
    }



}
