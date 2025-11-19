package com.roobie.collection.entity;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.observer.impl.ObserverImpl;
import com.roobie.collection.warehouse.Warehouse;
import com.roobie.collection.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCollectionObserverTest {
  static Warehouse warehouse;
  static Observer observer;

  @BeforeAll
  static void setUp() {
    warehouse = WarehouseImpl.getInstance();
    observer = new ObserverImpl(warehouse);
  }

  @AfterEach
  void tearDown() {
    warehouse.resetStorage();
  }

  @Test
  void addObserver() {
    int expected = 1;

    IntegerCollection collection = new IntegerCollection().builder()
            .collection(new Integer[]{1, 2, 3, 4})
            .observers(observer)
            .build();
    int actual = warehouse.getStorage().size();

    assertEquals(expected, actual);
  }

  @Test
  void removeObserver() {
    List<Observer> expected = new ArrayList<>();

    IntegerCollection collection = new IntegerCollection().builder()
            .collection(new Integer[]{1, 2, 3, 4})
            .observers(observer)
            .build();
    collection.removeObservers(observer);
    List<Observer> actual = collection.getObservers();

    assertEquals(expected, actual);
  }
}