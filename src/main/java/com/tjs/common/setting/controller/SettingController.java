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
package com.tjs.common.setting.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.controller.Controller;
import com.tjs.common.response.Response;
import com.tjs.common.setting.view.SettingView;
import com.tjs.endlos.exception.EndlosException;

/**
 * 
 * @author Nirav
 * @since 24/11/2018
 *
 */
public interface SettingController extends Controller {

	/**
	 * This method is used to handle view request coming from hospital for any
	 * module.
	 * 
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	// TODO authorization annotation
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	Response view(@RequestParam(name = "key", required = true) String key) throws EndlosException;

	/**
	 * This method is used to handle edit request coming from hospital for any
	 * module.
	 * 
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	// TODO authorization annotation
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	Response edit(@RequestParam(name = "key", required = true) String key) throws EndlosException;

	/**
	 * This method is used to handle update request coming from hospital for any
	 * module.
	 * 
	 * @param settingView
	 * @return
	 * @throws EndlosException
	 */
	// TODO authorization annotation
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	@AccessLog
	Response update(@RequestBody SettingView settingView) throws EndlosException;

	/**
	 * This method is used to handle search request coming from hospital for any
	 * module.
	 * 
	 * @param settingView
	 * @return
	 * @throws EndlosException
	 */
	// TODO authorization annotation
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	Response search(@RequestBody(required = false) SettingView settingView,
			@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "recordSize", required = false) Integer recordSize) throws EndlosException;
}
