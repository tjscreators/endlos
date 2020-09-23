package com.tjs.common.captcha.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjs.common.controller.Controller;
import com.tjs.common.response.Response;
import com.tjs.endlos.exception.EndlosException;

/**
 * 
 * @author Nirav.Shah
 * @since 17/12/2018
 *
 */
public interface CaptchaController extends Controller {
	/**
	 * This method is used to generate Captcha and store it in session.
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/generate-registration-captcha", method = RequestMethod.GET)
	@ResponseBody
	Response generateRegistrationCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws EndlosException;

	/**
	 * This method is used to download generated captcha image.
	 * @param captchaId
	 * @param httpServletResponse
	 * @return
	 * @throws EndlosException
	 */
	@RequestMapping(value = "/download-captcha", method = RequestMethod.GET)
	@ResponseBody
	Response downloadCaptcha(@RequestParam(value = "captchaId") String captchaId, HttpServletResponse httpServletResponse)
			throws EndlosException;
}