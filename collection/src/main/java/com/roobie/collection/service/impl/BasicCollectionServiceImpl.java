package com.roobie.collection.service.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.IntegerCollectionService;

import java.util.Arrays;
import java.util.HashMap;

public class BasicCollectionServiceImpl implements IntegerCollectionService {
  @Override
  public Integer findMinElement(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }
    Integer[] processed = collection.getCollection();
    Integer min = processed[0];
    for (int i = 1; i < processed.length; i++) {
      if (processed[i] < min) {
        min = processed[i];
      }
    }
    return min;
  }

  @Override
  public Integer findMaxElement(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    int max = collection.getCollection()[0];
    for (int i = 1; i < collection.getCollection().length; i++) {
      if (collection.getCollection()[i] > max) {
        max = collection.getCollection()[i];
      }
    }
    return max;
  }

  @Override
  public Integer replaceElement(IntegerCollection collection, Integer newElement, int index) throws IntegerCollectionException {
    if (index < 0 || index >= collection.getCollection().length) {
      throw new IntegerCollectionException("Index out of range");
    }

    Integer[] processed = collection.getCollection();
    Integer[] result = new Integer[processed.length];
    for (int i = 0; i < processed.length; i++) {
      result[i] = processed[i];
      if (i == index) {
        result[i] = newElement;
      }
    }
    collection.setCollection(result);
    return newElement;
  }

  @Override
  public double defineAverageValue(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    Integer[] processed = collection.getCollection();
    double average;
    double sum = 0;
    for (int element : processed) {
      sum += element;
    }
    average = sum / processed.length;
    return average;
  }

  @Override
  public int defineSum(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    Integer[] processed = collection.getCollection();
    int sum = 0;
    for (int element : processed) {
      sum += element;
    }
    return sum;
  }

  @Override
  public HashMap<String, Integer> countPositivesAndNegatives(IntegerCollection collection)
          throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    Integer[] processed = collection.getCollection();
    HashMap<String, Integer> map = new HashMap<>();
    map.put("positive", 0);
    map.put("negative", 0);
    map.put("zero", 0);
    for (int element : processed) {
      if (element > 0) {
        map.put("positive", map.get("positive") + 1);
      } else if (element < 0) {
        map.put("negative", map.get("negative") + 1);
      } else {
        map.put("zero", map.get("zero") + 1);
      }
    }
    return map;
  }
}