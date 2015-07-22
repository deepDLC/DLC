package com.samlink.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;


public class gamePanel extends JPanel implements KeyListener{

	//character variables
	int mainCharX = Constants.WIDTH/2;
	int mainCharY = Constants.HEIGHT/2;
	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false;
	boolean movingRight = false;
	
	boolean isSpawning = true;

	Random r;
	
	int gameState = 0;

	// Enemy
	int[] enemyX = new int[Constants.ENEMIES];
	int[] enemyY = new int[Constants.ENEMIES];

	// Hello

	gamePanel() {

	}

	public void paintComponent(Graphics g) {
		switch (gameState) {
		case 0:
			g.drawRect(mainCharX, mainCharY, 20, 20);
			g.fillRect(mainCharX, mainCharY, 20, 20);
			if(movingUp && mainCharY >= 2){
				mainCharY -= 5;
			}
			break;
		}
	}

	public void run() {

		switch (gameState) {
		case 0:
			
			if(isSpawning){
				for(int i = 0; i < Constants.ENEMIES; i++){
					enemyX[i] = (int)(Math.random() * Constants.HEIGHT);
					enemyY[i] = r.nextInt(Constants.HEIGHT - 32);
				}
				isSpawning = false;
			}
			
			if (movingUp) {
				mainCharY += 5;
			}
			if (movingDown) {
				mainCharY += 5;
			}
			if (movingRight) {
				mainCharX += 5;
			}
			if (movingLeft) {
				mainCharX -= 5;
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
			break;
		case 1:
			break;
		}
		
		
	//hi
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyChar()) {
		case 'w':
			movingUp = true;
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
		switch (e.getKeyChar()) {
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
