package com.samlink.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	private int greenValue = 255;
	
	private int redValue = 0;
	
	private int enemies = 0;
	private int level = 1;
	

	public void tick(){
		
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		greenValue = HEALTH *2;
		
		redValue =  200 - HEALTH*2;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(redValue, greenValue, 0));
		g.fillRect(15, 15, HEALTH*2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32);
		
		g.setColor(Color.BLACK);
		g.drawString("Enemies " + enemies, 15, 64);
		g.drawString("Level " + level, 15, 80);
		
	}
	
	public void setNumEnemies(int enemies){
		this.enemies = enemies;
	}
	
	public int getNumEnemies(){
		return enemies;
	}
}
