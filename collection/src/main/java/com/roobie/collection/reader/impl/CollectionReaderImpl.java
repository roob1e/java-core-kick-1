package com.roobie.collection.reader.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.parser.CollectionParser;
import com.roobie.collection.parser.impl.IntegerCollectionParser;
import com.roobie.collection.reader.CollectionReader;
import com.roobie.collection.validation.Validator;
import com.roobie.collection.validation.impl.PathValidator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CollectionReaderImpl implements CollectionReader<IntegerCollection> {
  private static final Logger logger = LogManager.getLogger();
  private static final Validator<Path> validator = new PathValidator();
  private final CollectionParser<Integer> parser = new IntegerCollectionParser();

  @Override
  public List<IntegerCollection> readAllLines(Path filePath) throws IntegerCollectionException {
    if (!validator.isValid(filePath)) {
      throw new IntegerCollectionException("Invalid path");
    }

    List<IntegerCollection> data = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(filePath);
      for (String line : lines) {
        Integer[] parsed = parser.parse(line);
        if (parsed != null) {
          data.add(new IntegerCollection(parsed));
        }
      }
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new IntegerCollectionException(e.getMessage(), e);
    }
    return data;
  }

  @Override
  public IntegerCollection readLine(Path filePath, int index) throws IntegerCollectionException {
    if (!validator.isValid(filePath)) {
      throw new IntegerCollectionException("Invalid path");
    }

    try {
      List<String> lines = Files.readAllLines(filePath);
      String result = lines.get(index);
      Integer[] arr = parser.parse(result);
      var collection = new IntegerCollection().builder()
              .collection(arr)
              .build();
      logger.info("Collection read: {}", collection);
      return collection;
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new IntegerCollectionException(e.getMessage(), e);
    }
  }
}