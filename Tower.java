import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tower extends TowerDefenseObject {
	
	private int shootingRadius;
	
	private int reloadTime;
	private int shotTimer;
	
	private Projectile p;
	
	public Tower(double postX, double postY, BufferedImage image, int imageWidth, int imageHeight, int shootingRadius, int reloadTime, int shotTimer, Projectile p ) {
		super(postX, postY, image, imageWidth, imageHeight);
		this.shootingRadius = shootingRadius;
		this.reloadTime = reloadTime;
		this.shotTimer = shotTimer;
		this.p = p;
	}
	
	@Override
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g);
		shotTimer -=1;
	}
	
	public Projectile fireAtEnemy(Enemy e) {
//		if (shotTimer>0) {
//			return null;
//		}
//		else {
			shotTimer = reloadTime;
			Projectile p = new Projectile(this.p);
			p.fireAtEnemy(e);
			return p;
			
//		}
	}
	
	public boolean canFire() {
		if (shotTimer<=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getShootingRadius() {
		return shootingRadius;
	}

	public void setShootingRadius(int shootingRadius) {
		this.shootingRadius = shootingRadius;
	}

	public int getReloadTime() {
		return reloadTime;
	}

	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}

	public int getShotTimer() {
		return shotTimer;
	}

	public void setShotTimer(int shotTimer) {
		this.shotTimer = shotTimer;
	}

	public Projectile getP() {
		return p;
	}

	public void setP(Projectile p) {
		this.p = p;
	}

}
