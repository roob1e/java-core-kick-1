package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.util.Sign;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AverageSpecificationTest {
  AverageSpecification specification;

  @BeforeEach
  void setUp() {
    specification = new AverageSpecification(3.1D, Sign.LESS);
  }

  @AfterEach
  void tearDown() {
    specification = null;
  }

  @Test
  void specify1() throws IntegerCollectionException {
    boolean expected = true;

    IntegerCollection collection = new IntegerCollection(new Integer[]{1, 2, 3});
    boolean actual = specification.specify(collection);

    assertEquals(expected, actual);
  }

  @Test
  void specify2() throws IntegerCollectionException {
    boolean expected = false;

    IntegerCollection collection = new IntegerCollection(new Integer[]{4, 5, 6});
    boolean actual = specification.specify(collection);

    assertEquals(expected, actual);
  }
}
