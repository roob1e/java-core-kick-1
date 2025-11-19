package com.roobie.collection.service.impl;

import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.SortCollectionService;

public class SortCollectionServiceImpl implements SortCollectionService {
  @Override
  public Integer[] bubbleSort(Integer[] array) throws IntegerCollectionException {
    if (array == null || array.length < 2) {
      throw new IntegerCollectionException("Collection is smaller than 2");
    }

    int n = array.length;
    for (int i = 0; i < n; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    return array;
  }

  @Override
  public Integer[] insertionSort(Integer[] array) throws IntegerCollectionException {
    if (array == null || array.length < 2) {
      throw new IntegerCollectionException("Collection is smaller than 2");
    }

    for (int i = 1; i < array.length; i++) {
      int current = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > current) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = current;
    }
    return array;
  }

  @Override
  public Integer[] selectionSort(Integer[] array) throws IntegerCollectionException {
    if (array == null || array.length < 2) {
      throw new IntegerCollectionException("Collection is smaller than 2");
    }

    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
      }
    }
    return array;
  }
}
