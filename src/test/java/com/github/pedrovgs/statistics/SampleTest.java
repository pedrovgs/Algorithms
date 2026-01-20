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

package com.github.pedrovgs.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * This class contains tests for Sample class.
 * @author ShoeMaker
 *
 */

public class SampleTest {

  List<Object> file = new ArrayList<Object>();

  /**
    * Tests a normal case of frequencies in a sample. 
    */
  @Test
  public void test_frequencies() {

    for (int i = 1; i < 4; i++) {
      file.add(i);
    }

    Map<Object,Double> freq = new HashMap<Object, Double>();
    freq.put(1, 1.0);
    freq.put(2, 1.0);
    freq.put(3, 1.0);
    Sample grades = new Sample(file);
    Assert.assertEquals(freq, grades.frequencies());  
  }

  /**
   * Tests a normal case of avg in a sample. 
   */
  @Test
  public void test_avg() {

    for (int i = 1; i < 4; i++) {
      file.add(i);
    }
    Sample grades = new Sample(file);

    Assert.assertEquals(2.0, grades.avg(), 0);  
  }

  /**
   * Tests a normal case of median in a sample. 
   */
  @Test
  public void test_median() {

    for (int i = 1; i < 4; i++) {
      file.add(i);
    }
    Sample grades = new Sample(file);

    Assert.assertEquals(2.0, grades.median(), 0);  
  }

  /**
   * Tests a normal case of variance in a sample. 
   */
  @Test
  public void test_variance() {

    for (int i = 1; i < 4; i++) {
      file.add(i);
    }
    Sample grades = new Sample(file);

    Assert.assertEquals(1.0, grades.variance(), 0);  
  }

  /**
   * Tests a normal case of standardDeviation in a sample. 
   */
  @Test
  public void standardDeviation() {

    for (int i = 1; i < 4; i++) {
      file.add(i);
    }
    Sample grades = new Sample(file);

    Assert.assertEquals(1.0, grades.standardDeviation(), 0);  
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  /**
   * Tests a case of an Empty Sample in frequencies method. 
   */
  @Test
  public void test_frequencies_EmptySample() {

    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Sample is empty !");
    grades.frequencies();
  }
  
  /**
   * Tests a case of an Uncountable Sample in avg method.
   */
  @Test
  public void test_avg_Uncountable() {

    file.add("a");
    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The sample is not quantitative.");
    grades.avg();
  }
  
  /**
   * Tests a case of an Empty Sample in avg method.
   */
  @Test
  public void test_avg_EmptySample() {
  
    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Sample is empty !");
    grades.avg();
  }

  /**
   * Tests a case of an Uncountable Sample in median method.
   */
  @Test
  public void test_median_Uncountable() {

    file.add("a");
    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The sample is not quantitative.");
    grades.median();
  }
  
  /**
   * Tests a case of an Empty Sample in median method.
   */
  @Test
  public void test_median_EmptySample() {

    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Sample is empty !");
    grades.median();
  }

  /**
   * Tests a case of an Uncountable Sample in variance method.
   */
  @Test
  public void test_variance_Uncountable() {

    file.add("a");
    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The sample is not quantitative.");
    grades.variance();
  }

  /**
   * Tests a case of an Empty Sample in variance method.
   */
  @Test
  public void test_variance_EmptySample() {

    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Sample is empty !");
    grades.variance();
  }

  /**
   * Tests a case of an Uncountable Sample in standardDeviation method.
   */
  @Test
  public void test_standardDeviation_Uncountable() {

    file.add("a");
    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The sample is not quantitative.");
    grades.standardDeviation();
  }

  /**
   * Tests a case of an Empty Sample in standardDeviation method.
   */
  @Test
  public void test_standardDeviation_EmptySample() {

    Sample grades = new Sample(file);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Sample is empty !");
    grades.standardDeviation();
  }
}
