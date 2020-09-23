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
package com.tjs.endlos.service;

import com.tjs.common.service.BaseService;
import com.tjs.endlos.model.DataModel;

public interface DataService extends BaseService<DataModel> {

	String DATA_MODEL = "dataModel";

	/**
	 * this method for get latest counter model.
	 * 
	 * @return
	 */
	DataModel get();
}
