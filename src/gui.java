import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui extends JFrame {
	public static JPanel mainpanel = new JPanel();
	public static panel panel = new panel(new Color(128,128,128));
	public static panel2 panel2 = new panel2();
	public gui(){
		super("Two Point");
		setSize(1000,1200);
		setLocationRelativeTo(null);
		setVisible(true);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(1000,1000));
		panel2.setPreferredSize(new Dimension(1000,200));
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		mainpanel.add(panel);
		mainpanel.add(panel2);
		
		
		getContentPane().add(mainpanel);
	}
}
