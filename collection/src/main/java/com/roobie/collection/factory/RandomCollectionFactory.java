package com.roobie.collection.factory;

public interface RandomCollectionFactory<T> {
  T createRandom(int size);
}
