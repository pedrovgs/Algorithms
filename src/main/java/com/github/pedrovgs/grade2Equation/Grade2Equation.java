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

/**
 * This class contains an algorithm that solves 2nd grade equations.
 * @author ShoeMaker
 *
 */

public class Grade2Equation {
	
	/**
	 * Method solves 2nd grade equations.
	 * @param a
	 * @param b
	 * @param c
	 * @return An array with the solution/solutions of the equation.
	 * @throws IllegalArgumentException there is no Real solution to the equation.
	 */
	
	public Double[] solve (double a, double b, double c) {
		
		double d = (b * b) - (4 * a * c);
		if (d < 0) {
			throw new IllegalArgumentException("There is no Real solution to this equation.");
		}
		Double[] x = new Double[2];
		x[0] = (-b + Math.sqrt(d))/(2 * a);
		x[1] = (-b - Math.sqrt(d))/(2 * a);
		return x;
		
	}
}
