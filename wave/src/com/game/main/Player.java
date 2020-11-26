package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 32);
		
		checkCollisions();
	}
	
	private void checkCollisions() {
		for(int i = 0; i < handler.objects.size(); i++) {
			GameObject o = handler.objects.get(i);
			
			/**
			 * Check for intersections between this Player object
			 * and all BasicEnemy objects on screen.
			 */
			if(o.getID() == ID.BasicEnemy || o.getID() == ID.FastEnemy || o.getID() == ID.SmartEnemy) {
				if(getBounds().intersects(o.getBounds())) {
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y,  32, 32);
	}
	
}
