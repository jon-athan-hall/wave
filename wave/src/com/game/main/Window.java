package com.game.main;

/**
 * Hit Ctrl + Shift + O to automagically add all imports that
 * the file needs.
 */
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Only one purpose here and that's to create the game window.
 * 
 * @author Jonathan
 */
public class Window extends Canvas {

	/**
	 * This value is used during deserialization to verify that both
	 * the sender and receiver of a shared class are working with the
	 * identical class.
	 */
	private static final long serialVersionUID = -1478604005915452565L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		
		/**
		 * Make sure the corner X button actually stops the game.
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

}
