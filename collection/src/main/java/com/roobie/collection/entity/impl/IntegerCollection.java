package com.roobie.collection.entity.impl;

import com.roobie.collection.entity.Collection;
import com.roobie.collection.observer.Observable;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.util.Events;
import com.roobie.collection.util.IdGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerCollection extends Collection<Integer> implements Observable {
  private static final Logger logger = LogManager.getLogger();

  private final long collectionId = IdGeneration.next();
  private List<Observer> observers = new ArrayList<>();
  private Integer[] collection;

  public IntegerCollection(Integer[] collection) {
    super(collection);
    this.collection = Arrays.copyOf(collection, collection.length);
    logger.info("IntegerCollection was initialized with {} elements", collection.length);
  }

  public IntegerCollection() {
    super();
    logger.info("Empty IntegerCollection was initialized");
  }

  private IntegerCollection(Builder builder) {
    this.collection = Arrays.copyOf(builder.collection, builder.collection.length);
    this.observers = new ArrayList<>(builder.observers);
    notifyObservers(Events.CREATE, this);
  }
  @Override
  public Integer[] getCollection() {
    return Arrays.copyOf(this.collection, collection.length);
  }

  @Override
  public void setCollection(Integer[] collection) {
    this.collection = Arrays.copyOf(collection, collection.length);
    notifyObservers(Events.UPDATE, this);
  }

  public long getCollectionId() {
    return collectionId;
  }

  public List<Observer> getObservers() {
    return observers;
  }

  @Override
  public void addObservers(Observer... observers) {
    Collections.addAll(this.observers, observers);
  }

  @Override
  public void removeObservers(Observer... observers) {
    for (Observer observer : observers) {
      this.observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers(Events action, IntegerCollection collection) {
    for (Observer observer : observers) {
      observer.update(action, collection);
    }
  }

  public Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("IntegerCollection [collectionId=");
    builder.append(collectionId);
    builder.append(", collection=");
    builder.append(Arrays.toString(collection));
    builder.append("]");
    return builder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    IntegerCollection that = (IntegerCollection) o;
    return Arrays.equals(getCollection(), that.getCollection());
  }

  @Override
  public int hashCode() {
    int result = Long.hashCode(getCollectionId());
    result = 31 * result + Arrays.hashCode(getCollection());
    return result;
  }

  public static class Builder {
    private Integer[] collection;
    private final List<Observer> observers = new ArrayList<>();

    public Builder collection(Integer[] collection) {
      this.collection = Arrays.copyOf(collection, collection.length);
      logger.info("Collections set to: {}", Arrays.toString(collection));
      return this;
    }

    public Builder observers(Observer... observers) {
      Collections.addAll(this.observers, observers);
      logger.info("Observers set to: {}", Arrays.toString(observers));
      return this;
    }

    public IntegerCollection build() {
      logger.info("Building IntegerCollection");
      return new IntegerCollection(this);
    }
  }
}