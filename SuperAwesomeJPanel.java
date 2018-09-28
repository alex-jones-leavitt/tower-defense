import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SuperAwesomeJPanel extends JPanel {
	
		private int rows;
		private int columns;
		private BufferedImage[][] imgs;
		private final int tileSize = 64;
		private int whichTower;
		
		private int money;
		private int health;
		private int enemiesLeft;
		
		private JLabel labelMoney;
		private JLabel labelHealth;
		private JLabel labelEnemiesLeft;
		
		private boolean pressed;
		
		private Tower[] towers;
		private int towerSpot;
		private Enemy[] enemies;
		private Projectile[] projectiles;
		private int projectileSpot;
		
		private BufferedImage t1;
		private BufferedImage t2;
		private BufferedImage t3;

		private BufferedImage e1;
		private BufferedImage e2;
		private BufferedImage e3;
		
		private BufferedImage p1;
		private BufferedImage p2;
		private BufferedImage p3;
		
		private int diameter;
		private int x;
		private int y;
		private Color c;

		private int diameter2;
		private int x2;
		private int y2;
		private Color c2;

		
		private boolean showTheTower;
		private boolean start;
		
		private SuperAwesomeJFrame SuperAwesomeJFrame;
		private int numLives;
		
		public SuperAwesomeJPanel(int x, int y, int rows, int columns, JLabel labelMoney, JLabel labelHealth, JLabel labelEnemiesLeft) {
			try {
			this.x = x;
			this.y = y;
			this.rows = rows;
			this.columns = columns;
			imgs = new BufferedImage[rows][columns];
			this.labelMoney = labelMoney;
			this.labelHealth = labelHealth;
			this.labelEnemiesLeft = labelEnemiesLeft;
			
			this.money = 100;
			this.health = 5;
			this.enemiesLeft = 10;
			
			pressed = false;
			towerSpot = 0;
			start = false;
			
			towers = new Tower[1000];
			enemies = new Enemy[10];
			projectiles = new Projectile[10000];
			
				t1 = ImageIO.read(new File("spidey.png"));
				t2 = ImageIO.read(new File("ironman.png"));
				t3 = ImageIO.read(new File("Thor.png"));
				
				e1 = ImageIO.read(new File("venom.png"));
				e2 = ImageIO.read(new File("Whiplash.png"));
				e3 = ImageIO.read(new File("Loki.png"));
				
				p1 = ImageIO.read(new File("web.png"));
				p2 = ImageIO.read(new File("blast.png"));
				p3 = ImageIO.read(new File("Hammer.png"));

			
			showTheTower = false;
			
			this.setSize(300, 400);
			this.setMinimumSize(new Dimension(300,400));
			
			MyMouseListener mouse = new MyMouseListener();
			this.addMouseMotionListener(mouse);
			this.addMouseListener(mouse);
			} catch (IOException e) {
				System.err.println("Unable to read the file: " + t1);
			}
		}
		
		
		public boolean isshowTheTower() {
			return showTheTower;
		}


		public void setshowTheTower(boolean showTheTower) {
			this.showTheTower = showTheTower;
			repaint();
		}
		
		public void addPicture(int x, int y, String filename){
			if (x < 0 || x >= rows){
				System.err.println("There is no row " + x);
			}
			else if (y < 0 || y >= columns){
				System.err.println("There is no col " + y);
			}
			else{
					try {
						imgs[x][y] = ImageIO.read(new File(filename));
					} catch (IOException e) {
						System.err.println("Unable to read the file: " + filename);
					}
			}
		}
		//create the enemies at start of game
		public void startGame() {
			start = true;
			for(int i = 0; i<enemies.length; i++) {
				if(i%3 == 0) {
					enemies[i] = new Enemy(-i*64,63.0*4,e1,64,64,2,0.0,25);
				}
				if(i%3 == 1) {
					enemies[i] = new Enemy(-i*64,63*4,e2,64,64,2.5,0.0,20);
				}
				if(i%3 == 2) {
					enemies[i] = new Enemy(-i*64,63*4,e3,64,64,1,0.0,30);
				}
			}
		}
		//paint the board
		public void paint(Graphics g){
			for (int i = 0; i < rows; i++){
				for (int j = 0; j < columns; j++){
					g.drawImage(imgs[i][j], j*tileSize, i*tileSize, null);
				}
			}
			//create the towers
			if(money >0) {
			if(showTheTower == true) {
				if(whichTower == 1) {
					if(money > 9 && (y<=3*64 || y>=5*64)) {
					g.drawImage(t1, x, y, 64, 64, null);
					if(pressed == true) {
						Projectile web = new Projectile(x,y,p1,30,15,2,2,6,10);
						towers[towerSpot] = new Tower(x, y, t1, 64, 64, 500, 60, 0, web);
						pressed = false;
						showTheTower = false;
						towerSpot++;
						money -= 10;
						labelMoney.setText("Monies = " +money);
					}
					}
				}

				else if(whichTower == 2) {
					if(money > 19 && (y<=3*64 || y>=5*64)) {
						g.drawImage(t2, x, y, 64, 64, null);
						if(pressed == true) {
							Projectile blast = new Projectile(x,y,p2,20,15,2,2,3,10);
							towers[towerSpot] = new Tower(x, y, t2, 64, 64, 200, 30, 0, blast);
							pressed = false;
							showTheTower = false;
							towerSpot++;
							money -= 20;
							labelMoney.setText("Monies = " +money);

						}
					}
				}
				
				else if(whichTower == 3) {
					if(money > 29 && (y<=3*64 || y>=5*64)) {
						g.drawImage(t3, x, y, 64, 64, null);
						if(pressed == true) {
							Projectile hammer = new Projectile(x,y,p3,20,15,2,2,12,10);
							towers[towerSpot] = new Tower(x, y, t3, 64, 64, 100, 90, 0, hammer);
							pressed = false;
							showTheTower = false;
							towerSpot++;
							money -= 30;
							labelMoney.setText("Monies = " +money);
						}
					}
				}
				}
			}
			
			for(int i=0; i<towers.length; i++) {
				if(towers[i] !=null) {
					towers[i].drawTheImage(g);
					if(towers[i].canFire() == true) {
						for(int j=0; j<enemies.length; j++) {
							if(enemies[j] != null) {
								projectiles[projectileSpot] = towers[i].fireAtEnemy(enemies[j]);
								projectileSpot++;
								break;
							}
						}
					}
				}
				}
			//paint the enemies
			if(start == true && health>0) {	
			for(int j=0; j<enemies.length; j++) {
				if(enemies[j] != null) {
						enemies[j].drawTheImage(g);
						if(enemies[j].getPostX()>=640) {
							this.health --;
							enemies[j] = null;
							labelHealth.setText("Health = "+health);					
						}
//						else if(enemies[j].getEnemyHealth()<=0) {
//							enemies[j] = null;
//						}
					
				}
			}
			}
			
			for(int i=0; i<projectiles.length; i++) {
				if(projectiles[i]!=null) {
					projectiles[i].drawTheImage(g);
//				}
				for(int j=0; j<enemies.length; j++) {
					if(enemies[j] != null && projectiles[i].getPostX()>=enemies[j].getPostX() && projectiles[i].getPostX()<=enemies[j].getPostX()+64 && projectiles[i].getPostY()>=enemies[j].getPostY() && projectiles[i].getPostY()<=enemies[j].getPostY()+64) {
						int enemyHealth = enemies[j].getEnemyHealth();
						enemyHealth -= projectiles[i].getDamage();
						enemies[j].setEnemyHealth(enemyHealth);
						projectiles[i] = null;
						if(enemies[j].getEnemyHealth()<=0) {
							enemies[j] = null;
						}
						break;
					}
				}
				}
			}
			
			repaint();
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}


		
		
		
		private class MyMouseListener implements MouseListener, MouseMotionListener{

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("something");
				
				if(showTheTower == true) {
					pressed = true;
				}

				numLives--;
				
				
				diameter2 = diameter;
				x2 = x;
				y2 = y;
				c2 = c;

				repaint();
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
				repaint();
				
			}
			
		}
		public int getWhichTower() {
			return whichTower;
		}


		public void setWhichTower(int whichTower) {
			this.whichTower = whichTower;
			showTheTower = true;
		}
	

}
