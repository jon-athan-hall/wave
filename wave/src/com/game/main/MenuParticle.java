package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {
	
	Random r = new Random();
	
	private Color randomColor;

	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		/**
		 * Random colors and velocities for menu design.
		 */
		velX = (r.nextInt(5 - -5) + -5);
		if(velX == 0) velX = 1;
		
		velY = (r.nextInt(5 - -5) + -5);
		if(velY == 0) velY = 1;
		
		randomColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
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
		 * the BasicEnemy moves around the screen.
		 */
		new Trail((int) x, (int) y, ID.Trail, randomColor, 16, 16, 0.01f, handler);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int) x, (int) y, 16, 16);
	}

}
