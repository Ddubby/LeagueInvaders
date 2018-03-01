import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel panel=new GamePanel();
	JFrame frame=new JFrame();
	int xwidth=500;
	int yheight=800;
	public static void main(String[] args) {
LeagueInvaders a=new LeagueInvaders();
a.setup();
}
public LeagueInvaders(){
	
}
void setup() {
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(xwidth, yheight);
	frame.getContentPane().setPreferredSize(new Dimension(xwidth, yheight));
	frame.pack();
	frame.addKeyListener(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.startGame();
}

}
