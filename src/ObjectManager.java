import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship rocket;
	ArrayList <Projectile> projectiles=new ArrayList <Projectile>();
ObjectManager(Rocketship r){
	rocket=r;
}
void update(){
	rocket.update();
	for(Projectile p : projectiles) {
		p.update();
	}
}
void draw(Graphics g) {
	rocket.draw(g);
	for(Projectile p : projectiles) {
	p.draw(g);
}
}
void addProjectile(Projectile p) {
	projectiles.add(p);
}
}
