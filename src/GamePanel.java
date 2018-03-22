import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font endFont = new Font("Arial", Font.PLAIN, 48);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if (!rocket.isAlive) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.fillRect(0, 0, LeagueInvaders.XWIDTH, LeagueInvaders.YHEIGHT);
		g.setColor(Color.YELLOW);
		Rectangle r = new Rectangle(LeagueInvaders.XWIDTH, LeagueInvaders.YHEIGHT);
		drawCenteredString(g, "LEAGUE INVADERS", r, titleFont);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.XWIDTH, LeagueInvaders.YHEIGHT);
		manager.draw(g);
		String a = Integer.toString(manager.getScore());
		g.drawString("Score:", 400, 50);
		g.drawString(a, 450, 50);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.XWIDTH, LeagueInvaders.YHEIGHT);
		Rectangle r = new Rectangle(LeagueInvaders.XWIDTH, LeagueInvaders.YHEIGHT);
		g.setColor(Color.BLACK);
		drawCenteredString(g, "GAME OVER", r, endFont);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

		repaint();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END_STATE) {
				rocket = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(rocket);
				currentState = MENU_STATE;

			} else if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.x = rocket.x - rocket.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.x = rocket.x + rocket.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.y = rocket.y + rocket.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.y = rocket.y - rocket.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as in java
		// 2d 0 is top of the screen)
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		// Set the font
		g.setFont(font);
		// Draw the String
		g.drawString(text, x, y);
	}
}
