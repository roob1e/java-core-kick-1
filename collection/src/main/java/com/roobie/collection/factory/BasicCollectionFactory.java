package com.roobie.collection.factory;

public interface BasicCollectionFactory<T, U> {
  T createEmpty();
  T createFromArray(U[] array);
}