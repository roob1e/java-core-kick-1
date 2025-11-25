package com.roobie.collection.comparator.impl;

import com.roobie.collection.comparator.TaskComparator;
import com.roobie.collection.entity.impl.IntegerCollection;

public class IdTaskComparator implements TaskComparator<IntegerCollection> {
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

    long comparingId = comparing.getCollectionId();
    long comparedId = compared.getCollectionId();

    return Long.compare(comparingId, comparedId);
  }
}
