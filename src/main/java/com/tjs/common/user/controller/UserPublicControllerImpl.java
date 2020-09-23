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

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.enums.ResponseCode;
import com.tjs.common.logger.LoggerService;
import com.tjs.common.response.Response;
import com.tjs.common.user.operation.UserOperation;
import com.tjs.common.user.view.UserView;
import com.tjs.common.util.Utility;
import com.tjs.common.validation.DataType;
import com.tjs.common.validation.InputField;
import com.tjs.common.validation.RegexEnum;
import com.tjs.common.validation.Validator;
import com.tjs.endlos.exception.EndlosException;

/**
 * This controller maps all user related apis.
 * 
 * @author Dhruvang.Joshi
 * @since 24/11/2018
 */
@Controller
@RequestMapping("/public/user")
public class UserPublicControllerImpl implements UserPublicController {

	@Autowired
	private UserOperation userOperation;

	@Override
	@AccessLog
	public Response login(@RequestBody UserView userView, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws EndlosException {
		boolean isLoginThroughEmail = validateLoginDetails(userView);
		return userOperation.doLogin(userView, httpServletRequest, httpServletResponse, isLoginThroughEmail);
	}

	private boolean validateLoginDetails(UserView userView) throws EndlosException {
		if (StringUtils.isBlank(userView.getLoginId())) {
			throw new EndlosException(ResponseCode.DATA_IS_MISSING.getCode(),
					"Login Id " + ResponseCode.DATA_IS_MISSING.getMessage());
		}
		if (StringUtils.isBlank(userView.getPassword())) {
			throw new EndlosException(ResponseCode.DATA_IS_MISSING.getCode(),
					"Password " + ResponseCode.DATA_IS_MISSING.getMessage());
		}
		boolean isLoginThroughEmail = false;
		if (Utility.isValidPattern(userView.getLoginId(), RegexEnum.EMAIL.getValue())) {
			isLoginThroughEmail = true;
		}
		if (!isLoginThroughEmail) {
			if (!Utility.isValidPattern(userView.getLoginId(), RegexEnum.PHONE_NUMBER.getValue())) {
				throw new EndlosException(ResponseCode.INVALID_EMAIL_OR_MOBILE_NUMBER.getCode(),
						ResponseCode.INVALID_EMAIL_OR_MOBILE_NUMBER.getMessage());
			}
		}
		return isLoginThroughEmail;
	}

	@Override
	@AccessLog
	public Response register(@RequestBody UserView userView) throws EndlosException {
		if (userView == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		UserView.isValidRegistrationDetails(userView);
		try {
			return userOperation.doRegister(userView);
		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
			LoggerService.exception(dataIntegrityViolationException);
			throw new EndlosException(ResponseCode.ALREADY_EXIST.getCode(), "Email/Mobile already exists.");
		} catch (ConstraintViolationException constraintViolationException) {
			LoggerService.exception(constraintViolationException);
			throw new EndlosException(ResponseCode.ALREADY_EXIST.getCode(), "Email/Mobile already exists.");
		}
	}

	@Override
	@AccessLog
	public Response sendResetLink(@RequestBody UserView userView) throws EndlosException {
		if (userView == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
//		boolean isLoginThroughEmail = validateLoginDetails(userView);
		boolean isLoginThroughEmail = true;
		Validator.USER_EMAIL_ID.isValid(new InputField(userView.getLoginId(), DataType.STRING, 200, RegexEnum.EMAIL));
		return userOperation.doSendResetLink(userView, isLoginThroughEmail);
	}

	@Override
	@AccessLog
	public Response resetPasswordVerification(@RequestParam("resetPasswordVerificationToken") String token)
			throws EndlosException {
		if (StringUtils.isBlank(token)) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		return userOperation.doResetPasswordVerification(token);
	}

	@Override
	@AccessLog
	public Response activateAccount(@RequestParam("activationToken") String activationToken) throws EndlosException {
		if (StringUtils.isBlank(activationToken)) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		return userOperation.doActivateAccount(activationToken);
	}
}
