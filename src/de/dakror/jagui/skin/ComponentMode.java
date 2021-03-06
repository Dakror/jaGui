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
