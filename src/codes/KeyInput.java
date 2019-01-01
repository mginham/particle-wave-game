/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	KeyInput.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false; // up
		keyDown[1] = false; // down
		keyDown[2] = false; // right
		keyDown[3] = false; // left
	} // end KeyInput

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int x = 0; x < handler.object.size(); x++)
		{
			GameObject tempObject = handler.object.get(x);
			
			if(tempObject.getId() == ID.Player) {
				// key events for player (using arrow keys)
				if(key == KeyEvent.VK_UP)
				{
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_DOWN)
				{
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_RIGHT)
				{
					tempObject.setVelX(5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_LEFT)
				{
					tempObject.setVelX(-5);
					keyDown[3] = true;
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) // quit the game using escape key
			System.exit(1);
	} // end keyPressed
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();	
		
		for(int x = 0; x < handler.object.size(); x++)
		{
			GameObject tempObject = handler.object.get(x);
			
			if(tempObject.getId() == ID.Player) {
				// key events for player (using arrow keys)
				if(key == KeyEvent.VK_UP)
					keyDown[0] = false;
				if(key == KeyEvent.VK_DOWN)
					keyDown[1] = false;
				if(key == KeyEvent.VK_RIGHT)
					keyDown[2] = false;
				if(key == KeyEvent.VK_LEFT)
					keyDown[3] = false;
				
				// vertical movement
				if(!keyDown[0] && !keyDown[1])
					tempObject.setVelY(0);
				// horizontal movement
				if(!keyDown[2] && !keyDown[3])
					tempObject.setVelX(0);
			}
		}
	} // end keyReleased
}
