package com.roobie.collection.exception;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.factory.impl.IntegerCollectionFactory;
import com.roobie.collection.service.impl.BasicCollectionServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCollectionExceptionTest {
  IntegerCollection collection;
  BasicCollectionServiceImpl impl = new BasicCollectionServiceImpl();

  @BeforeEach
  void setUp() throws IntegerCollectionException {
    collection = new IntegerCollectionFactory().createEmpty();
  }

  @AfterEach
  void tearDown() {
    collection = null;
  }

  @Test
  void findMinElement() {
    Exception exception = assertThrows(IntegerCollectionException.class, () -> {
      impl.findMinElement(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void findMaxElement() {
    Exception exception = assertThrows(IntegerCollectionException.class, () -> {
      impl.findMaxElement(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void defineAverageValue() {
    Exception exception = assertThrows(IntegerCollectionException.class, () -> {
      impl.defineAverageValue(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void defineSum() {
    Exception exception = assertThrows(IntegerCollectionException.class, () -> {
      impl.defineSum(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void countPositivesAndNegatives() {
    Exception exception = assertThrows(IntegerCollectionException.class, () -> {
      impl.countPositivesAndNegatives(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }
}