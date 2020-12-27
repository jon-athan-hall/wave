package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HardEnemy extends GameObject {
	
	private Random r = new Random();
	
	private BufferedImage enemyImage;

	public HardEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		SpriteSheet ss = new SpriteSheet(Game.spriteSheet);
		
		enemyImage = ss.grabImage(1, 2, 16, 16);
		
		velX = 4;
		velY = 4;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		/**
		 * Reverse velocities when a collision with an edge occurs.
		 * Also make those new velocities random and therefore unpredictable.
		 */
		if(y < 0 || y >= Game.HEIGHT - 16) {
			if(velY <= 0) {
				velY = r.nextInt(8) + 1;
			} else {
				velY = (r.nextInt(8) + 1) * -1;
			}
		}
		if(x < 0 || x >= Game.WIDTH - 16) {
			if(velX <= 0) {
				velX = r.nextInt(8) + 1;
			} else {
				velX = (r.nextInt(8) + 1) * -1;
			}
		}
		
		/**
		 * Fire off Trail objects that will slowly fade out in their place as
		 * the BasicEnemy moves around the screen. Removed for now.
		 */
		//new Trail((int) x, (int) y, ID.Trail, Color.yellow, 16, 16, 0.01f, handler);
		
	}

	public void render(Graphics g) {
		g.drawImage(enemyImage, (int) x, (int) y,  null);
	}

}
