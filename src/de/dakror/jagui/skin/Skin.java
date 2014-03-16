package de.dakror.jagui.skin;

import java.awt.Insets;

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
	
	Insets padding;
	
	boolean richText;
	boolean wordWrap;
}
