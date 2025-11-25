package com.roobie.collection.parser;

public interface CollectionParser<T> {
  T[] parse(String input);
}
