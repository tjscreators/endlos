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
package com.tjs.endlos.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjs.common.enums.ResponseCode;
import com.tjs.common.response.Response;
import com.tjs.common.response.ViewResponse;
import com.tjs.endlos.exception.EndlosException;
import com.tjs.endlos.model.DataModel;
import com.tjs.endlos.service.DataService;
import com.tjs.endlos.view.DataView;

/**
 * This class used to perform all business operation on data model.
 * 
 * @author Jaydip
 * @since 20/09/2020
 */
@Component(value = "dataOperation")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class DataOperationImpl implements DataOperation {

	@Autowired
	private DataService dataService;

	@Override
	public Response doGetCounter(DataView dataView) throws EndlosException {
		DataModel dataModel = null;
		if (dataView.getIsCount() != null) {
			if(dataView.getIsCount()) {
				dataModel = dataService.get();
				if (dataModel != null) {
					dataModel.setEntryId(dataModel.getEntryId() + 1);
					dataService.update(dataModel);
				} else {
					dataModel = createModel();
				}
			}else {
				dataModel = dataService.get();
				if (dataModel == null) {
					dataModel = createModel();
				}
			}
		} else if (dataView.getIsFinish()) {
			dataModel = createModel();
		}
		return ViewResponse.create(ResponseCode.SUCCESSFUL.getCode(), ResponseCode.SUCCESSFUL.getMessage(),
				fromModel(dataModel, new DataView()));
	}

	public DataView fromModel(DataModel dataModel, DataView dataView) {
		DataView responseView = new DataView();
		responseView.setId(dataModel.getId());
		responseView.setEntryId(dataModel.getEntryId());
		return responseView;

	}

	public DataModel createModel() {
		DataModel dataModel = new DataModel();
		dataModel.setEntryId(1l);
		dataService.create(dataModel);
		return dataModel;
	}

}
