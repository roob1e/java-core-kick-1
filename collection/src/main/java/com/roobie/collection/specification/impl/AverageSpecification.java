package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.BasicCollectionServiceImpl;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.util.Sign;

public record AverageSpecification(double average, Sign sign) implements Specification {

  @Override
  public boolean specify(IntegerCollection collection) throws IntegerCollectionException {
    double average = new BasicCollectionServiceImpl().defineAverageValue(collection);
    if (sign == Sign.MORE) {
      return average > this.average;
    } else {
      return average < this.average;
    }
  }
}
