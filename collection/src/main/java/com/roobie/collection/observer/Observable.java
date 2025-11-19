package com.roobie.collection.observer;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.util.Events;

public interface Observable {
  void addObservers(Observer... observers);

  void removeObservers(Observer... observers);

  void notifyObservers(Events action, IntegerCollection collection) throws IntegerCollectionException;
}