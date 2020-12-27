package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {
	
	private BufferedImage enemyImage;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		SpriteSheet ss = new SpriteSheet(Game.spriteSheet);
		
		enemyImage = ss.grabImage(3, 1, 16, 16);
		
		velX = 2;
		velY = 8;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		/**
		 * Reverse velocities when a collision with an edge occurs.
		 */
		if(y < 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if(x < 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		/**
		 * Fire off Trail objects that will slowly fade out in their place as
		 * the BasicEnemy moves around the screen. Removed for now.
		 */
		// new Trail((int) x, (int) y, ID.Trail, Color.cyan, 16, 16, 0.01f, handler);
		
	}

	public void render(Graphics g) {
		g.drawImage(enemyImage, (int) x, (int) y,  null);
	}

}
