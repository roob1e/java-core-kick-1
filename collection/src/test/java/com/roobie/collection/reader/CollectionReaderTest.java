package com.roobie.collection.reader;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.reader.impl.CollectionReaderImpl;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionReaderTest {
  Path path = Paths.get("data/data.txt");

  @Test
  void parseAllLines() throws IntegerCollectionException {
    List<Integer[]> expected = new ArrayList<>();
    expected.add(new IntegerCollection(new Integer[]{1, 2, 3, 4}).getCollection());
    expected.add(new IntegerCollection(new Integer[]{4, 3, 2, 1}).getCollection());
    expected.add(new IntegerCollection(new Integer[]{8, 1, 4, 6, 8}).getCollection());

    List<IntegerCollection> parsed = new CollectionReaderImpl().parseAllLines(path);
    List<Integer[]> actual = new ArrayList<>();
    for (IntegerCollection collection : parsed) {
      actual.add(collection.getCollection());
    }

    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  @Test
  void parseLine() throws IntegerCollectionException {
    Integer[] expected = new Integer[]{1, 2, 3, 4};

    IntegerCollection parsed = new CollectionReaderImpl().parseLine(path, 0);
    Integer[] actual = parsed.getCollection();

    assertArrayEquals(expected, actual);
  }
}