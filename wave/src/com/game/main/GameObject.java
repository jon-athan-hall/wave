package com.game.main;

import java.awt.Graphics;

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
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
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