package de.dakror.jaguitest.layer;

import java.awt.Color;
import java.awt.Graphics2D;

import de.dakror.gamesetup.layer.Layer;
import de.dakror.jaguitest.game.Game;

/**
 * @author Dakror
 */
public class GameLayer extends Layer
{
	float tick = 0;
	
	@Override
	public void draw(Graphics2D g)
	{
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.fillArc((int) (Math.sin(tick) * (Game.getWidth() / 2 - 25) + Game.getWidth() / 2 - 25), (int) (Math.cos(tick) * (Game.getHeight() / 2 - 135) + Game.getHeight() / 2 - 135), 50, 50, 0, 360);
		g.setColor(c);
	}
	
	@Override
	public void update(int tick)
	{
		this.tick += 0.01f;
	}
	
	@Override
	public void init()
	{}
	
}
