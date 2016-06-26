/*
 * Copyright 2016 Alberto Gaona.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.albertogaona.centi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Utility main class to run application under Spring Boot.
 * @author Alberto Gaona
 */
@SpringBootApplication
public class CentiApplication {
	/**
	 * Starts the application in a command line environment.
	 * @param args
	 */
    public static void main (String [] args) {
        SpringApplication.run(CentiApplication.class, args);
    }
}
