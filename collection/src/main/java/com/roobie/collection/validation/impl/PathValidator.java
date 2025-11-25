package com.roobie.collection.validation.impl;

import com.roobie.collection.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathValidator implements Validator<Path> {
  private static final Logger logger = LogManager.getLogger();
  @Override
  public boolean isValid(Path filePath) {
    if (!Files.exists(filePath)) {
      logger.warn("File does not exist: {}", filePath);
      return false;
    }
    return true;
  }
}
