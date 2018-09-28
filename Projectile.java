import java.awt.image.BufferedImage;

public class Projectile extends MovingTowerDefenseObject {
	private int damage;
	private double totalVelocity;

	public Projectile(double postX, double postY, BufferedImage image, int imageWidth, int imageHeight,
			double xVelocity, double yVelocity, int damage, double totalVelocity) {
		super(postX, postY, image, imageWidth, imageHeight, xVelocity, yVelocity);
		this.damage = damage;
		this.totalVelocity = totalVelocity;
		
	}
	
	public Projectile(Projectile p) {
		super(p.getPostX(), p.getPostY(), p.getImage(), p.getImageWidth(), p.getImageHeight(), p.getxVelocity(), p.getyVelocity());
		damage = p.damage;
		totalVelocity = p.totalVelocity;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getTotalVelocity() {
		return totalVelocity;
	}

	public void setTotalVelocity(double totalVelocity) {
		this.totalVelocity = totalVelocity;
	}
	
	public void fireAtEnemy(Enemy e) {
		
		double directionOfFire= Math.atan2(e.getPostY()-getPostY(), e.getPostX()-getPostX());
		setxVelocity(totalVelocity*Math.cos(directionOfFire));
		setyVelocity(totalVelocity*Math.sin(directionOfFire));
		

		
	}
	

}
