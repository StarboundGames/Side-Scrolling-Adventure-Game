package the.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game implements Runnable{

	
	private Display display;
	public int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	private void init(){
		display = new Display(title, width, height);
		
	}
	private void tick(){
		
	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		//Clear Screen
		
		//Start Drawing
	

		
		//Stop Drawing
		bs.show();
		g.dispose();
	}
	public void run(){
		init();
		while(running){
			tick();
			render();
		}
		stop();
	}
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
