/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class VectorScalarProductTest {

  private VectorScalarProduct vectorScalarProduct;

  @Before public void setUp() {
    vectorScalarProduct = new VectorScalarProduct();
  }

  @Test(expected = IllegalArgumentException.class)
  public void differentSizeVectorsShouldThrowException() {
    Vector v1 = new Vector(1, 2, 3, 4);
    Vector v2 = new Vector(1, 2);

    vectorScalarProduct.calculateScalarProduct(v1, v2);
  }

  @Test(expected = IllegalArgumentException.class) public void nullVectorsShouldThrowException() {
    Vector v1 = new Vector(1, 2, 3, 4);

    vectorScalarProduct.calculateScalarProduct(v1, null);
  }

  @Test public void shouldReturnZeroIfVectorsAreEmpty() {
    assertEquals(0, vectorScalarProduct.calculateScalarProduct(new Vector(), new Vector()));
  }

  @Test(expected = IllegalArgumentException.class) public void shouldThrowExceptionIfVectorsAreNull() {
    assertEquals(0, vectorScalarProduct.calculateScalarProduct(new Vector(null), new Vector(null)));
  }

  @Test public void shouldReturnZeroIfOneVectorIsFullOfZeros() {
    Vector v1 = new Vector(1, 2, 3, 4);
    Vector v2 = new Vector(0, 0, 0, 0);

    int result = vectorScalarProduct.calculateScalarProduct(v1, v2);

    assertEquals(0, result);
  }

  @Test public void shouldReturnSumOfOneVectorIfOtherIsFullOfOnes() {
    Vector v1 = new Vector(2, 2, 2, 2);
    Vector v2 = new Vector(1, 1, 1, 1);

    int result = vectorScalarProduct.calculateScalarProduct(v1, v2);

    assertEquals(8, result);
  }

  @Test public void shouldTakeIntoAccountNegativeElements() {
    Vector v1 = new Vector(2, 2, 2, 2);
    Vector v2 = new Vector(-1, 1, -1, -1);

    int result = vectorScalarProduct.calculateScalarProduct(v1, v2);

    assertEquals(-4, result);
  }
}
