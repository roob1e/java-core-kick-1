package com.roobie.collection.factory;

import com.roobie.collection.exception.IntegerCollectionException;

public interface Factory<T> {
  T createEmpty() throws IntegerCollectionException;
  T createRandom(int size);
  T createFromArray(Integer[] array);
}
