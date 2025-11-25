package com.roobie.collection.comparator.impl;

import com.roobie.collection.comparator.TaskComparator;
import com.roobie.collection.entity.impl.IntegerCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskCollectionTaskComparatorTest {
  static TaskComparator<IntegerCollection> taskComparator;
  static IntegerCollection collection11;
  static IntegerCollection collection12;
  static IntegerCollection collection21;
  static IntegerCollection collection22;
  static IntegerCollection collection31;
  static IntegerCollection collection32;

  @BeforeAll
  static void setUp() {
    taskComparator = new CollectionTaskComparator();
    collection11 = new IntegerCollection(new Integer[]{1, 2, 3});
    collection12 = new IntegerCollection(new Integer[]{1, 2, 3});

    collection21 = new IntegerCollection(new Integer[]{1, 2});
    collection22 = new IntegerCollection(new Integer[]{1, 2, 3});

    collection31 = new IntegerCollection(new Integer[]{1, 3, 4});
    collection32 = new IntegerCollection(new Integer[]{1, 2, 15});
  }

  @Test
  void compare1() {
    int expected = 0;
    int actual = taskComparator.compare(collection11, collection12);
    assertEquals(expected, actual);
  }

  @Test
  void compare2() {
    int expected = -1;
    int actual = taskComparator.compare(collection21, collection22);
    assertEquals(expected, actual);
  }

  @Test
  void compare3() {
    int expected = 1;
    int actual = taskComparator.compare(collection31, collection32);
    assertEquals(expected, actual);
  }
}