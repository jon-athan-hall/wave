package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Main class where everything is controlled and drawn.
 * @author Jonathan
 *
 */
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -473349850293143017L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH * 9 / 16;
	
	private Handler handler;
	private Random r;
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Wave", this);
		
		r = new Random();
		
		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy));
	}

	/**
	 * It should be impossible for two invocations of the start method
	 * to interleave. Make sure this cannot happen by using the synchronized
	 * keyword. This prevents thread interference and problems with memory
	 * consistency.
	 */
	public synchronized void start() {
		/**
		 * Normally there would be more than one thread running.
		 */
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			/**
			 * Wait for thread to die before continuing.
			 */
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		/**
		 * Classic game loop code used everywhere. Set the amountOfTicks to
		 * whatever the desired ticks per second is desired. This ensures
		 * a slow, steady pause in the game loop.
		 */
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final double OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastLoopTime) / OPTIMAL_TIME;
			lastLoopTime = now;
			
			/**
			 * Once the difference in time has grown to be over 1 "gametick",
			 * then execute a tick call. The delta is calculated down to
			 * the nanosecond for accuracy.
			 */
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			/**
			 * Regardless of a tick or not, render the next frame.
			 */
			if(running) {
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	/**
	 * Private methods are available to the current class only.
	 */
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		/**
		 * BufferStrategy is a mechanism to organize memory for
		 * a Canvas or Window. This Game class extends Canvas. Look
		 * into GraphicsConfiguration for what a system's hardware
		 *  can handle. Buffer and surface are used interchangeably to
		 *  mean an area of memory where graphics are drawn. Three buffers
		 *  allows for two background buffers and one live display surface.
		 */
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,  0,  WIDTH,  HEIGHT);
		
		handler.render(g);
		
		/**
		 * Graphics object can no longer be used after dispose is called
		 * since the point is to release any system resources no longer
		 * needed to draw.
		 */
		g.dispose();
		
		/**
		 * Move the next available background buffer to it becomes the
		 * active live display.
		 */
		bs.show();
	}
	
	/**
	 * A method like this would normally live in an imported library. It's
	 * available to constrain all object's location to be within the
	 * game window.
	 */
	public static int clamp(int currentValue, int min, int max) {
		return Math.max(min, Math.min(max, currentValue));
	}
	
	public static void main(String arg[]) {
		new Game();
	}
	
}
