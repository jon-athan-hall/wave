package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		
		velX = 4;
		velY = 4;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		/**
		 * Reverse velocities when a collision with an edge occurs.
		 */
		if(y < 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if(x < 0 || x >= Game.WIDTH - 16) velX *= -1;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

}