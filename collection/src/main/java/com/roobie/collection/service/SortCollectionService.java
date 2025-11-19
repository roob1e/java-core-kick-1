package com.roobie.collection.service;

import com.roobie.collection.exception.IntegerCollectionException;

public interface SortCollectionService {
  Integer[] bubbleSort(Integer[] array) throws IntegerCollectionException;

  Integer[] selectionSort(Integer[] array) throws IntegerCollectionException;

  Integer[] insertionSort(Integer[] array) throws IntegerCollectionException;
}
