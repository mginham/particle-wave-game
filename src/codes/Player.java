/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	Player.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	} // end Player
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	} // end Rectangle
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 72);
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.white, 32, 32, 0.081f, handler)); // add a trail
		
		collision();
	} // end tick
	
	private void collision() { // if Player intersects with an enemy, decrease HEALTH
		for(int x = 0; x < handler.object.size(); x++)
		{
			GameObject tempObject = handler.object.get(x); // tempObject is now enemy
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.EnemyBossBullet)
				if(getBounds().intersects(tempObject.getBounds()))
					HUD.HEALTH -= 2; // collision code
			
			if(tempObject.getId() == ID.EnemyBoss)
				if(getBounds().intersects(tempObject.getBounds())) // immediate KO if player touches boss
					HUD.HEALTH -= 1000;
		}
	} // end collision

	public void render(Graphics g) {
		g.setColor(Color.white); // player color
		g.fillRect((int) x, (int) y, 32, 32);
	} // end render
}
