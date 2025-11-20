package com.roobie.collection.factory;

import com.roobie.collection.observer.Observer;

public interface Factory<T> {
  T createEmpty();
  T createRandom(int size);
  T createFromArray(Integer[] array);
  T createFull(Integer[] array, Observer[] observers);
  T createFullRandom(int size, Observer[] observers);
}
