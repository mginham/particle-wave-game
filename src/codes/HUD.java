/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	HUD.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	private float greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 100);
		
		greenValue = HEALTH*2;
		
		score++;
	} // end tick
	
	public void render(Graphics g) {
		g.setColor(Color.gray); // Health bar background
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int) greenValue, 0)); // Health bar
		g.fillRect(15, 15, (int) HEALTH * 2, 32);
		g.setColor(Color.white); // Health bar border
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
	} // end render
	
	public void setScore(int score) {
		this.score = score;
	} // end setScore
	
	public int getScore() {
		return score;
	} // end getScore
	
	public int getLevel() {
		return level;
	} // end getLevel
	
	public void setLevel(int level) {
		this.level = level;
	} // end setLevel

}
