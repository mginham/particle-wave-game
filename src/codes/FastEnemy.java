/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	FastEnemy.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {
	
	private Handler handler;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2; // how fast it moves
		velY = 9;
	} // end FastEnemy
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	} // end Rectangle

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 46) // ensure enemy stays within the window
			velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16)
			velX *= -1;
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.cyan, 16, 16, 0.041f, handler)); // add a trail
	} // end tick

	public void render(Graphics g) {
		g.setColor(Color.cyan); // enemy color
		g.fillRect((int) x, (int) y, 16, 16);
	} // end render
}