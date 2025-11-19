package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.specification.impl.AverageSpecification;
import com.roobie.collection.specification.impl.CollectionSpecification;
import com.roobie.collection.specification.impl.IdSpecification;
import com.roobie.collection.util.Sign;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CollectionRepositoryImplTest {
  static CollectionRepositoryImpl repository = CollectionRepositoryImpl.getInstance();
  IdSpecification idSpecification;
  CollectionSpecification collectionSpecification;
  List<IntegerCollection> collections;

  @BeforeAll
  static void setUp() {
    IntegerCollection collection1 = new IntegerCollection(new Integer[]{1, 2, 3});
    IntegerCollection collection2 = new IntegerCollection(new Integer[]{4, 5, 6});
    IntegerCollection collection3 = new IntegerCollection(new Integer[]{7, 8, 9});
    IntegerCollection collection4 = new IntegerCollection(new Integer[]{10, 11, 12});
    repository.add(collection1);
    repository.add(collection2);
    repository.add(collection3);
    repository.add(collection4);
  }

  @Test
  @Order(1)
  void queryById() throws IntegerCollectionException {
    Integer[] expected = new Integer[]{1, 2, 3};
    idSpecification = new IdSpecification(1);

    Optional<List<IntegerCollection>> result = repository.query(idSpecification);
    if (result.isPresent()) {
      collections = result.get();
      Integer[] actual = collections.getFirst().getCollection();
      assertArrayEquals(expected, actual);
    } else {
      fail("Collection not found");
    }
  }

  @Test
  @Order(2)
  void queryByCollection() throws IntegerCollectionException {
    Integer[] expected = new Integer[]{1, 2, 3};
    collectionSpecification = new CollectionSpecification(new Integer[]{1, 2, 3});

    Optional<List<IntegerCollection>> result = repository.query(collectionSpecification);
    if (result.isPresent()) {
      collections = result.get();
      Integer[] actual = collections.getFirst().getCollection();
      assertArrayEquals(expected, actual);
    } else {
      fail("Collection not found");
    }
  }

  @Test
  @Order(3)
  void queryByAverage() throws IntegerCollectionException {
    Integer[] expected = new Integer[]{1, 2, 3};

    double averageValue = 3.1;
    Specification specification = new AverageSpecification(averageValue, Sign.LESS);

    List<IntegerCollection> result = repository.query(specification).get();
    Integer[] actual = result.getFirst().getCollection();
    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(5)
  void add() {
    repository.resetStorage();
    Integer[] expected = new Integer[]{1, 2, 3};

    IntegerCollection collection = new IntegerCollection(new Integer[]{1, 2, 3});
    IntegerCollection result = repository.add(collection).getFirst();
    Integer[] actual = result.getCollection();

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(4)
  void remove() {
    var collection = new IntegerCollection(new Integer[]{1, 2, 3});
    repository.add(collection);
    boolean expected = true;
    boolean actual = repository.remove(5);
    assertEquals(expected, actual);
  }
}