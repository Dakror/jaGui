package de.dakror.jaguitest.game;

import java.awt.Graphics2D;

import de.dakror.gamesetup.GameFrame;
import de.dakror.gamesetup.util.Helper;
import de.dakror.jaguitest.layer.GameLayer;

/**
 * @author Dakror
 */
public class Game extends GameFrame
{
	public static Game currentGame;
	
	public Game()
	{
		super();
		currentGame = this;
	}
	
	@Override
	public void initGame()
	{
		addLayer(new GameLayer());
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		drawLayers(g);
		Helper.drawString("FPS: " + getFPS(), 0, 18, g, 18);
		Helper.drawString("UPS: " + getUPS(), 0, 36, g, 18);
	}
}
