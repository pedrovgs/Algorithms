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

package com.github.pedrovgs.txtToList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * This class contains and algorithm that reads txt files and turns them to Lists for further use.
 * @author ShoeMaker
 *
 */

public class TxtToList {
	
	/**
	 * Method gets a txt file's path. It opens the file and reads it,
	 * then tries to get the txt lines and return them as a List.
	 * @param filepath  The file's path.
	 * @return An List with the file's lines.
	 * @throws IllegalArgumentException when an IOException occurs or the file is empty.
	 */
	
	public List<String> readFileToList(String filepath) {
		
		filepath = Paths.get(".").toAbsolutePath().normalize().toString() + filepath;
		List<String> datas = new ArrayList<String>();
		BufferedReader br = null;
		String line = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			line = br.readLine();
		    while (line != null) {
		        
		        if (line != null) {
		        	datas.add(line);
		        }
		        line = br.readLine();
		    }
		    
		    br.close();
		}  catch (IOException e) {
			 throw new IllegalArgumentException("Something went wrong while reading the file. Probably wrong path or file doesn't exist.");
		} 
		if (datas.size() == 0) {
			throw new IllegalArgumentException("File was empty.");
		}
		
		return datas;
	}
}