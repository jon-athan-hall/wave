package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.main.Game.STATE;

/**
 * Extends MouseAdapter to interact with mouse input.
 * 
 * @author Jonathan
 */
public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		/**
		 * Store the mouse event coordinates in temporary variables.
		 */
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu) { 
			/**
			 * Play button clicked.
			 */
			if(mouseOver(mx, my, 50, 100, 200, 50)) {
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Select;
				return;
			}
			
			/**
			 * Help button clicked.
			 */
			if(mouseOver(mx, my, 50, 175, 200, 50)) {
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Help;
			}
			
			/**
			 * Quit button clicked.
			 */
			if(mouseOver(mx, my, 50, 250, 200, 50)) {
				System.exit(1);
			}
		}
		
		if(Game.gameState == STATE.Select) { 
			/**
			 * Normal button clicked.
			 */
			if(mouseOver(mx, my, 50, 100, 200, 50)) {
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Game;
				new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler);
				handler.clearEnemies();
				new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler);
				game.difficulty = 0;
			}
			
			/**
			 * Hard button clicked.
			 */
			if(mouseOver(mx, my, 50, 175, 200, 50)) {
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Game;
				new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler);
				handler.clearEnemies();
				new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler);
				game.difficulty = 1;
			}
			
			/**
			 * Back button clicked.
			 */
			if(mouseOver(mx, my, 50, 250, 200, 50)) {
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Menu;
				return;
			}
		}
		
		if(Game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 50, 250, 200, 50)) {
				/**
				 * Back button clicked.
				 */
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Menu;
				return;
			}
		}
		
		if(Game.gameState == STATE.End) {
			if(mouseOver(mx, my, 50, 250, 200, 50)) {
				/**
				 * Try Again button clicked. Reset the level and score. Make a new
				 * Player object and clear all enemies except the basic starter enemy.
				 */
				AudioPlayer.getSound("select").play();
				Game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler);
				handler.clearEnemies();
				new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	/**
	 * Checks if coordinates fall within certain box dimensions.
	 *
	 * @param 	mx		the x-coordinate of the location to check
	 * @param 	my		the y-coordinate of the location to check
	 * @param 	x		the x-coordinate of the box
	 * @param 	y		the y-coordinate of the box
	 * @param 	width	the width of the box
	 * @param 	height	the height of the box
	 * @return			whether or not the coordinates are within the box
	 */
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
			Font menuFont = new Font("arial", 1, 50);
			Font buttonFont = new Font("arial", 1, 30);
			
			g.setFont(menuFont);
			g.setColor(Color.white);
			g.drawString("Wave", 50, 75);
			
			g.setFont(buttonFont);
			g.drawRect(50, 100, 200, 50);
			g.drawString("Play", 120, 135);
			
			g.drawRect(50, 175, 200, 50);
			g.drawString("Help", 120, 210);
			
			g.drawRect(50, 250, 200, 50);
			g.drawString("Quit", 120, 285);
		} else if (Game.gameState == STATE.Help) {
			Font menuFont = new Font("arial", 1, 50);
			Font helpFont = new Font("arial", 1, 15);
			Font buttonFont = new Font("arial", 1, 30);
			
			g.setFont(menuFont);
			g.setColor(Color.white);
			g.drawString("Help", 50, 75);
			
			g.setFont(helpFont);
			g.drawString("Use WASD keys to move player and dodge enemies.", 50, 100);
			
			g.setFont(buttonFont);
			g.drawRect(50, 250, 200, 50);
			g.drawString("Back", 120, 285);
		} else if (Game.gameState == STATE.End) {
			Font menuFont = new Font("arial", 1, 50);
			Font helpFont = new Font("arial", 1, 15);
			Font buttonFont = new Font("arial", 1, 30);
			
			g.setFont(menuFont);
			g.setColor(Color.white);
			g.drawString("Game Over", 50, 75);
			
			g.setFont(helpFont);
			g.drawString("You lost with a score of " + hud.getScore() + " points.", 50, 100);
			
			g.setFont(buttonFont);
			g.drawRect(50, 250, 200, 50);
			g.drawString("Play Again", 75, 285);
		} else if(Game.gameState == STATE.Select) {
			Font menuFont = new Font("arial", 1, 50);
			Font buttonFont = new Font("arial", 1, 30);
			
			g.setFont(menuFont);
			g.setColor(Color.white);
			g.drawString("Select Difficulty", 50, 75);
			
			g.setFont(buttonFont);
			g.drawRect(50, 100, 200, 50);
			g.drawString("Normal", 105, 135);
			
			g.drawRect(50, 175, 200, 50);
			g.drawString("Hard", 120, 210);
			
			g.drawRect(50, 250, 200, 50);
			g.drawString("Back", 120, 285);
		}
	}

}
