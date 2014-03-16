package de.dakror.jaguitest;

import javax.swing.UIManager;

import de.dakror.jaguitest.game.Game;
import de.dakror.jaguitest.game.UpdateThread;

/**
 * @author Dakror
 */
public class TestMain
{
	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		new Game();
		Game.currentFrame.init("jaGui Test Application");
		Game.currentFrame.updater = new UpdateThread();
		Game.currentFrame.setWindowed(800, 600);
		Game.w.setLocationRelativeTo(null);
		
		while (true)
			Game.currentFrame.main();
	}
}
