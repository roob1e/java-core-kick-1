package com.roobie.collection.entity;

import java.util.Arrays;

public abstract class Collection<T> {
  private T[] collection;

  public Collection(T[] collection) {
    this.collection = Arrays.copyOf(collection, collection.length);
  }

  public Collection() {}

  public int size() {
    return collection.length;
  }

  public abstract T[] getCollection();

  public T get(int index) {
    return collection[index];
  }

  public abstract void setCollection(T[] collection);
}
