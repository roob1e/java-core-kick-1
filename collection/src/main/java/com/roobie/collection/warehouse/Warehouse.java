package com.roobie.collection.warehouse;

import com.roobie.collection.entity.CollectionStats;
import com.roobie.collection.entity.impl.IntegerCollection;

import java.util.HashMap;

public interface Warehouse {
  void resetStorage();

  HashMap<Long, CollectionStats> getStorage();

  CollectionStats getStats(long collectionId);

  void registerRecord(IntegerCollection collection);

  void removeRecord(IntegerCollection collection);

  void updateRecord(IntegerCollection collection);
}
