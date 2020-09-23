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
package com.tjs.common.user.enums;

import java.util.HashMap;
import java.util.Map;

import com.tjs.common.enums.EnumType;

/**
 * This is Rights enum which represent rights of system.
 * @author Nirav.Shah
 * @since 08/02/2018
 */
public enum RightsEnum implements EnumType {

	ADD(1, "Add"), //Add, Save
	UPDATE(2,"Update"), //Update, Edit,
	VIEW(3, "View"), //View
	DELETE(4,"Delete"),//Delete
	ACTIVATION(5,"Activation"),//Activation
	LIST(6,"List"), //List,Search
	EXPORT(7,"Export"),//Export
	FILE_UPLOAD(8,"FileUpload"); // File Upload
	
	private final int id;
    private final String name;
    public static final Map<Integer, RightsEnum> MAP = new HashMap<>();
    
    static{
    	for(RightsEnum rightsEnums : values()){
    		MAP.put(rightsEnums.getId(), rightsEnums);
    	}
    }
    
    RightsEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    
    /**
	 * This methods is used to fetch Enum base on given id.
	 * @param id enum key
	 * @return rightsEnums enum
	 */
    public static RightsEnum fromId(Integer id) {
       return MAP.get(id);
    }
}
