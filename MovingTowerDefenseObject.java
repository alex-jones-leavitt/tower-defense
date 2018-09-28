import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingTowerDefenseObject extends TowerDefenseObject {
	
	
	private double xVelocity;
	private double yVelocity;
	
	public MovingTowerDefenseObject(double postX, double postY, BufferedImage image, int imageWidth, int imageHeight, double xVelocity, double yVelocity) {
		super(postX, postY, image, imageWidth, imageHeight);
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
	
	@Override
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g);
		super.setPostX(super.getPostX() + xVelocity);
		super.setPostY(super.getPostY() + yVelocity);
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
	
}
