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


package de.dakror.jaguitest.game;

import java.awt.Graphics2D;

import de.dakror.gamesetup.GameFrame;
import de.dakror.gamesetup.util.Helper;
import de.dakror.jaguitest.layer.GameLayer;

/**
 * @author Dakror
 */
public class Game extends GameFrame {
	public static Game currentGame;
	
	public Game() {
		super();
		currentGame = this;
	}
	
	@Override
	public void initGame() {
		addLayer(new GameLayer());
	}
	
	@Override
	public void draw(Graphics2D g) {
		drawLayers(g);
		Helper.drawString("FPS: " + getFPS(), 0, 18, g, 18);
		Helper.drawString("UPS: " + getUPS(), 0, 36, g, 18);
	}
}
