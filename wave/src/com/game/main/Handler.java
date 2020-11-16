package com.game.main;

import java.awt.Graphics;
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
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject o = object.get(i);
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject o = object.get(i);
			o.render(g);
		}
	}
	
	public void addObject(GameObject o) {
		this.object.add(o);
	}
	
	public void removeObject(GameObject o) {
		this.object.remove(o);
	}
	
}
