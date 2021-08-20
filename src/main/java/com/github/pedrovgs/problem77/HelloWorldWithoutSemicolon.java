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
package com.github.pedrovgs.problem77;

/**
 * Can you write a method to print a hello world without use a semicolon?.
 *
 *你能写一个不使用分号打印 hello world 的方法吗？ 
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class HelloWorldWithoutSemicolon {

  public void printHelloWorld() {
    if ((System.out.append("Hello world")) != null) {
    }
  }

  public static void main(String[] args) {
    HelloWorldWithoutSemicolon helloWorldWithoutSemicolon = new HelloWorldWithoutSemicolon();
    helloWorldWithoutSemicolon.printHelloWorld();
  }
}
