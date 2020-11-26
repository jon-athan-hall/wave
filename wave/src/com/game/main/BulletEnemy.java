package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BulletEnemy extends GameObject {
	
	Random r = new Random();

	public BulletEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		velX = r.nextInt(4 - -4) + -4;
		velY = 4;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 8, 8);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		/**
		 * Reverse velocities when a collision with an edge occurs.
		 */
		if(y >= Game.HEIGHT) handler.removeObject(this); 
		
		/**
		 * Fire off Trail objects that will slowly fade out in their place as
		 * the BasicEnemy moves around the screen.
		 */
		new Trail((int) x, (int) y, ID.Trail, Color.red, 8, 8, 0.01f, handler);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 8, 8);
	}

}
