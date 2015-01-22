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
package com.github.pedrovgs.problem68;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IsEvenTest {

  private IsEven isEven;

  @Before public void setUp() {
    isEven = new IsEven();
  }

  @Test public void shouldReturnTrueIfNumberIsZero() {
    assertTrue(isEven.check(0));
  }

  @Test public void shouldReturnTrueIfNumberIsEven() {
    assertTrue(isEven.check(68));
  }

  @Test public void shouldReturnFalseIfNumberIsOdd() {
    assertFalse(isEven.check(99));
  }
}
