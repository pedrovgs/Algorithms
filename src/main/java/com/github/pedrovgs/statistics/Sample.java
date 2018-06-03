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

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Sample {

  private List<Object> sample;

  public Sample(List<Object> sample) {
    this.sample = sample;
  }

  /**
   * Method calculates the frequencies of the Sample.
   * @return A Map of the frequencies of every object in the sample.
   * @throws IllegalArgumentException when the sample is empty.
   */
  public Map<Object, Double> frequencies() {

    if (sample.size() == 0) {
      throw new IllegalArgumentException("Sample is empty !");
    }

    Map<Object, Double> freq = new HashMap<Object, Double>();
    double count;
    for (int i = 0; i < sample.size(); i++) {

      count = freq.containsKey(sample.get(i)) ? freq.get(sample.get(i)) : 0.0;
      freq.put(sample.get(i), count + 1);

    }
    return freq;
  }

  /**
   * Method calculates the avg of the Sample.
   * @return The avg.
   * @throws IllegalArgumentException when sample is empty or when the Sample is not quantitative.
   */
  public double avg() {

    if (sample.size() == 0) {
      throw new IllegalArgumentException("Sample is empty !");
    }

    double avg = 0;
    try {
      for (int i = 0; i < sample.size(); i++) {
        avg += Double.parseDouble(sample.get(i).toString());
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The sample is not quantitative.");
    }
    return avg / sample.size();
  }

  /**
   * Method calculates the median of the Sample.
   * @return The median.
   * @throws IllegalArgumentException when sample is empty or when the Sample is not quantitative.
   */
  public double median() {

    if (sample.size() == 0) {
      throw new IllegalArgumentException("Sample is empty !");
    }

    double median;
    double x;
    double y;
    try {
      if (sample.size() % 2 == 0) {
        x = Double.parseDouble(sample.get(sample.size() / 2 - 1).toString());
        y = Double.parseDouble(sample.get(sample.size() / 2).toString());
        median = (x + y) / 2;
      } else {
        median = Double.parseDouble(sample.get(sample.size() / 2).toString());
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The sample is not quantitative.");
    }

    return median;
  }

  /**
   * Method calculates the variance of the Sample.
   * @return The variance.
   * @throws IllegalArgumentException when sample is empty or when the Sample is not quantitative.
   */
  public double variance() {

    if (sample.size() == 0) {
      throw new IllegalArgumentException("Sample is empty !");
    }

    double var = 0;
    try {
      for (int i = 0; i < sample.size(); i++) {
        var += Math.pow((Double.parseDouble(sample.get(i).toString())) - avg(), 2);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The sample is not quantitative.");
    }
    return var = var / (sample.size() - 1);
  }

  /**
   * Method calculates the standardDeviation of the Sample.
   * @return The standardDeviation.
   * @throws IllegalArgumentException when sample is empty or when the Sample is not quantitative.
   */
  public double standardDeviation() {

    if (sample.size() == 0) {
      throw new IllegalArgumentException("Sample is empty !");
    }

    return Math.pow(variance(), 1.0 / 2.0);
  }
}