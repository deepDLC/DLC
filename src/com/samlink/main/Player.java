package com.samlink.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}

	int width = Game.WIDTH;
	int height = Game.HEIGHT;
	
	public void tick() {
	
		
		x += velX;
		y += velY;
		
		x  = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 54);
		
		//Collosion
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Grunt){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2; 
				}
			}
		}	
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(x, y, 32, 32);

	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 32);
	}
}
