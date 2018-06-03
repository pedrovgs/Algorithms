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

package com.github.pedrovgs.grade2Equation;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * This class contains tests for Grade2Equation.solve method.
 * @author ShoeMaker
 *
 */

public class Grade2EquationTest {

  Grade2Equation equation = new Grade2Equation();
  Double[] x = {-1.0, -1.0};

  /**
  * Tests a normal case of an equation. 
  */
  @Test
  public void test_solve() {
    Assert.assertArrayEquals(x, equation.solve(1, 2, 1));    
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
  * Tests a case of an unsolvable equation. 
  */
  @Test
  public void test_solve_IllegalArgumentException() {

    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("There is no Real solution to this equation.");
    equation.solve(2, 3, 4);
  }
}
