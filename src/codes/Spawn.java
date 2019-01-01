/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	Spawn.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	} // end Spawn
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 250) // level increases each time score increases by 250
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2) // add a basic enemy in level 2
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel() == 3) // add a basic enemy in level 3
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel() == 4) // add a fast enemy in level 4
			{
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			else if(hud.getLevel() == 5) // add a smart enemy in level 5
			{
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
			}
			else if(hud.getLevel() == 6) // add a fast enemy in level 6
			{
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			else if(hud.getLevel() == 7) // add a basic enemy in level 7
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel() == 8) // add a fast enemy in level 8
			{
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			// don't add anything for level 9
			else if(hud.getLevel() == 10) // remove all previous enemies and add the boss
			{
				handler.clearEnemies();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 60, -120, ID.EnemyBoss, handler));
			}
		}
	} // end Tick
}
