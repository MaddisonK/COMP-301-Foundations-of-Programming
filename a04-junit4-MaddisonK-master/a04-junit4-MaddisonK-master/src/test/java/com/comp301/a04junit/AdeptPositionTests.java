package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;

import org.junit.Test;

import static org.junit.Assert.*;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }
  @Test
  public void getPositionTest() {
    Position pos = new PositionImpl(10, -15);
    assertEquals(10, pos.getX());
    assertEquals(-15, pos.getY());
    assertEquals(10, pos.getX());
    assertEquals(-15, pos.getY());
  }
  @Test
  public void testGetNeighborDirections() {
    Position pos = new PositionImpl(10, -15);
    assertEquals(11, pos.getNeighbor(Direction.EAST).getX());
    assertEquals(-15, pos.getNeighbor(Direction.EAST).getY());
    assertEquals(9, pos.getNeighbor(Direction.WEST).getX());
    assertEquals(-15, pos.getNeighbor(Direction.WEST).getY());
    assertEquals(10, pos.getNeighbor(Direction.NORTH).getX());
    assertEquals(-14, pos.getNeighbor(Direction.NORTH).getY());
    assertEquals(10, pos.getNeighbor(Direction.SOUTH).getX());
    assertEquals(-16, pos.getNeighbor(Direction.SOUTH).getY());
  }
  @Test
  public void testGetNeighborNull() {
    try {
    assertEquals(new PositionImpl(3,2), new PositionImpl(2,2).getNeighbor(null));
    fail();
    } catch (IllegalArgumentException i) {

    }
  }
}
