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
import java.awt.Insets;
import java.awt.Point;

/**
 * @author Dakror
 */
public class Skin {
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
