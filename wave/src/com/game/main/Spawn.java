package com.game.main;

import java.util.Random;

public class Spawn {
	
	/**
	 * These could be static variables elsewhere and then there would be
	 * no need to create them here to be assigned via the constructor.
	 */
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	/**
	 * Tracks the same number as score does in HUD, except this
	 * will reset at 1000. TODO This can be refactored using modulus
	 * and seems unnecessary.
	 */
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 1000) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2) {
				new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler);
			} else if(hud.getLevel() == 3) {
				new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler);				
			} else if(hud.getLevel() == 4) {
				new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler);
			}
		}
	}
	
}
