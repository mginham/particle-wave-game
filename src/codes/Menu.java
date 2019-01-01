/*
 *  Project:		Final Project (Wave Game)
 *  Program name:	Menu.java
 *  Author:			Megan Ginham
 *  Date:			December 22, 2017
 *  School:			Western Canada High School
 */

package codes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import codes.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	} // end Menu
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu)
		{
			if(mouseOver(mx, my, 210, 150, 200, 64)) // play button in Menu
			{
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler)); // add Player
				handler.clearEnemies(); // remove enemies
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler)); // add Basic Enemy
			}
			
			if(mouseOver(mx, my, 210, 250, 200, 64)) // help button in Menu
			{
				game.gameState = STATE.Help;
			}
			
			if(mouseOver(mx, my, 210, 350, 200, 64)) // quit button in Menu
			{
				System.exit(1);
			}
		}
		
		if(game.gameState == STATE.Help) // back button in Help
		{
			if(mouseOver(mx, my, 210, 350, 200, 64))
			{
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		if(game.gameState == STATE.End) // try again button in End
		{
			if(mouseOver(mx, my, 210, 350, 200, 64))
			{
				game.gameState = STATE.Game; // return to Game screen with reset stats
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler)); // add the Player back
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler)); // add a BasicEnemy
			}
		}
	} // end mousePressed
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) { // check if the mouse is hovering over an object in the window
		if(mx> x && mx < x + width)
		{
			if(my > y && my < y + height)
				return true;
			else
				return false;
		}
		else
			return false;
	} // end mouseOver
	
	public void tick() {
		
	} // end tick
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu) // display text in Menu screen
		{
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", 240, 80);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 275, 193);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 275, 293);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 275, 393);
		}
		else if(game.gameState == STATE.Help) // display text in Help screen
		{
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 240, 80);
			
			g.setFont(fnt3);
			g.drawString("Use arrow keys to move player and dodge enemies", 80, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 275, 393);
		}
		else if(game.gameState == STATE.End)  // display text in End screen
		{
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 180, 90);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 245, 393);
		}
	} // end render
}
