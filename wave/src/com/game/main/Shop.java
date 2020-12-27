package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
	
	Handler handler;
	HUD hud;
	
	private int box1 = 1000;
	private int box2 = 1000;
	private int box3 = 1000;
	
	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0, 48));
		g.drawString("SHOP", Game.WIDTH / 2 - 100, 50);
		
		/**
		 * Shop item #1
		 */
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Health:", 110, 120);
		g.drawString("Cost: " + box1, 110, 140);
		g.drawRect(100, 100, 100, 80);
		
		/**
		 * Shop item #2
		 */
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Speed:", 260, 120);
		g.drawString("Cost: " + box2, 260, 140);
		g.drawRect(250, 100, 100, 80);
		
		/**
		 * Shop item #3
		 */
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Refill Health:", 410, 120);
		g.drawString("Cost: " + box3, 410, 140);
		g.drawRect(400, 100, 100, 80);
		
		g.drawString("Score: " + hud.getScore(), Game.WIDTH / 2 - 50, 300);
		g.drawString("Press spacebar to go back" , Game.WIDTH / 2 - 50, 330);
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		/**
		 * For selecting shop item #1
		 */
		if(mx >= 100 && mx <= 200) {
			if(my >= 100 && my <= 180) {
				System.out.println("box 1");
			}
		}
		
		/**
		 * For selecting shop item #2
		 */
		if(mx >= 250 && mx <= 350) {
			if(my >= 100 && my <= 180) {
				System.out.println("box 2");
			}
		}
		
		/**
		 * For selecting shop item #3
		 */
		if(mx >= 400 && mx <= 500) {
			if(my >= 100 && my <= 180) {
				System.out.println("box 3");
			}
		}
	}

}
