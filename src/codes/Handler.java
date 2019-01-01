/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	Handler.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>(); // create a list of game objects
	
	public void tick() { // updates all gameObjects
		for(int x = 0; x < object.size(); x++)
		{
			GameObject tempObject = object.get(x);
			
			tempObject.tick();
		}
	} // end tick
	
	public synchronized void render(Graphics g) { // renders all gameObjects
		for(int x = 0; x < object.size(); x++)
		{
			GameObject tempObject = object.get(x);
			
			tempObject.render(g);
		}
	} // end render
	
	public synchronized void clearEnemies() { // remove all objects from the window
		for(int x = 0; x < object.size(); x++)
		{
			GameObject tempObject = object.get(x);
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();
				if(Game.gameState != Game.STATE.End) // add the player back where it was
					addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
			}
		}
	} // end clearEnemys
	
	public void addObject(GameObject object) { // add object to window
		this.object.add(object);
	} // end addObject
	
	public void removeObject(GameObject object) { // remove object from window
		this.object.remove(object);
	} // removeObject
}
