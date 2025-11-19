package com.roobie.collection.reader.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.reader.CollectionReader;
import com.roobie.collection.validation.StringValidator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CollectionReaderImpl implements CollectionReader {
  private static final Logger logger = LogManager.getLogger();
  private static final String delimiters = "[, \\-\\s]+";

  @Override
  public List<IntegerCollection> parseAllLines(Path filePath) throws IntegerCollectionException {
    List<IntegerCollection> data = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(filePath);
      for (String line : lines) {
        if (StringValidator.isValid(line)) {
          String[] parts = line.split(delimiters);
          Integer[] arr = new Integer[parts.length];
          for (int i = 0; i < parts.length; i++) {
            String temp = parts[i].trim();
            arr[i] = Integer.parseInt(temp);
          }
          var collection = new IntegerCollection().builder()
                  .collection(arr)
                  .build();
          data.add(collection);
          logger.info("Collection read: {}", collection);
        }
      }
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new IntegerCollectionException(e.getMessage(), e);
    }
    return data;
  }

  @Override
  public IntegerCollection parseLine(Path filePath, int index) throws IntegerCollectionException {
    List<IntegerCollection> data = parseAllLines(filePath);
    IntegerCollection result;
    try {
      result = data.get(index);
      logger.info("Collection read: {}", result);
    } catch (IndexOutOfBoundsException e) {
      logger.error("Index out of bounds: {}\n{}", index, e.getMessage());
      throw new IntegerCollectionException(e.getMessage(), e);
    }
    return result;
  }
}
