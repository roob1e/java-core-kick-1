package com.roobie.collection.service.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BasicCollectionServiceImplTest {
  IntegerCollection collection;
  BasicCollectionServiceImpl impl = new BasicCollectionServiceImpl();

  @BeforeEach
  void setUp() {
    collection = new IntegerCollection(new Integer[]{1, 2, 3});
  }

  @AfterEach
  void tearDown() {
    collection = null;
  }

  @Test
  void findMinElement() throws Exception {
    int expected = 1;
    int actual = impl.findMinElement(collection);
    assertEquals(expected, actual);
  }

  @Test
  void findMaxElement() throws Exception {
    int expected = 3;
    int actual = impl.findMaxElement(collection);
    assertEquals(expected, actual);
  }

  @Test
  void replaceElement() throws Exception {
    int newValue = 0;
    int expected = 0;
    int actual = impl.replaceElement(collection, newValue, 2);
    assertEquals(expected, actual);
  }

  @Test
  void defineAverageValue() throws Exception {
    double expected = 2.0;
    double actual = impl.defineAverageValue(collection);
    assertEquals(expected, actual);
  }

  @Test
  void defineSum() throws Exception {
    int expected = 6;
    int actual = impl.defineSum(collection);
    assertEquals(expected, actual);
  }

  @Test
  void countPositivesAndNegatives() throws Exception {
    HashMap<String, Integer> expected = new HashMap<>();
    expected.put("positive", 3);
    expected.put("negative", 0);
    expected.put("zero", 0);
    HashMap<String, Integer> actual = impl.countPositivesAndNegatives(collection);
    assertEquals(expected, actual);
  }
}