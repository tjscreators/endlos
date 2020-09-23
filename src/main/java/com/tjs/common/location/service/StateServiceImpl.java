/*******************************************************************************
 * Copyright -2017 @Emotome
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
package com.tjs.common.location.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjs.common.kernal.CustomInitializationBean;
import com.tjs.common.location.model.StateModel;
import com.tjs.common.service.AbstractService;
import com.tjs.endlos.exception.EndlosException;

/**
 * This class used to implement all database related operation that will be performed on state table.
 * @author Nirav
 * @since 10/11/2017
 */
@Service(value = "stateService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Throwable.class)
public class StateServiceImpl extends AbstractService<StateModel> implements StateService, CustomInitializationBean{
	
	@Override
	public String getEntityName() {
		return STATE_MODEL;
	}

	@Override
	public Criteria setCommonCriteria(String entityName) {
		Criteria criteria = getSession().createCriteria(getEntityName());
		return criteria;
	}

	@Override
	public Criteria setSearchCriteria(Object searchObject, Criteria commonCriteria) {
		return commonCriteria;
	}

	@Override
	public void onStartUp() throws EndlosException {
		List<StateModel> stateModelList = findAllUsingDiffEntity();
		for(StateModel stateModel : stateModelList) {
			StateModel.addState(stateModel);
			StateModel.addStateCity(stateModel.getId(), stateModel.getCities());
		}
	}

	@Override
	public List<StateModel> findAllUsingDiffEntity() {
		return findAll(STATE_CITY_MODEL);
	}
	
	@Override
	public StateModel getUsingDiffEntity(Long id) {
		return get(id, LIGHT_STATE_MODEL);
	}

	@Override
	public List<StateModel> findByCountry(Long countryId) {
		Criteria criteria = setCommonCriteria(getEntityName());
		criteria.add(Restrictions.eq("countryModel.id", countryId));
		return criteria.list();
	}
}