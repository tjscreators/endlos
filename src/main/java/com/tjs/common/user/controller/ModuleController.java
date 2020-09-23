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
package com.tjs.common.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.controller.Controller;
import com.tjs.common.response.Response;
import com.tjs.endlos.exception.EndlosException;

/**
 * 
 * @author Nirav.Shah
 * @since 14/02/2018
 *
 */
public interface ModuleController extends Controller {
	
	/**
	 * This method is used to get list of modules.
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	Response all() throws EndlosException;
}
