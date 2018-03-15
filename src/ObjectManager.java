import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Timer;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ObjectManager(Rocketship r) {
		rocket = r;
	}

	void update() {
		rocket.update();
		for (Projectile p : projectiles) {
			p.update();
		}
		for (Alien a : aliens) {
			a.update();
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile p : projectiles) {
			p.draw(g);
		}
		for (Alien a : aliens) {
			a.draw(g);
		}
	}

	void addAlien(Alien a) {
		aliens.add(a);
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
}
