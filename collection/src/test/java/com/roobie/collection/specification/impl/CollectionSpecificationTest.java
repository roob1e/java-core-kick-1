package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionSpecificationTest {
  CollectionSpecification specification;

  @BeforeEach
  void setUp() {
    specification = new CollectionSpecification(new Integer[]{1, 2, 3});
  }

  @AfterEach
  void tearDown() {
    specification = null;
  }

  @Test
  void specify1() {
    boolean expected = true;

    IntegerCollection collection = new IntegerCollection(new Integer[]{1, 2, 3});
    boolean actual = specification.specify(collection);

    assertEquals(expected, actual);
  }

  @Test
  void specify2() {
    boolean expected = false;

    IntegerCollection collection = new IntegerCollection(new Integer[0]);
    boolean actual = specification.specify(collection);

    assertEquals(expected, actual);
  }
}