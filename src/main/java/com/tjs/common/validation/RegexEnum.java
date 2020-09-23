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
package com.tjs.common.validation;

import java.util.HashMap;
import java.util.Map;

/**
 * Regex that can be used to validate field value.
 * @author Nirav.Shah
 * @since 09/08/2018
 *
 */
public enum RegexEnum{
	
	ALBHABETS(1,"^[a-zA-Z]+$","Only Alphabets are allowed"),
	ALPHABETS_WITH_SPACE(2,"^[A-Za-z\\s]+$","Alphabets with space are allowed"),
	ALPHA_NUMERIC(3,"^[a-zA-Z0-9]+$","Alphabets and numbers are allowed"),
	ALPHA_NUMERIC_WITH_SPACE(4,"^[a-zA-Z0-9\\s]+$","Alphabets, numbers & space are allowed"),
	NUMERIC(5,"^[0-9]+$","Only numbers are allowed"),
	COUNTRY_CODE(6,"^$|^[0-9]{2,4}$", "Invalid mobile number"),
	CONTACT_NUMBER(7,"^$|^[0-9]{7,12}$","Invalid mobile number"),
	DESCRIPTION(8,"^[A-Za-z0-9]{1}[A-Za-z0-9._,\\(\\)\\s-]*$","Invalid mobile number"),
	EMAIL(9,"^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.([a-z]{1,5})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$","Invalid email id"),
	CAPTIAL_ALPHABETS(10,"^[A-Z]+$","Only capital letters are allowed"),
	CAPTIAL_ALPHABETS_WITH_NUMBER(11,"^[A-Z0-9]+$","Only capital letters with space are allowed"),
	URL(12,"<\\b(https|http?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>","Invalid URL"),
	PASSWORD(13,"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,16})", "Password doesn't comply"),
	PHONE_NUMBER(14,"^((\\+[1-9]?[0-9])|0)?[6-9][0-9]{9}$","Invalid Mobile no"),
	PIN_CODE(15,"\\b\\d{6}\\b","Invalid Pincode"),
	PAN_NUMBER(16,"[A-Za-z]{5}\\d{4}[A-Za-z]{1}","Invalid PAN Number"),
	WEBSITE(17,"^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$","Invalid Website"),
	DECIMAL(18,"[0-9]+(\\.[0-9][0-9]?)?","Invalid Decimal Number"),
	AMOUNT(19,"^[0-9.,]+$","Only numbers are allowed"),
	APPLICATION_REF_PRIFIX(20,"^[0-9A-Za-z\\\\s-]+$","Invalid Application Reference Number Prefix Only Alphabets, numbers & hyphen(-) are allowed"),
	LINKEDIN_URL(21,"http(s)?:\\/\\/([\\\\w]+\\\\.)?linkedin\\.com\\/(\\w)","Invalid Linkedin Url"),
	INSTAGRAM_URL(22,"https?:\\/\\/(www\\.)?instagram\\.com\\/([A-Za-z0-9_](?:(?:[A-Za-z0-9_]|(?:\\.(?!\\.))){0,28}(?:[A-Za-z0-9_]))?)","Invalid Instagram URL"),
	FACEBOOK_URL(23,"http(s)?:\\/\\/(www\\.)?(facebook|fb)\\.com\\/(A-z 0-9 _ - \\.)\\/?","Invalid Facebook URL"),
	TWITTER_URL(24,"http(s)?://(.*\\.)?twitter\\.com\\/[A-z 0-9 _]+\\/?","Invalid Twitter URL"),
	ALPHABETS_WITH_HYPEN(25,"^[A-Za-z-]+$","Alphabets with hypen is allowed."),
	ALPHA_NUMERIC_WITH_HYPEN(26,"^[a-zA-Z0-9-]+$","Alphabets, numbers & hypen are allowed"),
	ALPHABETS_WITH_SPACE_DOT(27,"^[A-Za-z.\\s]+$","Alphabets, space & dots are allowed"),
	ALPHABETS_WITH_SPACE_DOT_HYPEN(28,"^[A-Za-z.-\\s]+$","Alphabets, space, dots and hypen are allowed"),
	YOUTUBE_URL(29,"^(http(s)?:\\/\\/)?((w){3}.)?youtu(be|.be)?(\\.com)?\\/.+","Invalid Youtube URL"),
	KEYWORD(30,"^[a-zA-Z0-9_\\-]+$","Keyword is not in proper formet"),
	ALPHA_NUMERIC_WITH_SPECIFIC_SPECIAL_CHARACTER(31,"^[a-zA-Z0-9-_;:,.@/'{\"}\\s]+$","Alphabets, numbers & special character are allowed");
	

	private final int id;
    private final String value;
    private final String message;
    private static Map<Integer, RegexEnum> MAP = new HashMap<>(); 
    
    RegexEnum(int id, String value, String message) {
        this.id = id;
        this.value = value;
        this.message = message;
    }

    static{
    	for(RegexEnum regexEnum : values()){
    		MAP.put(regexEnum.getId(), regexEnum);
    	}
    }
    
    public int getId() {
        return id;
    }

    public String getValue() {
		return value;
	}
    
    public String getMessage(){
    	return message;
    }

	/**
	 * This methods is used to fetch Enum base on given id.
	 * @param id enum key
	 * @return RegexEnum enum
	 */
    public static RegexEnum fromId(int id) {
        return MAP.get(id);
    }

}
