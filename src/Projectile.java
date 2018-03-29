import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed = 10;

	Projectile(int x, int y, int height, int width) {
		super(x, y, height, width);
	}

	void update() {
		super.update();
		y = y - speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		   g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
