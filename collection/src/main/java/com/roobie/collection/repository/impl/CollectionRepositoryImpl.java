package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.repository.CollectionRepository;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.specification.impl.IdSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionRepositoryImpl implements CollectionRepository<IntegerCollection> {
  private static final Logger logger = LogManager.getLogger();
  private static CollectionRepositoryImpl instance;
  private List<IntegerCollection> storage;

  public static CollectionRepositoryImpl getInstance() {
    if (instance == null) {
      instance = new CollectionRepositoryImpl();
      logger.info("Initialized repository");
    } else {
      logger.info("Returning an existing instance of CollectionRepositoryImpl");
    }
    return instance;
  }

  private CollectionRepositoryImpl() {
    storage = new ArrayList<>();
    logger.info("Initialized observer");
  }

  @Override
  public Optional<List<IntegerCollection>> query(Specification<IntegerCollection> specification) {
    logger.info("Querying specification: {}", specification);
    List<IntegerCollection> response = new ArrayList<>();
    for (IntegerCollection collection : storage) {
      if (specification.specify(collection)) {
        response.add(collection);
        if (specification instanceof IdSpecification) {
          break;
        }
      }
    }
    if (!response.isEmpty()) {
      logger.info("Found {} collections", response.size());
      return Optional.of(response);
    } else {
      logger.info("No collection found");
      return Optional.empty();
    }
  }

  @Override
  public List<IntegerCollection> add(IntegerCollection... collections) {
    for (IntegerCollection collection : collections) {
      storage.add(collection);
      logger.info("Adding collection: {}", collection.toString());
    }
    return storage;
  }

  @Override
  public boolean remove(long id) {
    logger.info("Removing collection: {}", id);
    IdSpecification specification = new IdSpecification(id);
    for (IntegerCollection collection : storage) {
      if (specification.specify(collection)) {
        logger.info("Collection removed: {}", collection);
        storage.remove(collection);
        return true;
      }
    }
    logger.info("Collection not found");
    return false;
  }

  @Override
  public List<IntegerCollection> fetchAll() {
    logger.info("Fetching all collections");
    return storage;
  }

  public void resetStorage() {
    storage = new ArrayList<>();
  }
}