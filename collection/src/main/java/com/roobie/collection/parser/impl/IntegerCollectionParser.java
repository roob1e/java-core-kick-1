package com.roobie.collection.parser.impl;

import com.roobie.collection.parser.CollectionParser;
import com.roobie.collection.validation.Validator;
import com.roobie.collection.validation.impl.StringValidator;

public class IntegerCollectionParser implements CollectionParser<Integer> {
  private static final String delimiters = "[, \\-\\s]+";

  @Override
  public Integer[] parse(String input) {
    Validator<String> validator = new StringValidator();
    if (validator.isValid(input)) {
      String[] parts = input.split(delimiters);
      Integer[] arr = new Integer[parts.length];
      for (int i = 0; i < parts.length; i++) {
        arr[i] = Integer.parseInt(parts[i]);
      }
      return arr;
    } else {
      return null;
    }
  }
}
