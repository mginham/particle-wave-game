/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	Window.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	private static final long serialVersionUID = 1L; // auto-generated by java
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title); // create a window with a title in the border
		
		// determine window size
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ensure that the app terminates when the window closes
		frame.setResizable(false); // window cannot be resized while app is running
		frame.setLocationRelativeTo(null); // start window center of screen instead of top left
		frame.add(game);
		frame.setVisible(true); // make frame visible
		game.start();
	} // end Window
}