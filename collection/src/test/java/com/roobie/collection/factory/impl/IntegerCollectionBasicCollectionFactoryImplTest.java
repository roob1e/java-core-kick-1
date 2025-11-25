package com.roobie.collection.factory.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.factory.BasicCollectionFactory;
import com.roobie.collection.factory.ObservableCollectionFactory;
import com.roobie.collection.factory.RandomCollectionFactory;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.observer.impl.ObserverImpl;
import com.roobie.collection.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCollectionBasicCollectionFactoryImplTest {
  static BasicCollectionFactory<IntegerCollection, Integer> basicCollectionFactory;
  static RandomCollectionFactory<IntegerCollection> randomCollectionFactory;
  static ObservableCollectionFactory<IntegerCollection, Integer> observableCollectionFactory;

  @BeforeAll
  static void setUp() {
    basicCollectionFactory = new BasicCollectionFactoryImpl();
    randomCollectionFactory = new RandomCollectionFactoryImpl();
    observableCollectionFactory = new ObservableCollectionFactoryImpl();
  }

  @Test
  void createEmpty() {
    Integer[] expected = null;

    IntegerCollection empty = basicCollectionFactory.createEmpty();
    Integer[] actual = empty.getCollection();

    assertArrayEquals(expected, actual);
  }

  @Test
  void createFromArray() {
    Integer[] expected = new Integer[] {1, 2, 3, 4, 5};

    IntegerCollection collection = basicCollectionFactory.createFromArray(expected);
    Integer[] actual = collection.getCollection();

    assertArrayEquals(expected, actual);
  }

  @Test
  void createRandom() {
    boolean expected = true;
    Class<IntegerCollection> clazz = IntegerCollection.class;

    IntegerCollection collection = randomCollectionFactory.createRandom(5);
    boolean actual = collection.getClass() == clazz;
    assertEquals(expected, actual);
  }

  @Test
  void createFull() {
    boolean expected = true;
    Integer[] expected_array = new Integer[] {1, 2, 3, 4, 5};
    int expected_obs_size = 1;

    Integer[] array = new Integer[] {1, 2, 3, 4, 5};
    Observer[] observers = new ObserverImpl[]{new ObserverImpl(WarehouseImpl.getInstance())};
    IntegerCollection full = observableCollectionFactory.createWithObservers(array, observers);
    Integer[] actual_array = full.getCollection();
    int actual_obs_size = full.getObservers().size();
    boolean actual = (expected_obs_size == actual_obs_size) && Arrays.equals(expected_array, actual_array);

    assertEquals(expected, actual);
  }

  @Test
  void createFullRandom() {
    int expected_size = 5;
    int expected_obs_size = 1;
    Class<IntegerCollection> expected_class = IntegerCollection.class;
    boolean expected = true;

    Observer[] observers = new ObserverImpl[]{new ObserverImpl(WarehouseImpl.getInstance())};
    IntegerCollection fullRandom = observableCollectionFactory.createRandomWithObservers(5, observers);
    boolean size = expected_size == fullRandom.getCollection().length;
    boolean obs = expected_obs_size == fullRandom.getObservers().size();
    boolean clazz = expected_class == fullRandom.getClass();

    boolean actual = (size == obs) && (size == clazz);
    assertEquals(expected, actual);
  }
}