package gameDevelopmentDemos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GraphicsDemo extends JFrame {

	public GraphicsDemo()
	{
		setTitle("My first test window");
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 200, 100);
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, 180, 80);
		g.setColor(Color.BLACK);
		g.drawString("Hello, world!", 50, 50);
	}
	
	public static void main (String args[]) {
		GraphicsDemo demo = new GraphicsDemo();
	}
	
}
