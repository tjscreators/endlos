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
package com.tjs.common.modelenums;

import java.util.HashMap;
import java.util.Map;

/**
 * This is common enum which represent yes/no values to map status of any model.
 * @author Nirav Shah
 * @since 02/08/2018
 */
public enum CommonStatusEnum implements ModelEnum{
	
	NO(0, "NO"),
	YES(1, "YES");
	
	private final Integer id;
    private final String name;
    private static final Map<Integer, CommonStatusEnum> MAP = new HashMap<>();
    
    static{
    	for(CommonStatusEnum commonStatus : values()){
    		MAP.put(commonStatus.getId(), commonStatus);
    	}
    }
    
    CommonStatusEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    
    /**
	 * This methods is used to fetch Enum base on given id.
	 * @param id enum key
	 * @return ActiveInActive enum
	 */
    public static CommonStatusEnum fromId(Integer id) {
        return MAP.get(id);
    }
}
