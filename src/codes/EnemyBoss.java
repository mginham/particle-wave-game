/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	EnemyBoss.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private int timer = 59;
	private int timer2 = 50;
	
	private Handler handler;
	Random r = new Random();

	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	} // end EnemyBoss
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	} // end Rectangle

	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0) // move boss down from off-screen
			velY = 0;
		else
			timer--;
		
		if(timer <= 0)
			timer2--;
		if(timer2 <= 0)
		{
			if(velX == 0) // move boss side to side in window
				velX = 2;
			
			if(velX > 0) // increase velocity over time
				velX += 0.005f;
			if(velX < 0)
				velX -= 0.005f;
			
			velX = Game.clamp(velX, -10, 10); // cap max and min velocities
			
			int spawn = r.nextInt(10);
			if(spawn == 0)
				handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.EnemyBossBullet, handler)); // spawn bullets to attack the player
		}
		
		if(x <= 0 || x >= Game.WIDTH - 96)  // ensure enemy stays within the window
			velX *= -1;
	} // end tick

	public void render(Graphics g) {
		g.setColor(Color.red); // enemy color
		g.fillRect((int)x, (int) y, 96, 96);
		
	} // end render
}