package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject {
	
	Random r = new Random();
	
	private int timer = 32;
	private int bulletTimer = 32;

	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		velX = 0;
		velY = 4;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		/**
		 * Count down for a bit, then stop vertical movement.
		 */
		if(timer <= 0) {
			velY = 0;
			bulletTimer--;
			
			/**
			 * After another pause, start moving horizontally.
			 */
			if(bulletTimer <= 0) {
				if(velX == 0) velX = 2;
				
				velX += 0.005 * Math.signum(velX);
				velX = Game.clamp(velX, -8, 8);
				
				/**
				 * Spawn a BulletEnemy roughly one out of every eight ticks.
				 */
				int spawn = r.nextInt(8);
				if(spawn == 0) new BulletEnemy((int) x + 48, (int) y + 48, ID.BasicEnemy, handler);
			}
		} else {
			timer--;
		}
		
		/**
		 * Reverse velocities when a collision with an edge occurs.
		 */
		if(x < 0 || x >= Game.WIDTH - 96) velX *= -1;
		
		/**
		 * Fire off Trail objects that will slowly fade out in their place as
		 * the BasicEnemy moves around the screen.
		 */
		new Trail((int) x, (int) y, ID.Trail, Color.red, 96, 96, 0.05f, handler);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 96, 96);
	}

}
