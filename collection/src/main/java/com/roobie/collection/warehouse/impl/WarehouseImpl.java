package com.roobie.collection.warehouse.impl;

import com.roobie.collection.entity.CollectionStats;
import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.BasicServiceImpl;
import com.roobie.collection.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class WarehouseImpl implements Warehouse {
  private static final Logger logger = LogManager.getLogger();
  private static WarehouseImpl instance;
  private final HashMap<Long, CollectionStats> storage;

  private WarehouseImpl() {
    storage = new HashMap<>();
  }

  public static WarehouseImpl getInstance() {
    if (instance == null) {
      logger.info("Creating new instance of Warehouse");
      instance = new WarehouseImpl();
    }
    return instance;
  }

  @Override
  public void resetStorage() {
    storage.clear();
  }

  public HashMap<Long, CollectionStats> getStorage() {
    logger.info("Getting storage of Warehouse");
    return storage;
  }

  public CollectionStats getStats(long collectionId) {
    if (storage.containsKey(collectionId)) {
      logger.info("Got stats of Warehouse with id {}: {}", collectionId ,storage.get(collectionId));
      return storage.get(collectionId);
    }
    return new CollectionStats(0, 0, 0, 0);
  }

  @Override
  public void registerRecord(IntegerCollection collection) {
    long collectionId = collection.getCollectionId();
    CollectionStats metrics = calculateMetrics(collection);
    storage.put(collectionId, metrics);

    HashMap<Long, CollectionStats> result = new HashMap<>();
    result.put(collectionId, metrics);
    logger.info("Registered record of Warehouse: {}", result);
  }

  @Override
  public void removeRecord(IntegerCollection collection) {
    long collectionId = collection.getCollectionId();
    logger.info("Removing record of Warehouse with id: {}", collectionId);
    storage.remove(collectionId);
  }

  @Override
  public void removeRecord(long collectionId) {
    logger.info("Removing record of Warehouse with id: {}", collectionId);
    storage.remove(collectionId);
  }

  @Override
  public void updateRecord(IntegerCollection collection) {
    long collectionId = collection.getCollectionId();
    CollectionStats metrics = calculateMetrics(collection);
    storage.put(collectionId, metrics);
    logger.info("Updated record of Warehouse with id: {}", collectionId);
  }

  private CollectionStats calculateMetrics(IntegerCollection collection) {
    BasicServiceImpl impl = new BasicServiceImpl();
    try {
      double average = impl.defineAverageValue(collection);
      int min = impl.findMinElement(collection);
      int max = impl.findMaxElement(collection);
      int sum = impl.defineSum(collection);
      return new CollectionStats(average, min, max, sum);
    } catch (IntegerCollectionException e) {
      return new CollectionStats(0, 0, 0, 0);
    }
  }
}