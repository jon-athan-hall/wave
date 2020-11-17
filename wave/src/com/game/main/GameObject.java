package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * GameObject is a superclass for all objects that exists and interact
 * within the game. This abstract class cannot be instantiated and must
 * be extended by specific subclasses where its methods are implemented.
 * 
 * @author Jonathan
 */
public abstract class GameObject {
	
	/**
	 * Protected methods and variables are accessible from within this
	 * class as well as subclasses that extend this class.
	 */
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected Handler handler;
	
	public GameObject(int x, int y, ID id, Handler handler) {
		this.x = x;
		this.y = y;
		this.id = id;
		
		/**
		 * Store the Handler instance and automatically add this
		 * object instance to the handler.
		 */
		this.handler = handler;
		handler.addObject(this);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	/**
	 * The Rectangle class in the JRE has a method called intersects
	 * which will help with collision detection.
	 */
	public abstract Rectangle getBounds();
	
	/**
	 * Long list of basic getters and setters for GameObject. They are
	 * all the same no matter the subclass, therefore they can be defined
	 * here in the superclass.
	 */
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public ID getID() {
		return id;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}
