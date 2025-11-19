package com.roobie.collection.comparator;

public interface Comparator<T> {
  int compare(T comparing, T compared);
}