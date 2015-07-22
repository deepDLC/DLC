package com.samlink.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Grunt extends GameObject {

	Player player;
	
	public Grunt(int x, int y, ID id) {
		super(x, y, id);
		velY = 5;
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y > Game.HEIGHT - 16){
			velY = -velY;
		}
		

	}
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 16, 16);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);

	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	

}
