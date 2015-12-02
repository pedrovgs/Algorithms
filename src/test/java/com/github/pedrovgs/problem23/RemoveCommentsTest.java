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
package com.github.pedrovgs.problem23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RemoveCommentsTest {

  private RemoveComments removeComments;

  @Before public void setUp() {
    this.removeComments = new RemoveComments();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullFiles() {
    removeComments.remove(null);
  }

  @Test public void shouldReturnEmptyStringIfFileIsNull() {
    FakeFile file = new FakeFile();

    String result = removeComments.remove(file);

    assertEquals("", result);
  }

  @Test public void shouldReturnFileContentWithoutComments() {
    FakeFile file =
        new FakeFile("Hello world ", "this is the content /* of a fake file */", "of a real file");

    String result = removeComments.remove(file);

    assertEquals("Hello world this is the content of a real file", result);
  }
  
  @Test public void testForSlashAfterCommentOpen() {
    FakeFile file =
	        new FakeFile("Hello world ", "this is the content /*/ of a fake file */", "of a real file");

    String result = removeComments.remove(file);

    assertEquals("Hello world this is the content of a real file", result);
  }

}
