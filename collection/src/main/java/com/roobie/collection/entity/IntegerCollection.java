package com.roobie.collection.entity;

import com.roobie.collection.util.IdGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntegerCollection {
  private static final Logger logger = LogManager.getLogger();

  private final long collectionId = IdGeneration.next();
  private int[] collection;

  public IntegerCollection(int[] collection) {
    this.collection = Arrays.copyOf(collection, collection.length);
    logger.info("IntegerCollection was initialized with {} elements", collection.length);
  }

  public IntegerCollection() {
    logger.info("Empty IntegerCollection was initialized");
  }

  private IntegerCollection(Builder builder) {
    this.collection = Arrays.copyOf(builder.collection, builder.collection.length);
  }

  public int[] getCollection() {
    return Arrays.copyOf(this.collection, collection.length);
  }

  public void setCollection(int[] collection) {
    this.collection = Arrays.copyOf(collection, collection.length);
  }

  public long getCollectionId() {
    return collectionId;
  }

  public Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    @SuppressWarnings("StringBufferReplaceableByString") StringBuilder builder = new StringBuilder();
    builder.append("IntegerCollection [collectionId=");
    builder.append(collectionId);
    builder.append(", collection=");
    builder.append(Arrays.toString(collection));
    builder.append("]");
    return builder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    IntegerCollection that = (IntegerCollection) o;
    return getCollectionId() == that.getCollectionId() && Arrays.equals(getCollection(), that.getCollection());
  }

  @Override
  public int hashCode() {
    int result = Long.hashCode(getCollectionId());
    result = 31 * result + Arrays.hashCode(getCollection());
    return result;
  }

  public static class Builder {
    private int[] collection;

    public Builder collection(int[] collection) {
      this.collection = Arrays.copyOf(collection, collection.length);
      logger.info("Collections set to: {}", Arrays.toString(collection));
      return this;
    }

    public IntegerCollection build() {
      logger.info("Building IntegerCollection");
      return new IntegerCollection(this);
    }
  }
}