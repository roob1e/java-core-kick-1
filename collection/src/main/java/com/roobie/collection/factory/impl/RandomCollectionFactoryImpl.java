package com.roobie.collection.factory.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.factory.BasicCollectionFactory;
import com.roobie.collection.factory.RandomCollectionFactory;

import java.util.Random;

public class RandomCollectionFactoryImpl implements RandomCollectionFactory<IntegerCollection> {
  private static final Random random = new Random();
  final BasicCollectionFactory<IntegerCollection, Integer> basicFactory = new BasicCollectionFactoryImpl();

  @Override
  public IntegerCollection createRandom(int size) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10) - 11;
    }
    return basicFactory.createFromArray(array);
  }
}
