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
package com.tjs.endlos.data.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import com.tjs.common.service.AbstractService;
import com.tjs.endlos.data.model.DataModel;

@Service(value = "dataService")
public class DataServiceImpl extends AbstractService<DataModel> implements DataService {

	@Override
	public String getEntityName() {
		return DATA_MODEL;
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
	public DataModel get() {
		Criteria criteria=setCommonCriteria(DATA_MODEL);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(1);
		return (DataModel)criteria.uniqueResult();
	}

}
