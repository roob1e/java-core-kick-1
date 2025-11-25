package com.roobie.collection.comparator;

public interface TaskComparator<T> {
  int compare(T comparing, T compared);
}