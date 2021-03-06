package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	/**
	 * Not good to use static variables like this. Static will make
	 * it available as HUD.HEALTH without having to initialize a HUD
	 * object.
	 */
	public static float HEALTH = 100;
	public int bounds = 0;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100 + (bounds / 2));
		
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(16, 16, 200, 32);
		
		/**
		 * Creates a color based on hue, saturation, and brightness.
		 */
		g.setColor(Color.getHSBColor((1f * HEALTH) / 360, 1f, 1f));
		
		g.fillRect(16, 16, (int) HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(16, 16, 200 + bounds, 32);
		
		g.drawString("Score: " + score, 16, 64);
		g.drawString("Level: " + level, 16, 80);
		g.drawString("Click spacebar for Shop", 16, 96);
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
}
