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
package com.tjs.common.email.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.tjs.common.client.model.ClientModel;
import com.tjs.common.model.ArchiveModel;
import com.tjs.common.model.IdentifierModel;
import com.tjs.endlos.email.enums.EmailAuthenticationMethod;
import com.tjs.endlos.email.enums.EmailAuthenticationSecurity;
import com.tjs.endlos.email.enums.ProviderType;

/**
 * This is Email account model which maps email account table.
 * 
 * @author Dhruvang.Joshi
 * @since 26/07/2017
 */

public class EmailAccountModel extends ArchiveModel {

	private static final long serialVersionUID = 4948296735319653785L;
	
	private Long lockVersion;
	private String name;
	private String host;
	private Long port;
	private String username;
	private String password;
	private String replyToEmail;
	private String emailFrom;
	private Long ratePerHour;
	private Long updateRatePerHour;
	private Long dateRatePerHour;
	private Long ratePerDay;
	private Long updateRatePerDay;
	private Long dateRatePerDay;
	private int authenticationMethod;
	private int authenticationSecurity;
	private Long timeOut;
	
	private static Map<Long, EmailAccountModel> MAP = new ConcurrentHashMap<>();
	private static Map<String, EmailAccountModel> DEFAULT_VALUE_MAP = new ConcurrentHashMap<>();
	
	static {
		EmailAccountModel emailAccountModel=new EmailAccountModel();
		emailAccountModel.setName("");
		emailAccountModel.setHost("email-smtp.us-east-1.amazonaws.com");
		emailAccountModel.setPort(465l);
		emailAccountModel.setUsername("AKIAIOH6IID4W54MKI3A");
		emailAccountModel.setPassword("AnfnoKMdZwRhGSWE7AVnJLOeEGlM2cljw+6HVpLx2GGN");
		emailAccountModel.setReplyToEmail("noreply@tallygo.in");
		emailAccountModel.setEmailFrom("SAAS PMS - Emotome Info Design Collective LLP");
		emailAccountModel.setRatePerHour(2000l);
		emailAccountModel.setUpdateRatePerHour(2000l);
		emailAccountModel.setRatePerDay(5000l);
		emailAccountModel.setUpdateRatePerDay(5000l);
		emailAccountModel.setAuthenticationMethod(EmailAuthenticationMethod.LOGIN.getId());
		emailAccountModel.setAuthenticationSecurity(EmailAuthenticationSecurity.SSL.getId());
		emailAccountModel.setTimeOut(60000l);
		DEFAULT_VALUE_MAP.put("defaultAccount", emailAccountModel);
	}

	public Long getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(Long lockVersion) {
		this.lockVersion = lockVersion;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EmailAuthenticationMethod getAuthenticationMethod() {
		return EmailAuthenticationMethod.fromId(authenticationMethod);
	}

	public void setAuthenticationMethod(Integer authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
	}

	public EmailAuthenticationSecurity getAuthenticationSecurity() {
		return EmailAuthenticationSecurity.fromId(authenticationSecurity);
	}

	public void setAuthenticationSecurity(Integer authenticationSecurity) {
		this.authenticationSecurity = authenticationSecurity;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public Long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Long timeOut) {
		this.timeOut = timeOut;
	}

	public String getReplyToEmail() {
		return replyToEmail;
	}

	public void setReplyToEmail(String replyToEmail) {
		this.replyToEmail = replyToEmail;
	}

	public static void addEmailAccount(EmailAccountModel emailAccountModel) {
		MAP.put(emailAccountModel.getId(), emailAccountModel);
	}
	
	public static void removeEmailAccount(EmailAccountModel emailAccountModel) {
		MAP.remove(emailAccountModel.getId());
	}
	
	public static void updateEmailAccount(EmailAccountModel emailAccountModel) {
		MAP.replace(emailAccountModel.getId(), emailAccountModel);
	}

	public Long getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(Long ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	public Long getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(Long ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	public Long getDateRatePerHour() {
		return dateRatePerHour;
	}

	public void setDateRatePerHour(Long dateRatePerHour) {
		this.dateRatePerHour = dateRatePerHour;
	}

	public Long getDateRatePerDay() {
		return dateRatePerDay;
	}

	public void setDateRatePerDay(Long dateRatePerDay) {
		this.dateRatePerDay = dateRatePerDay;
	}

	public Long getUpdateRatePerHour() {
		return updateRatePerHour;
	}

	public void setUpdateRatePerHour(Long updateRatePerHour) {
		this.updateRatePerHour = updateRatePerHour;
	}

	public Long getUpdateRatePerDay() {
		return updateRatePerDay;
	}

	public void setUpdateRatePerDay(Long updateRatePerDay) {
		this.updateRatePerDay = updateRatePerDay;
	}

	public static Map<Long, EmailAccountModel> getMAP() {
		return MAP;
	}
	
	public static Map<String, EmailAccountModel> getDefaultMAP() {
		return DEFAULT_VALUE_MAP;
	}

	public ProviderType getProviderType() {
		if (EmailAuthenticationSecurity.TLS.getId().equals(authenticationSecurity)) {
			return ProviderType.TLS_SECURE;
		} else if (EmailAuthenticationSecurity.SSL.getId().equals(authenticationSecurity)) {
			return ProviderType.SSL_SECURE;
		} else {
			return null;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentifierModel other = (IdentifierModel) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}