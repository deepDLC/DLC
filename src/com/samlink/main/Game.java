/**
 * 
 */
package com.samlink.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * @author Charles
 *
 */
public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4873037461062440863L;

	// Window Size
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	// Threads
	private Thread thread;
	private boolean running;
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawn spawner;

	public Game() {

		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		r = new Random();

		new Window(WIDTH, HEIGHT, "SamLink", this);

		hud = new HUD();
		spawner = new Spawn(handler, hud);
		handler.addObject(new Player(WIDTH / 2, HEIGHT / 2 - 32, ID.Player,
				handler));
		
		handler.addObject(new Grunt(r.nextInt(WIDTH - 32), r.nextInt(HEIGHT - 54),
				ID.Grunt));

	}

	// Game Start
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	// Game Stop
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Game Run/Game Loop
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 128;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				 System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
		hud.tick();

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		hud.render(g);

		g.dispose();
		bs.show();

	}

	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return min;
		} else {
			return var;
		}
	}

	public static void main(String[] args) {
		new Game();
	}

}
