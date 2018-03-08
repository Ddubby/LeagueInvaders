import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel panel=new GamePanel();
	JFrame frame=new JFrame();
	final static int XWIDTH=500;
	final static int YHEIGHT=800;
	public static void main(String[] args) {
LeagueInvaders a=new LeagueInvaders();
a.setup();
}
public LeagueInvaders(){
	
}
void setup() {
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(XWIDTH, YHEIGHT);
	frame.getContentPane().setPreferredSize(new Dimension(XWIDTH, YHEIGHT));
	frame.pack();
	frame.addKeyListener(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.startGame();
}

}
