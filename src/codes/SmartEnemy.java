/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	SmartEnemy.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) // search object Ids for the Player
		{
			if(handler.object.get(i).getId() == ID.Player)
				player = handler.object.get(i);
		}
	} // end SmartEnemy
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	} // end Rectangle

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y-player.getY())); // check distance from player
		
		velX = (float) ((-1.0/distance) * (diffX)); // move towards the player
		velY = (float) ((-1.0/distance) * (diffY));
		
		if(y <= 0 || y >= Game.HEIGHT - 46) // ensure enemy stays within the window
			velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16)
			velX *= -1;
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.green, 16, 16, 0.041f, handler)); // add a trail
	} // end tick

	public void render(Graphics g) {
		g.setColor(Color.green); // enemy color
		g.fillRect((int) x, (int) y, 16, 16);
	} // end render
}