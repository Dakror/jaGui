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
			if (flatData.has("m_Font") && !flatData.isNull("m_Font")) globalFont = Font.createFont(Font.TRUETYPE_FONT, new File(skinFile.getParentFile().getPath() + "/" + flatData.getString("m_Font")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Font getGlobalFont() {
		return globalFont;
	}
}
