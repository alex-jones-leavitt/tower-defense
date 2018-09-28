import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class MousePanel extends JPanel{

	private int x = 10;
	private int y = 10;
	private Color c = Color.red;
	
	private boolean drawTheTower;


	public boolean isdrawTheTower() {
		return drawTheTower;
	}

	public void setdrawTheTower(boolean drawTheTower) {
		this.drawTheTower = drawTheTower;
	}

	public MousePanel(){
		super();

		drawTheTower = true;
		
		DrBsMouseListener listener = new DrBsMouseListener();
		this.addMouseMotionListener(listener);
		this.addMouseListener(listener);

	}

	public void paintComponent(Graphics g){
		//super.paintComponent(g);


		//Erase the old image
		g.setColor(Color.gray);
		g.fillRect(0, 0, getWidth(), getHeight());

		if(drawTheTower == true) {
			g.setColor(c);
			g.fillOval(x, y, 50, 50);
		}
	}


	private class DrBsMouseListener implements MouseMotionListener, MouseListener{

		@Override
		public void mouseDragged(MouseEvent e) {

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			x = e.getX()-25;
			y = e.getY()-25;

			System.out.println("The mouse is at " + x + " " + y);

			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				drawTheTower = !drawTheTower;
			}
			else if(e.getButton() == MouseEvent.BUTTON3) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				c = new Color(r,g,b);
				
				drawTheTower = true;
			}
			repaint();
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

	}







	public static void main(String[] args) {
		JFrame f = new JFrame("Mouse Panel Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MousePanel p = new MousePanel();
		f.add(p);
		f.setSize(400,400);
		f.setVisible(true);
	}




}
