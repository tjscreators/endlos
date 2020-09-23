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

import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjs.common.kernal.CustomInitializationBean;
import com.tjs.common.service.AbstractService;
import com.tjs.common.user.enums.GroupEnum;
import com.tjs.common.user.model.GroupModel;
import com.tjs.endlos.exception.EndlosException;

/**
 * This class used to implement all database related operation that will be performed on group table.
 * @author Nirav.Shah
 * @since 14/02/2018
 */
@Service(value = "groupService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Throwable.class)
public class GroupServiceImpl extends AbstractService<GroupModel> implements GroupService, CustomInitializationBean {

	@Override
	public String getEntityName() {
		return GROUP_MODEL;
	}

	@Override
	public Criteria setCommonCriteria(String entityName) {
		Criteria criteria = getSession().createCriteria(entityName);
		return criteria;
	}

	@Override
	public Criteria setSearchCriteria(Object searchObject, Criteria commonCriteria) {
		return commonCriteria;
	}

	@Override
	public void onStartUp() throws EndlosException {
		for(Entry<Integer, GroupEnum> groupMap : GroupEnum.MAP.entrySet()) {
			GroupModel groupModel = get(groupMap.getKey());
			if(groupModel == null) {
				groupModel = new GroupModel();
				groupModel.setId(groupMap.getKey().longValue());
				groupModel.setName(groupMap.getValue().getName());
				create(groupModel);
			}
		}
	}
}