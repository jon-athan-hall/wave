package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	/**
	 * An instance of the Game's Handler is needed for key events.
	 */
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		/**
		 * Loop through all GameObjects and assign key events accordingly.
		 */
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject o = handler.object.get(i);
			
			if(o.getID() == ID.Player) {
				if(key == KeyEvent.VK_W) o.setVelY(-4);
				if(key == KeyEvent.VK_A) o.setVelX(-4);
				if(key == KeyEvent.VK_S) o.setVelY(4);
				if(key == KeyEvent.VK_D) o.setVelX(4);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		/**
		 * Loop through all GameObjects and assign key events accordingly.
		 */
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject o = handler.object.get(i);
			
			if(o.getID() == ID.Player) {
				if(key == KeyEvent.VK_W) o.setVelY(0);
				if(key == KeyEvent.VK_A) o.setVelX(0);
				if(key == KeyEvent.VK_S) o.setVelY(0);
				if(key == KeyEvent.VK_D) o.setVelX(0);
			}
		}
	}
	
}
