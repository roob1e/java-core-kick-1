package com.roobie.collection.reader;

import java.nio.file.Path;
import java.util.List;

public interface CollectionReader<T> {
  List<T> readAllLines(Path filePath) throws Exception;
  T readLine(Path filePath, int index) throws Exception;
}
