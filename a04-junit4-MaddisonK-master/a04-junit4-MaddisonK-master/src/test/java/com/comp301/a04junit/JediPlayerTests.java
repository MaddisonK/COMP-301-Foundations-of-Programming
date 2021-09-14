package com.comp301.a04junit;

import com.comp301.a04junit.adventure.*;

import org.junit.Test;

import static org.junit.Assert.*;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }
  @Test
  public void illegalNametest() {
    try {
    Player player = new PlayerImpl(null, 0, 0);
    fail();
    } catch (IllegalArgumentException i) {

    }
  }
  @Test
  public void goodPlayerTest() {
    Player player = new PlayerImpl("Rob", 15, 32);
    assertEquals("Rob", player.getName());
    assertEquals(15, player.getPosition().getX());
    assertEquals(32, player.getPosition().getY());
  }

  @Test
  public void movePlayerTest() {
    Player player = new PlayerImpl("Rob", 15, 32);
    player.move(Direction.NORTH);
    assertEquals(33, player.getPosition().getY());
    player.move(Direction.EAST);
    player.move(Direction.SOUTH);
    player.move(Direction.SOUTH);
    assertEquals(16, player.getPosition().getX());
    assertEquals(31, player.getPosition().getY());
    player.move(Direction.WEST);
    player.move(Direction.WEST);
    assertEquals(14, player.getPosition().getX());
  }
  @Test
  public void playerInventoryTest() {
    Player player = new PlayerImpl("Rob", 15, 32);
    assertEquals(0, player.getInventory().getNumItems());
    player.getInventory().addItem(new ItemImpl("shoe"));
    player.getInventory().addItem(new ItemImpl("apple"));
    assertEquals(2, player.getInventory().getNumItems());
  }
}
