package com.roobie.collection.service.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.service.CollectionSortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionSortServiceImpl implements CollectionSortService<IntegerCollection> {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public List<IntegerCollection> sort(List<IntegerCollection> collections, Comparator<IntegerCollection> comparator) {
    logger.info("Sorting collections");
    List<IntegerCollection> sorted = new ArrayList<>(collections);
    boolean swapped = true;

    while (swapped) {
      swapped = false;
      for (int i = 0; i < sorted.size() - 1; i++) {
        IntegerCollection comparing = sorted.get(i);
        IntegerCollection compared = sorted.get(i + 1);
        if (comparator.compare(comparing, compared) > 0) {
          swapped = true;
          sorted.set(i + 1, comparing);
          sorted.set(i, compared);
        }
      }
    }
    return sorted;
  }
}