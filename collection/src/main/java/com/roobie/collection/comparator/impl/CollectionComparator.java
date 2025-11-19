package com.roobie.collection.comparator.impl;

import com.roobie.collection.comparator.Comparator;
import com.roobie.collection.entity.impl.IntegerCollection;

public class CollectionComparator implements Comparator<IntegerCollection> {
  @Override
  public int compare(IntegerCollection comparing, IntegerCollection compared) {
    if (comparing == null && compared == null) {
      return 0;
    }
    if (comparing == null) {
      return -1;
    }
    if (compared == null) {
      return 1;
    }

    Integer[] arrayComparing = comparing.getCollection();
    Integer[] arrayCompared = compared.getCollection();
    int sizeComparison = Integer.compare(arrayComparing.length, arrayCompared.length);
    if (sizeComparison != 0) {
      return sizeComparison;
    }

    for (int i = 0; i < arrayComparing.length; i++) {
      int elementComparison = compareElements(arrayComparing[i], arrayCompared[i]);
      if (elementComparison != 0) {
        return elementComparison;
      }
    }

    return 0;
  }

  private int compareElements(Integer a, Integer b) {
    if (a == null && b == null) return 0;
    if (a == null) return -1;
    if (b == null) return 1;
    return Integer.compare(a, b);
  }
}