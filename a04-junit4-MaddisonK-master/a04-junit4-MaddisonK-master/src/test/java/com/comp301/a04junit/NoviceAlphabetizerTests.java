package com.comp301.a04junit;

import com.comp301.a04junit.alphabetizer.Alphabetizer;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/** Write tests for the Alphabetizer class here */
public class NoviceAlphabetizerTests {
  @Test
  public void unitTest1() {
    Alphabetizer al = new Alphabetizer(new String[] {"copper", "banana", "apple"});
    assertEquals("apple", al.next());
    assertTrue(al.hasNext());
    assertEquals("banana", al.next());
    assertTrue(al.hasNext());
    assertEquals(al.next(), "copper");
    assertFalse(al.hasNext());
  }

  @Test
  public void unitTest2() {
    try {
      Alphabetizer al = new Alphabetizer(new String[] {"copper", "banana", "apple"});
      assertEquals("apple", al.next());
      assertTrue(al.hasNext());
      assertEquals("banana", al.next());
      assertTrue(al.hasNext());
      assertEquals(al.next(), "copper");
      al.next();
      fail();
    } catch (NoSuchElementException e) {

    }
  }

  @Test
  public void numberest() {
    try {
      Alphabetizer al = new Alphabetizer(new String[] {"1", "5", "3"});
      assertEquals("1", al.next());
      assertEquals("3", al.next());
      assertEquals("5", al.next());
    } catch (IllegalArgumentException i) {

    }
  }

  @Test
  public void capitalTest() {
    try {
      Alphabetizer al = new Alphabetizer(new String[] {"A", "a"});
      assertEquals("A", al.next());
      assertEquals("a", al.next());
    } catch (IllegalArgumentException i) {

    }
  }

  @Test
  public void refTest() {
    String[] list = new String[] {"a", "b", "c"};
    Alphabetizer al = new Alphabetizer(list);
    list[2] = "d";
    assertEquals("a", al.next());
    assertEquals("b", al.next());
    assertEquals("c", al.next());
  }

  @Test
  public void paramVal() {
      Alphabetizer al = new Alphabetizer(null);
  }
}

  //  @Test
  //  public void prviateTest() {
  //    try {
  //      Alphabetizer al = new Alphabetizer(null);
  //      al.sorted = null;
  //      fail();
  //    } catch (Exception e) {
  //
  //    }
  //  }
  //  @Test
  //  public void unitTest3() {
  //      Alphabetizer al = new Alphabetizer(new String[] {"Apple", "apple", "Banana", "banana"});
  //      assertEquals("Apple", al.next());
  //      assertTrue(al.hasNext());
  //      assertEquals("apple", al.next());
  //      assertTrue(al.hasNext());
  //      assertEquals("Banana", al.next());
  //      assertFalse(al.hasNext());
  //      assertEquals("banana", al.next());
  //  }
