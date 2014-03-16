package de.dakror.jagui.skin;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;

/**
 * @author Dakror
 */
public class Skin
{
	// -- modes -- //
	ComponentMode normal;
	ComponentMode active;
	ComponentMode focused;
	ComponentMode hover;
	
	// -- event modes -- //
	ComponentMode on_normal;
	ComponentMode on_active;
	ComponentMode on_focused;
	ComponentMode on_hover;
	
	Alignment alignment;
	
	ImagePosition imagePosition;
	
	Font font;
	
	Insets padding;
	Insets border;
	
	Point contentOffset;
	
	int textClipping;
	int fixedWith;
	int fixedHeight;
	
	boolean richText;
	boolean wordWrap;
	boolean stretchWidth;
	boolean stretchHeight;
}
