import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;


public class Blocks {
	int x, y, dX, dY;
	Rectangle area;
	
	public Blocks(int x, int y, int dX, int dY) {
		
		this.x = x;
		this.y = y;
		this.dX = dX;
		this.dY = dY;
		
		area = new Rectangle (x, y ,dX, dY);		
	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.blue);

		gtd.drawRect(x, y, dX, dY);
		gtd.fillRect(x, y, dX, dY);
	}
	
	
}
