package pathfindingApp;

import javax.swing.*;
import java.awt.*;


public class App {
	
	private static final String FRAME_NAME = "Test Draw";
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	
	JFrame root;
	DrawPanel drawPanel;
	
	
	
	private class DrawPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		int [][] parts = { {158, 0},{0, 158}, {158, 158}, {316, 158}, {474, 158}, {158, 316}};
		Color [] colors = {Color.white, Color.orange, Color.green, Color.red, Color.blue, Color.yellow};

		@Override
		protected void paintComponent(Graphics g) {
			for (int color = 0; color < colors.length; color++) {
				g.setColor(Color.black);
				g.fillRect(parts[color][0], parts[color][1], 158, 158);
				g.setColor(colors[color]);
				for (int i = 2; i < 158; i+=52) {
					for (int j = 2; j < 158; j+=52) {
						g.fillRect(parts[color][0]+i, parts[color][1]+j, 50, 50);
					}
				}
			}
		}
		
	}


	public static void main(String[] args) {
		new App().start();
	}
	
	private void start() {
		
		root = new JFrame(FRAME_NAME);
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		drawPanel = new DrawPanel();
		
		root.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		root.setResizable(false);
		root.setSize(WIDTH, HEIGHT);
		root.setLocationByPlatform(true);
		root.setBackground(Color.lightGray);
		root.setVisible(true);
		
		animate();
			
	}
	
	private void animate() {
		while (true) {
			root.repaint();
		}
	}

}
