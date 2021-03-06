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
package com.tjs.endlos.data.operation;

import com.tjs.common.operation.Operation;
import com.tjs.common.response.Response;
import com.tjs.endlos.data.view.DataView;
import com.tjs.endlos.exception.EndlosException;

public interface DataOperation extends Operation {

	/**
	 * this method for get and update counter.
	 * 
	 * @param dataView
	 * @return
	 * @throws EndlosException
	 */
	Response doGetCounter(DataView dataView) throws EndlosException;
}
