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
package com.tjs.common.operation;

import com.tjs.common.response.Response;
import com.tjs.common.view.View;
import com.tjs.endlos.exception.EndlosException;

/**
 * This is a base operation which is used to declare common business
 * operations(logic) which can be performed on every entity. Operation bridges
 * the gap between controller & model.
 * @author Nirav.Shah
 * @since 02/08/2018
 */
public interface BaseOperation<V extends View> extends Operation {

	/**
	 * This method is used to validate add request to add any entity into system.
	 * Once it is been validate. it allow users to add entity data.
	 * @return
	 * @throws EndlosException
	 */
	Response doAdd() throws EndlosException;
	
	/**
	 * This method is used to save entity
	 * @param request
	 * @return
	 * @throws EndlosException
	 */
	Response doSave(V view) throws EndlosException;
	
	/**
	 * This method is used to view entity.
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	Response doView(Long id) throws EndlosException;
	
	/**
	 * This method is used to edit entity.
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	Response doEdit(Long id) throws EndlosException;

	/**
	 * This method is used to update entity
	 * @param view
	 * @return
	 * @throws EndlosException
	 */
	Response doUpdate(V view) throws EndlosException;

	/**
	 * This method is used delete existing data.
	 * 
	 * @param id
	 * @return
	 */
	Response doDelete(Long id) throws EndlosException;
	
	/**
	 * This method is used active/inactive entity.
	 * @param id
	 * @return
	 * @throws EndlosException
	 */
	Response doActiveInActive(Long id) throws EndlosException;
	
	/**
	 * This method is used to display data in tabluar format.
	 * 
	 * @param start
	 * @param recordSize
	 * @return
	 */
	Response doDisplayGrid(Integer start, Integer recordSize);
	
	/**
	 * This method is used to display data in tabluar format.
	 * 
	 * @param object
	 * @param start
	 * @param recordSize
	 * @return
	 */
	Response doSearch(V view, Integer start, Integer recordSize) throws EndlosException;
	
	
}
