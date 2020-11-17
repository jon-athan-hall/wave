package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	/**
	 * Not good to use static variables like this. Static will make
	 * it available as HUD.HEALTH without having to initialize a HUD
	 * object.
	 */
	public static int HEALTH = 100;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(16, 16, 200, 32);
		g.setColor(Color.green);
		g.fillRect(16, 16, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(16, 16, 200, 32);
	}
	
}
