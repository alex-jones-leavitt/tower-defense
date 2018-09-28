import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TowerDefenseObject {
	
	private double postX;
	private double postY;
	
	BufferedImage image;
	
	private int imageWidth;
	private int imageHeight;
	
	public TowerDefenseObject(double postX, double postY, BufferedImage image, int imageWidth, int imageHeight) {
		this.postX = postX;
		this.postY = postY;
		this.image = image;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	
	public void drawTheImage(Graphics g) {
		g.drawImage(image, (int)postX, (int)postY, imageWidth, imageHeight, null);
	}

	public double getPostX() {
		return postX;
	}

	public void setPostX(double postX) {
		this.postX = postX;
	}

	public double getPostY() {
		return postY;
	}

	public void setPostY(double postY) {
		this.postY = postY;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	
	

}
