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
package com.tjs.common.user.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjs.common.operation.BaseOperation;
import com.tjs.common.response.Response;
import com.tjs.common.user.view.UserView;
import com.tjs.endlos.exception.EndlosException;

/**
 * @author Dhruvang.Joshi
 * @since 30/11/2018
 */
public interface UserOperation extends BaseOperation<UserView> {

	/**
	 * Validate users credential, session and device to allow him to login into a
	 * system.
	 * 
	 * @param userView
	 * @param request
	 * @param response
	 * @param isLoginThroughEmail
	 * @return
	 * @throws EndlosException
	 */
	Response doLogin(UserView userView, HttpServletRequest request, HttpServletResponse response,
			boolean isLoginThroughEmail) throws EndlosException;

	/**
	 * This method is used to remove user's auth token.
	 * 
	 * @param request
	 * @return
	 * @throws EndlosException
	 */
	Response doLogout(String session) throws EndlosException;

	/**
	 * This method is used to send reset password link.
	 * 
	 * @param userView
	 * @param isLoginThroughEmail
	 * @return
	 * @throws EndlosException
	 */
	Response doSendResetLink(UserView userView, boolean isLoginThroughEmail) throws EndlosException;

	/**
	 * This method validates User's reset password token.
	 * 
	 * @param token
	 * @return
	 * @throws EndlosException
	 */
	Response doResetPasswordVerification(String token) throws EndlosException;

	/**
	 * This method is used to reset user's password.
	 * 
	 * @param userView
	 * @return
	 * @throws EndlosException
	 */
	Response doResetPassword(UserView userView) throws EndlosException;

	/**
	 * This method is used to change user's password.
	 * 
	 * @param userView
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws EndlosException
	 */
	Response doChangePassword(UserView userView, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws EndlosException;

	/**
	 * This method is used to get islogged in.
	 * 
	 * @return
	 * @throws EndlosException
	 */
	Response doIsLoggedIn() throws EndlosException;

	/**
	 * this method use to send otp for reset password.
	 * 
	 * @param userView
	 * @return
	 * @throws EndlosException
	 */
	Response doSendResetOtp(UserView userView) throws EndlosException;

	/**
	 * this method for verify otp.
	 * 
	 * @param userView
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws EndlosException
	 */
	Response doVerifyOtp(UserView userView, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws EndlosException;

	/**
	 * this method for user registration
	 * 
	 * @param userView
	 * @return
	 * @throws EndlosException
	 */
	Response doRegister(UserView userView) throws EndlosException;

	/**
	 * This method for activate user account.
	 * 
	 * @param activationToken
	 * @return
	 * @throws EndlosException
	 */
	Response doActivateAccount(String activationToken) throws EndlosException;

}