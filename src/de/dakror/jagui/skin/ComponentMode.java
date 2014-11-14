package de.dakror.jagui.skin;

import java.awt.Color;
import java.io.File;

/**
 * @author Dakror
 */
public class ComponentMode {
	Color textColor;
	File background;
	
	public ComponentMode(Color color, File background) {
		textColor = color;
		this.background = background;
	}
	
	public Color getTextColor() {
		return textColor;
	}
	
	public File getBackground() {
		return background;
	}
}
