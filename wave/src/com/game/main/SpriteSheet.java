package com.game.main;

import java.awt.image.BufferedImage;

/**
 * Uses a sprite sheet to retrieve particular sprites with
 * dimensions and coordinates.
 * 
 * @author Jonathan
 */
public class SpriteSheet {
	
	private BufferedImage sprite;
	
	public SpriteSheet(BufferedImage ss) {
		this.sprite = ss;
	}
	
	/**
	 * Grabs a sprite from the sprite sheet without requiring
	 * the exact pixel coordinates. Instead uses column and row
	 * values assuming each row and column is 32 pixels.
	 * 
	 * @param col		the column value
	 * @param row		the row value
	 * @param width		the width of the sprite
	 * @param height	the height of the sprite
	 * @return			the particular image in the sprite sheet
	 */
	public BufferedImage grabImage(int col, int row, int width, int height) {
		 BufferedImage img = sprite.getSubimage((col * 32) - 32, (row * 32) - 32, width, height);
		 return img;
	}

}
