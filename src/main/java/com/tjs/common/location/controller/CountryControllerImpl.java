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
package com.tjs.common.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.controller.AbstractController;
import com.tjs.common.enums.ResponseCode;
import com.tjs.common.location.operation.CountryOperation;
import com.tjs.common.location.view.CountryView;
import com.tjs.common.operation.BaseOperation;
import com.tjs.common.response.Response;
import com.tjs.common.validation.DataType;
import com.tjs.common.validation.InputField;
import com.tjs.common.validation.Validator;
import com.tjs.endlos.exception.EndlosException;

/**
 * This controller maps all city related apis.
 * 
 * @author Dhruvang
 * @since 29/01/2018
 */
@Controller
@RequestMapping("/country")
public class CountryControllerImpl extends AbstractController<CountryView> implements CountryController {

	@Autowired
	private CountryOperation countryOperation;

	@Override
	public BaseOperation<CountryView> getOperation() {
		return countryOperation;
	}

	@Override
	public Response add() throws EndlosException {
		throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
	}

	@Override
	public Response search(@RequestBody CountryView countryView, Integer start, Integer recordSize)
			throws EndlosException {
		return countryOperation.doSearch(countryView, start, recordSize);
	}

	@Override
	public void isValidSaveData(CountryView countryView) throws EndlosException {
		Validator.COUNTRY_NAME.isValid(new InputField(countryView.getName(), DataType.STRING, 150));
		Validator.COUNTRY_SHORT_NAME.isValid(new InputField(countryView.getSortName(), DataType.STRING, 3));
		if (countryView.getPhoneCode() == 0) {
			throw new EndlosException(ResponseCode.DATA_IS_MISSING.getCode(),
					"Country Phone Code " + ResponseCode.DATA_IS_MISSING.getMessage());
		}
	}

	@Override
	public Response search(Integer start) throws EndlosException {
		return countryOperation.doSearch(null, start, null);
	}

	@Override
	@AccessLog
	public Response update(@RequestBody CountryView countryView) throws EndlosException {
		if (countryView == null) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		if (countryView.getId() == null) {
			throw new EndlosException(ResponseCode.DATA_IS_MISSING.getCode(),
					"Id " + ResponseCode.DATA_IS_MISSING.getMessage());
		}
		isValidSaveData(countryView);
		return getOperation().doUpdate(countryView);
	}

	@Override
	@AccessLog
	public Response delete(@RequestParam(name = "id", required = true) Long id) throws EndlosException {
		throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
	}

	@Override
	@AccessLog
	public Response activeInActive(@RequestParam(name = "id", required = true) Long id) throws EndlosException {
		throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
	}

	@Override
	public Response dropdown() throws EndlosException {
		return countryOperation.doDropdown();
	}
}