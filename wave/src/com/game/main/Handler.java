package com.game.main;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This maintains, processes and renders all of the objects involved
 * in the Game. It loops through them all taking care of each one by one.
 */
public class Handler {

	/**
	 * The LinkedList data structure of items with links to both
	 * the previous and next items. Preferred to ArrayList because
	 * of all the item manipulation to be done.
	 */
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.render(g);
		}
	}
	
	public void addObject(GameObject o) {
		this.objects.add(o);
	}
	
	public void removeObject(GameObject o) {
		this.objects.remove(o);
	}
	
	/**
	 * Iterates through all GameObjects and removes everything
	 * except for the Player object. Removes Player object too if
	 * the Game is over.
	 */
	public void clearEnemies() {
		Iterator<GameObject> i = this.objects.iterator();
		while(i.hasNext()) {
			GameObject o = i.next();
			if(o.getID() != ID.Player || Game.gameState == Game.STATE.End) i.remove();
		}
	}
	
}
