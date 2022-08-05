import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Climber {

	Game game;
	int x, y, dX, dY;
	double xVelocity, yVelocity;

	Rectangle area;
	
	boolean keyLeft, keyRight, keyUp;


	public Climber(int x, int y, Game game) {
		this.game = game;
		this.x = x;
		this.y = y;

		dX =20;
		dY = 20;
		area = new Rectangle(x, y, dX, dY);
		
		
		
		
	}
	
	public void set () {
		//Do nothing we both or none are pressed
		if(keyLeft && keyRight || !keyLeft && !keyRight) {
			xVelocity*=0.8;
		}
		else if(keyLeft && !keyRight) {
			xVelocity --;
		}
		else if(!keyLeft && keyRight) {
			xVelocity ++;
		}
		//prevent sliding
		if(xVelocity>0 && xVelocity < 0.75) {
			xVelocity =0;
		}
		if(xVelocity<0 && xVelocity > -0.75) {
			xVelocity =0;
		}
		
		if(xVelocity > 7) {
			xVelocity= 7;
		}
		if(xVelocity < -7) xVelocity= -7;
		{
			
		}
		if(keyUp) {
			//Check if touching ground

			//only jump speicifc abov block
			area.y ++;
			for(Blocks block: game.blocks) {
				if(block.area.intersects(area)) yVelocity = -6;

			}
			area.y --;
			
			
			
		}
		yVelocity +=0.3;

		//Horizontal Collision
		area.x += xVelocity;
		for(Blocks block: game.blocks) {
			if(area.intersects(block.area)) {
				area.x -= xVelocity; //moves player back
				while(!block.area.intersects(area)) 
					area.x += Math.signum(xVelocity);
					area.x -= Math.signum(xVelocity);
					xVelocity =0 ;
					x=area.x;

			}
		}
		
		
		//Vert Coll
		
		area.y += yVelocity;
		for(Blocks block: game.blocks) {
			if(area.intersects(block.area)) {
				area.y -= yVelocity; //moves player back
				while(!block.area.intersects(area)) 
					area.y += Math.signum(yVelocity);
					area.y -= Math.signum(yVelocity);
					yVelocity =0 ;
					y=area.y;

			}
		}
		
		x += xVelocity;
		y += yVelocity;
		area.x = x;
		area.y = y;
		

	}
	
	public void draw(Graphics2D create) {
		create.setColor(Color.BLACK);
		create.fillRect(x, y, dX, dY);
		
		if(y<70) {
			
			
			create.setColor(Color.RED);
			yVelocity =0;
			xVelocity =0;
		

			Font f = new Font("Arial", Font.BOLD, 40);
			create.setFont(f);
			create.drawString("Winner", 100, 100);
			create.drawString("Loser", 450, 100);



		}
		
	}
	

	
}
