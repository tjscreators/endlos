/*******************************************************************************
o * Copyright -2017 @Emotome
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
package com.tjs.common.location.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjs.common.enums.ResponseCode;
import com.tjs.common.location.model.CityModel;
import com.tjs.common.location.model.CountryModel;
import com.tjs.common.location.model.StateModel;
import com.tjs.common.location.service.CityService;
import com.tjs.common.location.service.StateService;
import com.tjs.common.location.view.CityView;
import com.tjs.common.location.view.StateView;
import com.tjs.common.operation.AbstractOperation;
import com.tjs.common.response.CommonResponse;
import com.tjs.common.response.PageResultResponse;
import com.tjs.common.response.Response;
import com.tjs.common.response.ViewResponse;
import com.tjs.common.service.BaseService;
import com.tjs.common.view.KeyValueView;
import com.tjs.endlos.exception.EndlosException;

/**
 * This class used to perform all business operation on city model.
 * @author Nirav
 * @since 14/11/2017
 */
@Component(value = "cityOperation")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class CityOperationImpl extends AbstractOperation<CityModel, CityView> implements CityOperation{

	@Autowired
	CityService cityService;
	
	@Autowired
	StateService stateService;
	
	@Override
	public Response doAdd() throws EndlosException {
		return null;
	}

	@Override
	public Response doSave(CityView cityView) throws EndlosException{
		CityModel cityModel = getModel(cityView);
		cityService.create(cityModel);
		CityModel.addCity(cityModel);
		return CommonResponse.create(ResponseCode.SAVE_SUCCESSFULLY.getCode(),	ResponseCode.SAVE_SUCCESSFULLY.getMessage());
	}
	
	@Override
	public Response doView(Long id) throws EndlosException {
		CityModel cityModel = CityModel.getMAP().get(id);
		if(cityModel == null) {
			cityModel = cityService.getUsingDiffEntity(id);
			if(cityModel == null) {
				throw new EndlosException(ResponseCode.NO_DATA_FOUND.getCode(), ResponseCode.NO_DATA_FOUND.getMessage());
			}
		}
		CityView cityView = fromModel(cityModel);
		return ViewResponse.create(ResponseCode.SUCCESSFUL.getCode(), ResponseCode.SUCCESSFUL.getMessage(), cityView);
	}

	@Override
	public Response doEdit(Long id) throws EndlosException {
		CityModel cityModel = CityModel.getMAP().get(id);
		if(cityModel == null) {
				throw new EndlosException(ResponseCode.NO_DATA_FOUND.getCode(), ResponseCode.NO_DATA_FOUND.getMessage());
		}
		
		CityView cityView = fromModel(cityModel);
		
		StateModel stateModel = stateService.get(cityModel.getStateModel().getId());
		Set<StateModel> stateModelList = CountryModel.getCountryStateMap().get(stateModel.getCountryModel().getId());
		
		List<KeyValueView> listView = new ArrayList<>(stateModelList.size());
		for(StateModel temp : stateModelList) {
			listView.add(KeyValueView.create(temp.getId().intValue(), temp.getName()));
		}
		Collections.sort(listView, KeyValueView.nameComparator);
		cityView.setStateList(listView);
		
		return ViewResponse.create(ResponseCode.SUCCESSFUL.getCode(), ResponseCode.SUCCESSFUL.getMessage(), cityView);
	}

	@Override
	public Response doUpdate(CityView cityView) throws EndlosException{
		CityModel cityModel = loadModel(cityView);
		if (cityModel == null) {
			return CommonResponse.create(ResponseCode.INVALID_REQUEST.getCode(), ResponseCode.INVALID_REQUEST.getMessage());
		}
		cityService.update(toModel(cityModel, cityView));
		CityModel.removeCity(cityModel);
		CityModel.addCity(cityModel);
		return CommonResponse.create(ResponseCode.UPDATE_SUCCESSFULLY.getCode(), ResponseCode.UPDATE_SUCCESSFULLY.getMessage());
	}
	
	@Override
	public Response doDelete(Long id) throws EndlosException {
		return null;
	}

	@Override
	public Response doActiveInActive(Long id) throws EndlosException {
		return null;
	}
	
	@Override
	public Response doSearch(CityView cityView, Integer start, Integer recordSize) throws EndlosException{
		List<CityView> cityViewList = new ArrayList<>();
		Set<CityModel> cityModelSet = StateModel.getStateCityMap().get(cityView.getStateId());
		if(cityModelSet == null || cityModelSet.isEmpty()) {
			return CommonResponse.create(ResponseCode.NO_DATA_FOUND.getCode(), ResponseCode.NO_DATA_FOUND.getMessage());
		}
		for(CityModel cityModel : cityModelSet) {
			CityView temp = new CityView();
			temp.setId(cityModel.getId());
			temp.setName(cityModel.getName());
			cityViewList.add(temp);
		}
		return PageResultResponse.create(ResponseCode.SUCCESSFUL.getCode(), ResponseCode.SUCCESSFUL.getMessage(), cityViewList.size(), cityViewList); 
	}

	@Override
	public CityModel toModel(CityModel cityModel, CityView cityView) {
		StateModel stateModel = stateService.get(cityView.getStateId());
		cityModel.setName(cityView.getName());
		cityModel.setStateModel(stateModel);
		return cityModel;
	}

	@Override
	protected CityModel getNewModel() {
		return new CityModel();
	}

	@Override
	public CityView fromModel(CityModel cityModel) {
		CityView cityView = new CityView();
		cityView.setId(cityModel.getId());
		cityView.setName(cityModel.getName());
		if(cityModel.getStateModel() != null) {
			StateView stateView = new StateView();
			stateView.setId(cityModel.getStateModel().getId());
			stateView.setName(cityModel.getStateModel().getName());
			cityView.setState(stateView);	
		}
		return cityView;
	}

	@Override
	public BaseService<CityModel> getService() {
		return cityService;
	}

	@Override
	protected void checkInactive(CityModel cityModel) throws EndlosException {
		return;
	}
	
	@Override
	protected CityModel loadModel(CityView cityView) {
		return cityService.get(cityView.getId());
	}
	
	@Override
	public Response doDropdown(Long stateId) throws EndlosException {
		List<CityView> cityViews = fromMap(stateId);
		if(cityViews != null && ! cityViews.isEmpty()) {
			return PageResultResponse.create(ResponseCode.SUCCESSFUL.getCode(), ResponseCode.SUCCESSFUL.getMessage(),
					cityViews.size(), cityViews);	
		}
		List<CityModel> cityModels = cityService.findByState(stateId);		
		if (cityModels.isEmpty()) {
			return CommonResponse.create(ResponseCode.NO_DATA_FOUND.getCode(), ResponseCode.NO_DATA_FOUND.getMessage());
		}
		return PageResultResponse.create(ResponseCode.SUCCESSFUL.getCode(), ResponseCode.SUCCESSFUL.getMessage(),
				cityModels.size(), fromModelList(cityModels));
	}
	
	private List<CityView> fromMap(Long stateId){
		Set<CityModel> cityModelSet = StateModel.getStateCityMap().get(stateId);
		List<CityView> cityViews = new ArrayList<>();
		if (cityModelSet != null && cityModelSet.isEmpty() == false) {			
			for (CityModel cityModel : cityModelSet) {
				CityView cityView = fromModel(cityModel);
				cityViews.add(cityView);
			}
			return cityViews;
		}
		return null;
	}
}