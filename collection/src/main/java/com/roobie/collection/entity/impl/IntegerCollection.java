package com.roobie.collection.entity.impl;

import com.roobie.collection.entity.TaskCollection;
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

public class IntegerCollection extends TaskCollection<Integer> implements Observable<IntegerCollection> {
  private static final Logger logger = LogManager.getLogger();

  private final long collectionId;
  private List<Observer> observers;

  public IntegerCollection(Integer[] collection) {
    super(collection);
    this.collectionId = IdGeneration.next();
    logger.info("IntegerCollection was initialized with {} elements", collection.length);
  }

  public IntegerCollection() {
    super();
    this.collectionId = IdGeneration.next();
    logger.info("Empty IntegerCollection was initialized");
  }

  private IntegerCollection(Builder builder) {
    super(builder.collection);
    this.observers = new ArrayList<>(builder.observers);
    this.collectionId = IdGeneration.next();
    if (this.observers != null) {
      notifyObservers(Events.UPDATE, this);
    }
  }

  @Override
  public void setCollection(Integer[] collection) {
    super.setCollection(collection);
    if (this.observers != null) {
      notifyObservers(Events.UPDATE, this);
    }
  }

  public long getCollectionId() {
    return this.collectionId;
  }

  public List<Observer> getObservers() {
    return List.copyOf(this.observers);
  }

  @Override
  public final void addObservers(Observer... observers) {
    this.observers.addAll(Arrays.asList(observers));
    notifyObservers(Events.CREATE, this);
  }

  @Override
  public void removeObservers(Observer... observers) {
    for (Observer observer : observers) {
      this.observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers(Events action, IntegerCollection collection) {
    for (Observer observer : this.observers) {
      observer.update(action, collection);
    }
  }

  public Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    //noinspection StringBufferReplaceableByString
    StringBuilder builder = new StringBuilder();
    builder.append("IntegerCollection [collectionId=");
    builder.append(collectionId);
    builder.append(", collection=");
    builder.append(Arrays.toString(getCollection()));
    builder.append("]");
    return builder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntegerCollection that = (IntegerCollection) o;
    return Arrays.equals(collection, that.collection);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(getCollection());
    return result;
  }

  public static class Builder {
    private Integer[] collection;
    private final List<Observer> observers = new ArrayList<>();

    public Builder collection(Integer[] collection) {
      if (collection != null) {
        this.collection = Arrays.copyOf(collection, collection.length);
        logger.info("Collections set to: {}", Arrays.toString(collection));
      } else {
        this.collection = null;
        logger.info("Collections set to null");
      }
      return this;
    }

    public final Builder observers(Observer... observers) {
      this.observers.clear();
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