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
package com.tjs.endlos.data.view;

import com.tjs.common.enums.ResponseCode;
import com.tjs.common.view.IdentifierView;
import com.tjs.endlos.exception.EndlosException;

public class DataView extends IdentifierView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1436452014063649958L;
	private Long entryId;
	private Boolean isCount;
	private Boolean isFinish;

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public Boolean getIsCount() {
		return isCount;
	}

	public void setIsCount(Boolean isCount) {
		this.isCount = isCount;
	}

	public Boolean getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(Boolean isFinish) {
		this.isFinish = isFinish;
	}

	public static void isValid(DataView dataView) throws EndlosException {
		if ((dataView.getIsCount() == null && dataView.getIsFinish() == null)
				|| (dataView.getIsFinish() != null && !dataView.getIsFinish())
				|| (dataView.getIsCount() != null && dataView.getIsFinish() != null)) {
			throw new EndlosException(ResponseCode.INVALID_REQUEST.getCode(),
					ResponseCode.INVALID_REQUEST.getMessage());
		}
	}

}
