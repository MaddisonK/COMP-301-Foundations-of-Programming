package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;

import org.junit.Test;

import static org.junit.Assert.*;

/** Write unit tests for the ItemImpl class here */
public class AdeptItemTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

  @Test
  public void nullNameTest() {
    try {
      new ItemImpl(null);
      fail();
    } catch (IllegalArgumentException e) {

    }
  }

  @Test
  public void getNameTest() {
    Item item = new ItemImpl("book");
    assertEquals(item.getName(), "book");
  }

  @Test
  public void toStringTest() {
    Item item = new ItemImpl("book");
    assertEquals(item.toString(), "book");
  }

  @Test
  public void equalsTest() {
    Item item1 = new ItemImpl("book");
    Item item2 = new ItemImpl("book");
    assertEquals(item1, item2);
  }

  @Test
  public void nullEqualsTest() {
    Item item1 = new ItemImpl("book");
    assertNotEquals(null, item1);
  }
}
