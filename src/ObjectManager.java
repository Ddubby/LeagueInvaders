import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 4000;
	Random random = new Random();
	int score = 0;

	ObjectManager(Rocketship r) {
		rocket = r;
	}

	int getScore() {
		return score;
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

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(random.nextInt(LeagueInvaders.XWIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (a.isAlive) {
				if (rocket.collisionBox.intersects(a.collisionBox)) {
					rocket.isAlive = false;
					break;
				} else {
					for (Projectile p : projectiles) {

						if (p.isAlive) {
							if (a.collisionBox.intersects(p.collisionBox)) {
								a.isAlive = false;
								p.isAlive = false;
								score = score + 1;
								break;
							}
						}
					}
				}
			}
		}
	}
}
