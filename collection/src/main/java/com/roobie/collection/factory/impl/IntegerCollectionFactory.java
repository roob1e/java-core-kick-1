package com.roobie.collection.factory.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.factory.Factory;

import java.util.Arrays;
import java.util.Random;

public class IntegerCollectionFactory extends Factory<IntegerCollection> {
  private static final Random RANDOM = new Random();

  public IntegerCollectionFactory() {
    super();
  }

  @Override
  public IntegerCollection createEmpty() throws IntegerCollectionException {
    IntegerCollection collection = new IntegerCollection();
    collection.setCollection(new Integer[0]);
    return collection;
  }

  @Override
  public IntegerCollection createFromArray(Integer[] array) {
    return new IntegerCollection().builder()
            .collection(Arrays.copyOf(array, array.length))
            .build();
  }

  @Override
  public IntegerCollection createRandom(int size) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = RANDOM.nextInt(-10, 10);
    }
    return createFromArray(array);
  }
}
