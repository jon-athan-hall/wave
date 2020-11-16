package com.game.main;

import java.awt.Canvas;

/**
 * Main class where everything is controlled and drawn.
 * @author Jonathan
 *
 */
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -473349850293143017L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH * 9 / 16;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Wave", this);
	}

	/**
	 * It should be impossible for two invocations of the start method
	 * to interleave. Make sure this cannot happen by using the synchronized
	 * keyword. This prevents thread interference and problems with memory
	 * consistency.
	 */
	public synchronized void start() {
		
	}
	
	public void run() {
		
	}
	
	public static void main(String arg[]) {
		new Game();
	}
	
}
