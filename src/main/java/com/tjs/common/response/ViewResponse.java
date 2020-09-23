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
package com.tjs.common.response;

import com.tjs.common.view.View;

/**
 * This is used to send response of view request for any model.
 * @author Nirav Shah
 * @since 03/08/2018
 */
public class ViewResponse extends CommonResponse{

	private static final long serialVersionUID = 3944857319523952086L;
    private View view;
    
	protected ViewResponse(int responseCode, String message, View view) {
		super(responseCode, message);
		this.view = view;
	}
	
	public static ViewResponse create(int responseCode, String message, View view){
		return new ViewResponse(responseCode, message, view);
	}
	
    public View getView(){
    	return view;
    }
}
