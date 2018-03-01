import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Timer timer;
GameObject object=new GameObject(10, 10, 100, 100);
public GamePanel(){
	timer=new Timer(1000/60, this);
}
void startGame() {
	timer.start();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	object.update();
	repaint();
}
@Override

public void paintComponent(Graphics g){
object.draw(g);
        }
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
