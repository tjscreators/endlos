package com.tjs.common.captcha.operation;

import com.tjs.common.captcha.model.CaptchaModel;
import com.tjs.common.captcha.service.CaptchaService;
import com.tjs.common.captcha.view.CaptchaView;
import com.tjs.common.operation.Operation;
import com.tjs.common.response.Response;
import com.tjs.endlos.exception.EndlosException;

/**
 *
 * @author Nirav.Shah
 * @version 1.0
 * @since 17/12/2018
 */

public interface CaptchaOperation extends Operation {

	/**
	 * This method is used to save captcha details.
	 * @param captcha
	 * @param uuid
	 * @return
	 * @throws EndlosException
	 */
	Response doSave(String captcha, String uuid) throws EndlosException;

	

	/**
	 * This method is used to prepare model from view.
	 * @param CaptchaModel
	 * @param captcha
	 * @return
	 */
	CaptchaModel toModel(CaptchaModel CaptchaModel, String captcha, String uuid);

	/**
	 * This method is used to prepare model from view.
	 * 
	 * @param request
	 * @return
	 */
	CaptchaModel getModel(CaptchaView captchaView);

	/**
	 * This method used when require new model for view
	 * 
	 * @param view
	 *            view of model
	 * @return model
	 */
	CaptchaModel getNewModel();

	/**
	 * This method used when need to convert model to view
	 * 
	 * @param model
	 * @return view
	 */

	CaptchaView fromModel(CaptchaModel CaptchaModel);

	/**
	 * This method use for get Service with respected operation
	 * 
	 * @return FileService
	 */

	CaptchaService getService();

	/**
	 * This method is used to get captcha details using captcha id.
	 * 
	 * @param fileId
	 * @return
	 * @throws IAException
	 */
	CaptchaModel get(String id) throws EndlosException;
}
