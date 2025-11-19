package com.roobie.collection.repository;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository {
  Optional<List<IntegerCollection>> query(Specification specification) throws IntegerCollectionException;

  List<IntegerCollection> add(IntegerCollection... collection) throws IntegerCollectionException;

  boolean remove(long id) throws IntegerCollectionException;

  List<IntegerCollection> fetchAll();

  List<IntegerCollection> sort();
}
