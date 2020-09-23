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
package com.tjs.common.file.service;

import com.tjs.common.file.model.FileModel;
import com.tjs.common.service.BaseService;

/**
 * 
 * @author Dhruvang.Joshi
 * @since 30/11/2017
 */
public interface FileService extends BaseService<FileModel> {
	String FILE_MODEL = "fileModel";

	/**
	 * This method is used to get File value base on given file id.
	 * 
	 * @param fileId
	 * @return
	 */
	FileModel getByFileId(String fileId);

	/**
	 * This method is used to delete attachment.
	 * 
	 * @param fileModel
	 */
	void delete(FileModel fileModel);
}
