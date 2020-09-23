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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.controller.Controller;
import com.tjs.common.response.Response;
import com.tjs.common.user.view.UserView;
import com.tjs.endlos.exception.EndlosException;

/**
 * This controller for handle user public apis.
 * 
 * @author jaydip.golviya
 * @since 06/08/2020
 */
public interface UserPublicController extends Controller {

	/**
	 * Validate users credentials and allow him to login into a system.
	 * 
	 * @param userView
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	Response login(@RequestBody UserView userView, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws EndlosException;

	/**
	 * this api for user register.
	 * 
	 * @param userView
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	Response register(@RequestBody UserView userView) throws EndlosException;

	/**
	 * To Get Reset Password link.
	 * 
	 * @param userView
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/send-reset-link", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	Response sendResetLink(@RequestBody UserView userView) throws EndlosException;

	/**
	 * This method is used to reset password token
	 * 
	 * @param token
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/reset-password-verification", method = RequestMethod.GET)
	@ResponseBody
	Response resetPasswordVerification(@RequestParam("resetPasswordVerificationToken") String token) throws EndlosException;

	/**
	 * this api for activate user account.
	 * 
	 * @param activationToken
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/activate-account", method = RequestMethod.GET)
	@ResponseBody
	Response activateAccount(@RequestParam("activationToken") String activationToken) throws EndlosException;
}
