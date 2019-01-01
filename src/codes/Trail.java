/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	Trail.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {

	private float alpha = 1;
	private float life;
	
	private Handler handler;
	private Color color;
	
	private int width, height;
	
	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	} // end Trail

	public void tick() {
		if(alpha > life) // how long the trail exists for
		{
			alpha -= (life - 0.0001f);
		}
		else handler.removeObject(this);
	} // end tick

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
		
		g2d.setComposite(makeTransparent(1));
	} // end render
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	} // end AlphaComposite

	public Rectangle getBounds() {
		
		return null;
	} // end Rectangle
}
