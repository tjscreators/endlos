/*******************************************************************************
 * Copyright -2018 @Emotome
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.tjs.endlos.exception;

/**
 * This is custom exception which contains error code & message.
 * This will be thrown by any class when custom error occurs.
 * @author Nirav.Shah
 * @since 02/08/2018
 */
public class EndlosException extends Exception{

	private static final long serialVersionUID = -3144332640812445838L;
	private int code;
	
	public EndlosException(int code) {
		super();
		this.code = code;
	}
	
	public EndlosException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
