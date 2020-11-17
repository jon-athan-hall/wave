package com.game.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	
	private float alpha = 1;
	
	private Handler handler;
	private Color color;

	private int width, height;
	private float life;
	
	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	public void tick() {
		/**
		 * Decrease the alpha tick by tick until it is lower than
		 * the supplied life value. Then kill off the Trail object
		 * by removing it from the handler.
		 */
		if(alpha > life) {
			alpha -= (life - 0.001f);
		} else {
			handler.removeObject(this);
		}
	}

	public void render(Graphics g) {
		/**
		 * Cast the Graphics to Graphics2D in order to use the
		 * methods needed for drawing Trails.
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		/**
		 * TODO Decide if this is even necessary.
		 */
		g2d.setComposite(makeTransparent(1));
	}
	
	/**
	 * Prepare an AlphaComposite for making a source object transparent, 
	 * using the Source Over Destination rule from the 12 Porter-Duff
	 * rules for alpha compositing.
	 * @param 	alpha the constant, between 0.0 and 1.0, to be multiplied
	 * 			by the alpha of the source image.
	 * @return	the prepared AlphaComposite instance to be used with
	 * 			the source.
	 */
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	/**
	 * No collision bound for Trail.
	 */
	public Rectangle getBounds() {
		return null;
	}

	
	
}
