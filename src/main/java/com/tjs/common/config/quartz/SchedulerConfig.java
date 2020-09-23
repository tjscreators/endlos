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
package com.tjs.common.config.quartz;

import java.util.Properties;

import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * This class configures quartz scheduler properties.
 * 
 * @author nirav
 *
 */
@Configuration
public class SchedulerConfig {

	@Autowired
	private QuartzProperties quartzProperties;

	/**
	 * This method binds application context with job factory. And This job factory
	 * will be binded with Scheduler factory so application context will be
	 * available in every job.
	 * 
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	/**
	 * This method prepares a scheduler factory bean.
	 * @param jobFactory
	 * @return
	 * @throws SchedulerException
	 */
	@Bean(name = "schedulerFactoryBean")
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) throws SchedulerException {

		Properties properties = new Properties();
		properties.putAll(quartzProperties.getProperties());

		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setOverwriteExistingJobs(true);
		schedulerFactoryBean.setQuartzProperties(properties);
		schedulerFactoryBean.setJobFactory(jobFactory);
		schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(false);
		return schedulerFactoryBean;
	}
}
