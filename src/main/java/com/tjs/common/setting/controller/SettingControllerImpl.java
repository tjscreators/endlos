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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.aop.AccessedByClient;
import com.tjs.common.aop.Authorization;
import com.tjs.common.enums.ResponseCode;
import com.tjs.common.response.Response;
import com.tjs.common.setting.operation.SettingOperation;
import com.tjs.common.setting.view.SettingView;
import com.tjs.common.user.enums.ModuleEnum;
import com.tjs.common.user.enums.RightsEnum;
import com.tjs.common.validation.DataType;
import com.tjs.common.validation.InputField;
import com.tjs.common.validation.Validator;
import com.tjs.endlos.exception.EndlosException;

/**
 * This controller maps all setting related apis.
 * 
 * @author Nirav
 * @since 24/11/2018
 */
@Controller
@RequestMapping("/private/setting")
public class SettingControllerImpl implements SettingController {

	@Autowired
	SettingOperation settingOperation;

	@Override
	@AccessLog
	@AccessedByClient
	@Authorization(modules = ModuleEnum.SETTING, rights = RightsEnum.LIST)
	public Response search(@RequestBody(required = false) SettingView settingView, Integer start, Integer recordSize)
			throws EndlosException {
		return settingOperation.doSearch(settingView, start, recordSize);
	}

	@Override
	@AccessLog
	@AccessedByClient
	@Authorization(modules = ModuleEnum.SETTING, rights = RightsEnum.UPDATE)
	public Response update(@RequestBody SettingView settingView) throws EndlosException {
		if (settingView == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		isValidSaveData(settingView);
		return settingOperation.doUpdate(settingView);
	}

	public void isValidSaveData(SettingView settingView) throws EndlosException {
		Validator.SETTING_KEY.isValid(new InputField(settingView.getKey(), DataType.STRING, 100));
		Validator.SETTING_VALUE.isValid(new InputField(settingView.getValue(), DataType.STRING, 1000));
	}

	@Override
	@AccessLog
	@AccessedByClient
	@Authorization(modules = ModuleEnum.SETTING, rights = RightsEnum.VIEW)
	public Response view(String key) throws EndlosException {
		if (StringUtils.isBlank(key)) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		return settingOperation.doView(key);
	}

	@Override
	@AccessLog
	@AccessedByClient
	@Authorization(modules = ModuleEnum.SETTING, rights = RightsEnum.UPDATE)
	public Response edit(String key) throws EndlosException {
		if (StringUtils.isBlank(key)) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
		return settingOperation.doEdit(key);
	}
}
