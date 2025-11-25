package com.roobie.collection.factory.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.factory.ObservableCollectionFactory;
import com.roobie.collection.factory.RandomCollectionFactory;
import com.roobie.collection.observer.Observer;

import java.util.Arrays;
import java.util.Random;

public class ObservableCollectionFactoryImpl implements ObservableCollectionFactory<IntegerCollection, Integer> {
  private static final Random random = new Random();
  private static final RandomCollectionFactory<IntegerCollection> randomFactory = new RandomCollectionFactoryImpl();
  @Override
  public IntegerCollection createWithObservers(Integer[] array, Observer... observers) {
    return new IntegerCollection().builder()
            .collection(Arrays.copyOf(array, array.length))
            .observers(observers)
            .build();
  }

  @Override
  public IntegerCollection createRandomWithObservers(int size, Observer... observers) {
    IntegerCollection collection = randomFactory.createRandom(size);
    collection.addObservers(observers);
    return collection;
  }
}