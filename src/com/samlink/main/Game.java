package com.samlink.main;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Game {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//JFrame Setup
		JFrame myFrame = new JFrame();
		myFrame.setVisible(true);
		myFrame.setSize(Constants.WIDTH, Constants.HEIGHT);
		myFrame.setResizable(false);
		myFrame.setTitle("DLC");
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//JPanel Setup
		gamePanel myPanel = new gamePanel();
		myPanel.setSize(Constants.WIDTH, Constants.HEIGHT);
		myPanel.setBackground(Color.WHITE);
		myFrame.setContentPane(myPanel);
		myPanel.requestFocus();
		
		myPanel.addKeyListener(myPanel);
		//myPanel.addMouseMotionListener(myPanel);
		//myPanel.addMouseListener(myPanel);
		
		while (true) {

			myPanel.run();
			myPanel.repaint();

			Thread.sleep(17);


		}
	}

}
