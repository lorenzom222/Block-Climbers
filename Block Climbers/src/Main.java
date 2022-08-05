import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		Window frame = new Window();
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Title");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
