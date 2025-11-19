package com.roobie.collection.service;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

import java.util.HashMap;

public interface IntegerCollectionService {
  Integer findMinElement(IntegerCollection collection) throws IntegerCollectionException;

  Integer findMaxElement(IntegerCollection collection) throws IntegerCollectionException;

  Integer replaceElement(IntegerCollection collection, Integer newElement, int index) throws IntegerCollectionException;

  double defineAverageValue(IntegerCollection collection) throws IntegerCollectionException;

  int defineSum(IntegerCollection collection) throws IntegerCollectionException;

  HashMap<String, Integer> countPositivesAndNegatives(IntegerCollection collection) throws IntegerCollectionException;
}
