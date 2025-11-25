package com.roobie.collection.exception;

import com.roobie.collection.reader.impl.CollectionReaderImpl;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ReaderExceptionTest {
  Path invalid_path = Paths.get("");
  CollectionReaderImpl reader = new CollectionReaderImpl();

  @Test
  void parseAllLinesException() {
    assertThrows(IntegerCollectionException.class, () -> reader.readAllLines(invalid_path));
  }

  @Test
  void parseLineException() {
    assertThrows(IntegerCollectionException.class, () -> reader.readLine(invalid_path, 1));
  }
}