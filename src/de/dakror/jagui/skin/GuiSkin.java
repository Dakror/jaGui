/*******************************************************************************
 * Copyright 2015 Maximilian Stark | Dakror <mail@dakror.de>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


package de.dakror.jagui.skin;

import java.awt.Font;
import java.io.File;

import org.json.JSONObject;

import de.dakror.gamesetup.util.Helper;

/**
 * @author Dakror
 */
public class GuiSkin {
	JSONObject flatData;
	File skinFile;
	Font globalFont;
	
	public GuiSkin(File file) {
		try {
			skinFile = file;
			flatData = new JSONObject(Helper.getFileContent(file)).getJSONObject("MonoBehaviour");
			if (flatData.has("m_Font") && !flatData.isNull("m_Font"))
				globalFont = Font.createFont(Font.TRUETYPE_FONT, new File(skinFile.getParentFile().getPath() + "/" + flatData.getString("m_Font")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Font getGlobalFont() {
		return globalFont;
	}
}
