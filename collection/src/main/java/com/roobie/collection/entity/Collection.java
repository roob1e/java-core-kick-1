package com.roobie.collection.entity;

import com.roobie.collection.exception.IntegerCollectionException;

import java.util.Arrays;

public abstract class Collection<T> {
  protected T[] collection;

  public Collection(T[] collection) {
    this.collection = Arrays.copyOf(collection, collection.length);
  }

  public Collection() {
    this.collection = null;
  }

  public int size() {
    if (collection != null) {
      return collection.length;
    }
    return 0;
  }

  public T[] getCollection() {
    if (collection != null) {
      return Arrays.copyOf(collection, collection.length);
    }
    return null;
  }

  public T get(int index) throws IntegerCollectionException {
    if (collection == null || index < 0 || index >= collection.length ) {
      throw  new IntegerCollectionException("Index out of bounds");
    }
    return collection[index];
  }

  public void setCollection(T[] collection) {
    this.collection = Arrays.copyOf(collection, collection.length);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Collection<?> that = (Collection<?>) o;
    return Arrays.equals(getCollection(), that.getCollection());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(getCollection());
  }

  @Override
  public String toString() {
    @SuppressWarnings("StringBufferReplaceableByString") StringBuilder sb = new StringBuilder();
    sb.append("Collection{collection=");
    sb.append(Arrays.toString(collection));
    sb.append('}');
    return sb.toString();
  }
}
