package com.samlink.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class gamePanel extends JPanel implements KeyListener{

	//character variables
	int mainCharX = 200;
	int mainCharY = 200;
	boolean movingUp = false;
	
	gamePanel(){
		
	}
	
	public void paintComponent (Graphics g){
		g.drawRect(mainCharX, mainCharY, 20, 20);
		g.fillRect(mainCharX, mainCharY, 20, 20);
	}
	
	public void run(){
		
		if(movingUp){
			mainCharX += 5;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyChar()){
		case 'w':
				movingUp = true;
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
		}
	}
	
}
