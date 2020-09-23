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
import com.tjs.common.user.model.UserPasswordModel;

/**
 * @author Nirav.Shah
 * @since 23/06/2018
 */
public interface UserPasswordService extends BaseService<UserPasswordModel> {
	String USER_PASSWORD_MODEL = "userPasswordModel";
	
	/**
	 * This method is used to fetch user's latest password.
	 * @param userId
	 * @return
	 */
	UserPasswordModel getCurrent(long userId);
	
	/**
	 * This method is used to fetch all password of user.
	 * @param userId
	 * @return
	 */
	List<UserPasswordModel> getByUser(long userId);
}
