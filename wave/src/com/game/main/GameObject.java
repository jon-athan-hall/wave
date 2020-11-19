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
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	protected Handler handler;
	
	public GameObject(float x, float y, ID id, Handler handler) {
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
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public ID getID() {
		return id;
	}
	
	public float getVelX() {
		return velX;
	}
	
	public float getVelY() {
		return velY;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
}
