package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

  @Test
  public void testIsEmpty() {
    Inventory inv = new InventoryImpl();
    assertTrue(inv.isEmpty());
  }

  @Test
  public void testGetSize() {
    Inventory inv = new InventoryImpl();
    inv.addItem(new ItemImpl("book"));
    inv.addItem(new ItemImpl("apple"));
    assertEquals(2, inv.getNumItems());
    inv.removeItem(inv.getItems().get(0));
    assertEquals(1, inv.getNumItems());
    inv.clear();
    assertEquals(0, inv.getNumItems());
  }

  @Test
  public void testTransferFrom() {
    Inventory inv = new InventoryImpl();
    assertEquals(0, inv.getNumItems());
    inv.addItem(new ItemImpl("worm"));
    Inventory inv2 = new InventoryImpl();
    inv2.addItem(new ItemImpl("book"));
    inv2.addItem(new ItemImpl("apple"));
    inv.transferFrom(inv2);
    assertEquals(3, inv.getNumItems());
    assertEquals("worm", inv.getItems().get(0).toString());
    assertEquals("book", inv.getItems().get(1).toString());
    assertEquals("apple", inv.getItems().get(2).toString());
    assertEquals(0, inv2.getNumItems());
  }

  @Test
  public void nullTransferTest() {
    Inventory inv = new InventoryImpl();
    inv.addItem(new ItemImpl("worm"));
    inv.transferFrom(null);
    assertEquals(1,inv.getNumItems());
    }
}
