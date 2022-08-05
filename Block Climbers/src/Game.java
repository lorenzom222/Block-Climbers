import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends javax.swing.JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Climber climber;
	Climber2 climber2;
	ArrayList<Blocks> blocks = new ArrayList<>();
	Timer gameTimer;
	
	public void paint(Graphics g) {
		
		super.paint(g);

		Graphics2D create = (Graphics2D) g;
		Font f = new Font("Arial", Font.CENTER_BASELINE, 20);
		g.setFont(f);
		g.drawString("Be the 1st to Reach the Top!", 390, 50);
		g.drawString("Be the 1st to Reach the Top!", 40, 50);

		climber.draw(create);
		climber2.draw(create);
		for(Blocks block: blocks) block.draw(create);
		
	}
	public void makeBlocks(int offset) {
		
		//borders
		for (int i = 20; i< 700; i+= 20) {
			blocks.add(new Blocks(i, 650, 20, 20));
		}
		for (int i = 20; i< 700; i+= 20) {
			blocks.add(new Blocks(680, i, 20, 20));
		}
		for (int i = 20; i< 700; i+= 20) {
			blocks.add(new Blocks(0, i, 20, 20));
		}
		
		for (int i = 20; i< 700; i+= 20) {
			blocks.add(new Blocks(340, i, 20, 20));
		}
		// map1
		blocks.add(new Blocks(160, 600, 180, 20));
		blocks.add(new Blocks(20, 540, 180, 20));
		blocks.add(new Blocks(160, 480, 180, 20));
		blocks.add(new Blocks(20, 420, 180, 20));
		blocks.add(new Blocks(160, 360, 180, 20));
		blocks.add(new Blocks(20, 300, 180, 20));
		blocks.add(new Blocks(20, 240, 180, 20));
		blocks.add(new Blocks(20, 180, 180, 20));
		blocks.add(new Blocks(160, 120, 180, 20));

		//map 2
		
		blocks.add(new Blocks(360, 600, 180, 20));
		blocks.add(new Blocks(500, 540, 180, 20));
		blocks.add(new Blocks(500, 300, 180, 20));
		blocks.add(new Blocks(360, 480, 180, 20));
		blocks.add(new Blocks(360, 360, 180, 20));
		blocks.add(new Blocks(360, 120, 180, 20));
		blocks.add(new Blocks(500, 420, 180, 20));
		blocks.add(new Blocks(500, 240, 180, 20));
		blocks.add(new Blocks(500, 180, 180, 20));
		
	
		
	}
	

	

	
	

//switch statements
	 public void keyPressed(KeyEvent e) {

		 if(e.getKeyChar()== 'a') climber.keyLeft = true;
		 if(e.getKeyChar()== 'w') climber.keyUp = true;
		 if(e.getKeyChar()== 'd') climber.keyRight = true;
		 if(e.getKeyCode() == KeyEvent.VK_LEFT) climber2.keyLeftA = true;
		 if(e.getKeyCode() == KeyEvent.VK_UP) climber2.keyUpA = true;
		 if(e.getKeyCode() == KeyEvent.VK_RIGHT) climber2.keyRightA = true;

	}

	 public void keyReleased(KeyEvent e) {
		 if(e.getKeyChar()== 'a') climber.keyLeft = false;
		 if(e.getKeyChar()== 'w') climber.keyUp = false;
		 if(e.getKeyChar()== 'd') climber.keyRight = false;
		 if(e.getKeyCode() == KeyEvent.VK_LEFT) climber2.keyLeftA = false;
		 if(e.getKeyCode() == KeyEvent.VK_UP) climber2.keyUpA = false;
		 if(e.getKeyCode() == KeyEvent.VK_RIGHT) climber2.keyRightA = false;
	}
	 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		public Game() {
			
			climber= new Climber(400, 300, this);
			climber2= new Climber2(600, 400, this);

			spawn();
			
			gameTimer = new Timer();
			gameTimer.schedule(new TimerTask() {
				
				public void run() {
					climber.set();
					climber2.set();

					repaint();
					
				}
			}, 0, 15);
		}	
		
		public void spawn() {
			climber.x = 100;
			climber.y = 650;
			climber2.x = 600;
			climber2.y = 650;
			climber.xVelocity = 0;
			climber.yVelocity = 0;
			climber2.xVelocity = 0;
			climber2.yVelocity = 0;
			blocks.clear();
			int offset = 50;
			makeBlocks(offset);

			
			}
	

}
