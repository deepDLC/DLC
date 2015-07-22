package com.samlink.main;

public class Spawn {
	
	private Handler handler;
	
	private HUD hud;
	
	private int enemies = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Grunt){
				enemies++;
			}
		}	
		
		hud.setNumEnemies(enemies);
		System.out.println(enemies);
	}

}
