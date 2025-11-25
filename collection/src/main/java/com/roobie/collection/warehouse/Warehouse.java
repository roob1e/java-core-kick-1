package com.roobie.collection.warehouse;

import com.roobie.collection.entity.impl.IntegerCollection;

public interface Warehouse {
  void resetStorage();

  void registerRecord(IntegerCollection collection);

  void removeRecord(IntegerCollection collection);

  void removeRecord(long collectionId);

  void updateRecord(IntegerCollection collection);
}