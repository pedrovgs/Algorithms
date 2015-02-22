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
package com.github.pedrovgs.problem78;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Before to read this test read AutoBoxingTrick class, this is a really funny Java trick.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class AutoBoxingTrickTest {

  private AutoBoxingTrick autoBoxingTrick;

  @Before public void setUp() {
    autoBoxingTrick = new AutoBoxingTrick();
  }

  @Test public void shouldReturnFalseButReturnsTrue() {
    assertTrue(autoBoxingTrick.compare(1, 1));
  }

  @Test public void shouldReturnFalseAndReturnsFalse() {
    assertFalse(autoBoxingTrick.compare(1000, 1000));
  }
}
