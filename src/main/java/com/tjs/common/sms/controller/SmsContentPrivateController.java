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
package com.tjs.common.sms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.controller.BaseController;
import com.tjs.common.response.Response;
import com.tjs.common.sms.view.SmsContentView;
import com.tjs.endlos.exception.EndlosException;

/**
 * This controller maps all sms content related apis.
 * 
 * @author JD
 * @since 28/08/2019
 */
public interface SmsContentPrivateController extends BaseController<SmsContentView> {

	/**
	 * This method is used to prepare dropdown for communication field.
	 * 
	 * @return
	 * @throws NinetyOneERPException
	 */
	@RequestMapping(value = "/communication-fields", method = RequestMethod.GET)
	@ResponseBody
	@AccessLog
	public Response communicationFields() throws EndlosException;

}
