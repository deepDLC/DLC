package com.samlink.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Game {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//JFrame Setup
		JFrame myFrame = new JFrame();
		myFrame.setVisible(true);
		myFrame.setSize(640, 480);
		myFrame.setResizable(false);
		myFrame.setTitle("DLC");
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//JPanel Setup
		gamePanel myPanel = new gamePanel();
		myPanel.setSize(640, 480);
		myPanel.setBackground(Color.WHITE);
		myFrame.setContentPane(myPanel);
		myPanel.requestFocus();
		
		//myPanel.addKeyListener(myPanel);
		//myPanel.addMouseMotionListener(myPanel);
		//myPanel.addMouseListener(myPanel);
		
		while (true) {

			myPanel.run();
			myPanel.repaint();

			Thread.sleep(17);


		}
	}

}
