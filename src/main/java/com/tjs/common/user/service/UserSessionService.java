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
package com.tjs.common.user.service;

import java.util.List;

import com.tjs.common.service.BaseService;
import com.tjs.common.user.model.UserSessionModel;

/**
 * @author Nirav.Shah
 * @since 22/06/2018
 */
public interface UserSessionService extends BaseService<UserSessionModel> {

	String USER_SESSION_MODEL = "userSessionModel";

	// String GET_USER_SESSION_MODEL = "getUserSessionModel";
	/**
	 * This method is used to validate session of user and also provide valid user
	 * object.
	 * 
	 * @param userSession
	 * @return
	 */
	UserSessionModel get(String session);

	/**
	 * This method is used to validate new and current device based on cookie.
	 * 
	 * @param deviceCookie
	 * @return
	 */
	UserSessionModel getByDeviceCookie(String deviceCookie, Long userId);

	/**
	 * This method is used to get device count which used by particular user.
	 * 
	 * @param userId
	 * @return
	 */
	Long deviceUsed(Long userId);

	/**
	 * This method is used to get least unused device to over right in case of max
	 * allowed device count is bridged.
	 * 
	 * @param userId
	 * @return
	 */
	void deleteLeastUnused(Long userId);

	/**
	 * This method is used to validate reset password session.
	 * 
	 * @param userSession
	 * @return
	 */
	UserSessionModel getResetPassword(String session);

	/**
	 * This method is used to get user session object based on device cookie and
	 * session cookie.
	 * 
	 * @param sessionCookie
	 * @param deviceCookie
	 * @return
	 */
	UserSessionModel getByDeviceAndSessionCookie(String sessionCookie, String deviceCookie);

	/**
	 * This method is used to get all session from user.
	 * 
	 * @param userId
	 * @return
	 */
	List<UserSessionModel> getByUser(Long userId);

	/**
	 * This method is used to check that any one has accessed a system through that
	 * device.
	 * 
	 * @param deviceCookie
	 * @return
	 */
	boolean isDeviceRegistered(String deviceCookie);

	/**
	 * This method is used to get user session object based on device cookie and
	 * session cookie.
	 * 
	 * @param sessionCookie
	 * @param deviceCookie
	 * @return
	 */
	UserSessionModel getByDeviceAndSessionCookie(String sessionCookie, String deviceCookie, Long userId);

	/**
	 * this method for hard delete of user session.
	 * 
	 * @param userSessionModel
	 */
	void harddelete(UserSessionModel userSessionModel);
}