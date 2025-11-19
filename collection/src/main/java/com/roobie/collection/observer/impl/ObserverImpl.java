package com.roobie.collection.observer.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.util.Events;
import com.roobie.collection.warehouse.Warehouse;

public class ObserverImpl implements Observer {
  private final Warehouse warehouse;

  public ObserverImpl(Warehouse warehouse) {
    this.warehouse = warehouse;
  }

  @Override
  public void update(Events action, IntegerCollection collection) {
    switch (action) {
      case CREATE -> warehouse.registerRecord(collection);
      case DELETE -> warehouse.removeRecord(collection);
      case UPDATE -> warehouse.updateRecord(collection);
    }
  }
}