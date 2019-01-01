/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	MenuParticle.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {
	
	private Handler handler;
	
	Random r = new Random();
	
	private Color col;

	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(7 - -7) + -7); // generate random velocities
		velY = (r.nextInt(7 - -7) + -7);
		
		if(velX == 0)
			velX = 1;
		if(velY == 0)
			velY = 1;
		
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)); // generate a random color
	} // end MenuParticle
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	} // end Rectangle

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 46) // ensure object stays within the window
			velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16)
			velX *= -1;
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, col, 16, 16, 0.041f, handler)); // add a trail
	} // end tick

	public void render(Graphics g) {
		g.setColor(col); // particle color
		g.fillRect((int) x, (int) y, 16, 16);
	} // end render
}