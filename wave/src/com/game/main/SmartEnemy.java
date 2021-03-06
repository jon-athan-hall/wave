package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject {
	
	private BufferedImage enemyImage;
	
	/**
	 * Used to give SmartEnemy something to chase.
	 */
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		SpriteSheet ss = new SpriteSheet(Game.spriteSheet);
		
		enemyImage = ss.grabImage(4, 1, 16, 16);
		
		for(int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getID() == ID.Player) player = handler.objects.get(i); 
		}
		
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
		 * Classic distance formula between player's position and SmartEnemy's position.
		 */
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));
		
		velX = (float) ((-1.0 / distance) * diffX);
		velY = (float) ((-1.0 / distance) * diffY);
		
		/**
		 * Reverse velocities when a collision with an edge occurs.
		 */
		if(y < 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if(x < 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		/**
		 * Fire off Trail objects that will slowly fade out in their place as
		 * the BasicEnemy moves around the screen. Removed for now.
		 */
		//new Trail((int) x, (int) y, ID.Trail, Color.green, 16, 16, 0.01f, handler);
		
	}

	public void render(Graphics g) {
		g.drawImage(enemyImage, (int) x, (int) y,  null);
	}

}
