package com.roobie.collection.reader;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

import java.nio.file.Path;
import java.util.List;

public interface CollectionReader {
  List<IntegerCollection> parseAllLines(Path filePath) throws IntegerCollectionException;
  IntegerCollection parseLine(Path filePath, int index) throws IntegerCollectionException;
}
