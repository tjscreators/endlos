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
package com.tjs.endlos.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.enums.ResponseCode;
import com.tjs.common.response.Response;
import com.tjs.endlos.data.operation.DataOperation;
import com.tjs.endlos.data.view.DataView;
import com.tjs.endlos.exception.EndlosException;

/**
 * this controller for handle data related apis
 */
@Controller
@RequestMapping("/public/data")
public class DataPublicControllerImpl implements DataPublicController {

	@Autowired
	private DataOperation dataOperation;

	@Override
	@AccessLog
	public Response getCounter(@RequestBody DataView dataView) throws EndlosException {
		if (dataView == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		DataView.isValid(dataView);
		return dataOperation.doGetCounter(dataView);
	}

}
