package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortRepositoryTest {
  CollectionRepositoryImpl repository = CollectionRepositoryImpl.getInstance();

  @BeforeEach
  void setUp() {
    IntegerCollection collection1 = new IntegerCollection(new Integer[]{1, 2});
    IntegerCollection collection2 = new IntegerCollection(new Integer[]{1});
    IntegerCollection collection3 = new IntegerCollection(new Integer[]{1, 2, 3});
    repository.add(collection1, collection2, collection3);
  }

  @AfterEach
  void tearDown() {
    repository.resetStorage();
  }

  @Test
  void sort() {
    List<Integer[]> expected = new ArrayList<>();
    expected.add(new Integer[]{1});
    expected.add(new Integer[]{1, 2});
    expected.add(new Integer[]{1, 2, 3});

    List<IntegerCollection> result = repository.sort();
    List<Integer[]> actual = new ArrayList<>();
    for (IntegerCollection collection : result) {
      actual.add(collection.getCollection());
    }

    assertArrayEquals(expected.toArray(), actual.toArray());
  }
}