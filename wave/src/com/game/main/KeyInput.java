package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import com.game.main.Game.STATE;

public class KeyInput extends KeyAdapter {
	
	/**
	 * An instance of the Game's Handler is needed for key events.
	 */
	private Handler handler;
	Game game;
	
	/**
	 * Control mechanisms for fixing the system delay when changing
	 * opposite directions. TODO Make this a hash instead.
	 */
	private boolean[] keyPress = new boolean[4];
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		Arrays.fill(keyPress, false);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		/**
		 * Loop through all GameObjects and assign key events accordingly.
		 */
		for(int i = 0; i < handler.objects.size(); i++) {
			GameObject o = handler.objects.get(i);
			
			if(o.getID() == ID.Player) {
				if(key == KeyEvent.VK_W) {
					keyPress[0] = true;
					o.setVelY(-handler.speed);
				}
				if(key == KeyEvent.VK_A) {
					keyPress[1] = true;
					o.setVelX(-handler.speed);
				}
				if(key == KeyEvent.VK_S) {
					keyPress[2] = true;
					o.setVelY(handler.speed);
				}
				if(key == KeyEvent.VK_D) {
					keyPress[3] = true;
					o.setVelX(handler.speed);
				}
			}
		}
		
		/**
		 * Toggle the pause state with the P key, but only while playing.
		 */
		if(key == KeyEvent.VK_P) {
			if(Game.gameState == STATE.Game) {
				Game.paused = !Game.paused;
			}
		}
		
		/**
		 * Toggle the shop menu if in the game only.
		 */
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game) {
				Game.gameState = STATE.Shop;
			} else if (Game.gameState == STATE.Shop) {
				Game.gameState = STATE.Game;
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		/**
		 * Loop through all GameObjects and assign key events accordingly.
		 */
		for(int i = 0; i < handler.objects.size(); i++) {
			GameObject o = handler.objects.get(i);
			
			if(o.getID() == ID.Player) {
				if(key == KeyEvent.VK_W) keyPress[0] = false;
				if(key == KeyEvent.VK_A) keyPress[1] = false;
				if(key == KeyEvent.VK_S) keyPress[2] = false;
				if(key == KeyEvent.VK_D) keyPress[3] = false;
				
				/**
				 * Shut down vertical and horizontal movement if the appropriate
				 * pair of keys are both released.
				 */
				if(!keyPress[0] && !keyPress[2]) o.setVelY(0);
				if(!keyPress[1] && !keyPress[3]) o.setVelX(0);
			}
		}
	}
	
}
