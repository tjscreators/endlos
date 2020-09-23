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
package com.tjs.common.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.enums.ResponseCode;
import com.tjs.common.operation.BaseOperation;
import com.tjs.common.response.Response;
import com.tjs.common.view.View;
import com.tjs.endlos.exception.EndlosException;

/**
 * Its abstract class of controller. It provides abstract methods &
 * implementation of basic methods used by any controller.
 * @author Nirav.Shah
 * @since 08/08/2018
 * @param <V>
 */
public abstract class AbstractController<V extends View> {
	static final String ABSTRACT_CONTROLLER = "AbstractController";

	/**
	 * It is used to get operation which will be used inside controller.
	 * @return
	 */
	public abstract BaseOperation<V> getOperation();

	/**
	 * This method is used to validate add request to add any entity into system.
	 * Once it is been validate. it allow users to add entity data.
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	public abstract Response add() throws EndlosException;

	/**
	 * This method is used to handle save request coming from hospital for any
	 * module.
	 * @param request
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	public Response save(@RequestBody V view) throws EndlosException {
		if (view == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		isValidSaveData(view);
		return getOperation().doSave(view);
	}
	
	/**
	 * This method is used to handle view request coming from hospital for any
	 * module.
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	public Response view(@RequestParam(name="id", required=true) Long id) throws EndlosException{
		if (id == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		return getOperation().doView(id);
	}
	
	/**
	 * This method is used to handle edit request coming from hospital for any
	 * module.
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	public Response edit(@RequestParam(name="id", required=true) Long id) throws EndlosException{
		if (id == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		return getOperation().doEdit(id);
	}
	
	/**
	 * This method is used to handle update request coming from hospital for 
	 * any module.
	 * @param view
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	@AccessLog
	public Response update(@RequestBody V view) throws EndlosException {
		if (view == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		isValidSaveData(view);
		return getOperation().doUpdate(view);
	}

	/**
	 * This method is used to handle delete request coming from hospital for 
	 * any module.
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	@AccessLog
	public Response delete(@RequestParam(name="id", required=true) Long id) throws EndlosException{
		if (id == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		return getOperation().doDelete(id);
	}
	

	/**
	 * This method is used to handle active/inactive request.
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/activation", method = RequestMethod.PUT)
	@ResponseBody
	@AccessLog
	public Response activeInActive(@RequestParam(name="id", required=true) Long id) throws EndlosException{
		if (id == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		return getOperation().doActiveInActive(id);
	}
	
	/**
	 * This method is used to handle grid request coming from hospital for any
	 * module.
	 * @param request
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	public Response displayGrid(@RequestParam(name="start", required=true) Integer start, @RequestParam(name="recordSize", required=true) Integer recordSize) throws EndlosException {
		return getOperation().doDisplayGrid(start, recordSize);
	}
	
	/**
	 * This method is used to handle search request coming from hospital for any
	 * module.
	 * @param request
	 * @return
	 * @throws EndlosException
	 */
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	public abstract Response search(@RequestBody V view, @RequestParam(name="start", required=true) Integer start, @RequestParam(name="recordSize", required=true) Integer recordSize) throws EndlosException;
	
	/**
	 * This methods is used to validate data received from hospital side before
	 * saving or updating a module.
	 * @param view
	 * @throws EndlosException
	 */
	public abstract void isValidSaveData(V view) throws EndlosException;
}
