package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Extends MouseAdapter to interact with mouse input.
 * @author Jonathan
 *
 */
public class Menu extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font menuFont = new Font("arial", 1, 50);
		Font buttonFont = new Font("arial", 1, 30);
		
		g.setFont(menuFont);
		g.setColor(Color.white);
		g.drawString("Menu", 50, 75);
		
		g.setFont(buttonFont);
		g.drawRect(50, 100, 200, 50);
		g.drawString("Play", 120, 135);
		
		g.drawRect(50, 175, 200, 50);
		g.drawString("Help", 120, 210);
		
		g.drawRect(50, 250, 200, 50);
		g.drawString("Quit", 120, 285);
	}

}
