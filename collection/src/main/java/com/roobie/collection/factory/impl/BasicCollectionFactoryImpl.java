package com.roobie.collection.factory.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.factory.BasicCollectionFactory;

import java.util.Arrays;

public class BasicCollectionFactoryImpl implements BasicCollectionFactory<IntegerCollection, Integer> {
  @Override
  public IntegerCollection createEmpty() {
    return new IntegerCollection();
  }

  @Override
  public IntegerCollection createFromArray(Integer[] array) {
    return new IntegerCollection().builder()
            .collection(Arrays.copyOf(array, array.length))
            .build();
  }
}
