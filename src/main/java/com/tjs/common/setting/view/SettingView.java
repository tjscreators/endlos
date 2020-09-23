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
package com.tjs.common.setting.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tjs.common.view.View;

/**
 * This class is used to represent setting object in json/in hospital response.
 * 
 * @author Nirav
 * @since 24/11/2018
 */

@JsonInclude(Include.NON_NULL)
public class SettingView implements View {

	private static final long serialVersionUID = 6298419420042301917L;
	private String key;
	private String value;
	private Object displayValue;

	public SettingView(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Object getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(Object displayValue) {
		this.displayValue = displayValue;
	}

	public SettingView() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
