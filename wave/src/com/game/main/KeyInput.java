package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	/**
	 * An instance of the Game's Handler is needed for key events.
	 */
	private Handler handler;
	
	/**
	 * Control mechanisms for fixing the system delay when changing
	 * opposite directions.
	 */
	private boolean upPress = false;
	private boolean leftPress = false;
	private boolean downPress = false;
	private boolean rightPress = false;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
		/**
		 * Loop through all GameObjects and assign key events accordingly.
		 */
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject o = handler.object.get(i);
			
			if(o.getID() == ID.Player) {
				if(key == KeyEvent.VK_W) {
					upPress = true;
					o.setVelY(-4);
				}
				if(key == KeyEvent.VK_A) {
					leftPress = true;
					o.setVelX(-4);
				}
				if(key == KeyEvent.VK_S) {
					downPress = true;
					o.setVelY(4);
				}
				if(key == KeyEvent.VK_D) {
					rightPress = true;
					o.setVelX(4);
				}
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
				if(key == KeyEvent.VK_W) {
					upPress = false;
					if(downPress) {
						o.setVelY(4);
					} else {
						o.setVelY(0);
					}
				}
				if(key == KeyEvent.VK_A) {
					leftPress = false;
					if(rightPress) {
						o.setVelX(4);
					} else {
						o.setVelX(0);
					}
				}
				if(key == KeyEvent.VK_S) {
					downPress = false;
					if(upPress) {
						o.setVelY(-4);
					} else {
						o.setVelY(0);
					}
				}
				if(key == KeyEvent.VK_D) {
					rightPress = false;
					if(leftPress) {
						o.setVelX(-4);
					} else {
						o.setVelX(0);
					}
				}
			}
		}
	}
	
}
