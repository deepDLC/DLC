package com.samlink.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class gamePanel extends JPanel implements KeyListener{

	//character variables
	int mainCharX = Constants.WIDTH/2;
	int mainCharY = Constants.HEIGHT/2;
	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false;
	boolean movingRight = false;
	
	BufferedImage itemBar;
	
	//Enemy
	int[] enemyX = new int [Constants.ENEMIES];
		
	gamePanel() throws IOException{

		URL url = getClass().getResource("itembar.png");
		itemBar = ImageIO.read(url);

	}
	
	public void paintComponent (Graphics g){
		g.drawRect(mainCharX, mainCharY, 20, 20);
		g.fillRect(mainCharX, mainCharY, 20, 20);
		g.drawImage(itemBar, 0, 0, this);
	}
	
	public void run(){
		
		if(movingUp && mainCharY >= 2){
			mainCharY -= 5;
		}
		if(movingDown && mainCharY <= Constants.HEIGHT - 45){
			mainCharY += 5;
		}
		if(movingRight && mainCharX <= Constants.WIDTH - 25){
			mainCharX += 5;
		}
		if(movingLeft && mainCharX >= 5){
			mainCharX -= 5;
		}
		
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyChar()){
		case 'w':
			movingUp = true;
			break;
		case 'a':
			movingLeft= true;
			break;
		case 's':
			movingDown = true;
			break;
		case 'd':
			movingRight = true;
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyChar()){
		case 'w':
			movingUp = false;
			break;
		case 'a':
			movingLeft= false;
			break;
		case 's':
			movingDown = false;
			break;
		case 'd':
			movingRight = false;
			break;
		}
	}
	
}
