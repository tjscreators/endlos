package com.tjs.common.client.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.aop.AccessLog;
import com.tjs.common.client.view.ClientView;
import com.tjs.common.controller.Controller;
import com.tjs.common.response.Response;
import com.tjs.endlos.exception.EndlosException;

public interface ClientPublicController extends Controller {

	/**
	 * this api for client register.
	 * 
	 * @param clientView
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	@AccessLog
	Response register(@RequestBody ClientView clientView) throws EndlosException;

	/**
	 * this api for activate client it self.
	 * 
	 * @param token
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/activation", method = RequestMethod.GET)
	@ResponseBody
	Response activation(@RequestParam("activationToken") String activationToken) throws EndlosException;
}
