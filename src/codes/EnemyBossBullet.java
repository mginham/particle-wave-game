/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	EnemyBossBullet.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5); // how fast it goes
		velY = 5;
	} // end EnemyBossBullet
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	} // end Rectangle

	public void tick() {
		x += velX;
		y += velY;
		
		if(y >= Game.HEIGHT)
			handler.removeObject(this); // remove the bullet when it leaves the screen
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, 16, 16, 0.041f, handler)); // add a trail
	} // end tick

	public void render(Graphics g) {
		g.setColor(Color.red); // enemy color
		g.fillRect((int)x, (int) y, 16, 16);
	} // end render
}
