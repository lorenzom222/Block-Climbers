import java.awt.Color;
;

public class Window extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window() {
		Game game = new Game();
		game.setLocation(0,0);
		game.setSize(this.getSize());
		game.setBackground(Color.white);
		game.setVisible(true);
		this.add(game);
		
		addKeyListener(new Keys(game));
		
	}
	
	}
	

