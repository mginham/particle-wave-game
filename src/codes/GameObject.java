/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	GameObject.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y; // protected can only be accessed by the what inherits the game object
	protected ID id;
	protected float velX,velY;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	} // end GameObject
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	// getters and setters
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public float getX() 
	{
		return x;
	}
	public float getY() 
	{
		return y;
	}
	public void setID(ID id) 
	{
		this.id = id;
	}
	public ID getId() 
	{
		return id;
	}
	public void setVelX(int velX) 
	{
		this.velX = velX;
	}
	public void setVelY(int velY) 
	{
		this.velY = velY;
	}
	public float getVelX() 
	{
		return velX;
	}
	public float getVelY() 
	{
		return velY;
	}
}
