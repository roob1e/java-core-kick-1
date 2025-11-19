package com.roobie.collection.specification;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

public interface Specification {
  boolean specify(IntegerCollection collection) throws IntegerCollectionException;
}