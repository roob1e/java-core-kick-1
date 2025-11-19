package com.roobie.collection.factory;

import com.roobie.collection.exception.IntegerCollectionException;

public abstract class Factory<T> {
  public Factory() {}

  public abstract T createEmpty() throws IntegerCollectionException;
  public abstract T createRandom(int size);
  public abstract T createFromArray(Integer[] array);
}
