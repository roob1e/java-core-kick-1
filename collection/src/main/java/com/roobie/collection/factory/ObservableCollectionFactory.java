package com.roobie.collection.factory;

import com.roobie.collection.observer.Observer;

public interface ObservableCollectionFactory<T, U> {
  T createWithObservers(U[] array, Observer... observers);
  T createRandomWithObservers(int size, Observer... observers);
}
