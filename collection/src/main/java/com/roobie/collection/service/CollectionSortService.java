package com.roobie.collection.service;

import java.util.Comparator;
import java.util.List;

public interface CollectionSortService<T> {
  List<T> sort(List<T> collections, Comparator<T> comparator);
}
