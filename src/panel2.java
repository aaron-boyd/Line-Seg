import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class panel2 extends JPanel{
	
	public static JTextField txtx1 = new JTextField("1");
	public static JTextField txty1 = new JTextField("2");
	public static JTextField txtx2 = new JTextField("5");
	public static JTextField txty2 = new JTextField("6");
	public static JRadioButton rbline = new JRadioButton("Line");
	public static JRadioButton rbcircle = new JRadioButton("Circle");
	public static JRadioButton rbrect = new JRadioButton("Rectangle");
	public static ButtonGroup group = new ButtonGroup();
	public static JLabel lblx1 = new JLabel("X1: ");
	public static JLabel lbly1 = new JLabel("Y1: ");
	public static JLabel lblx2 = new JLabel("X2: ");
	public static JLabel lbly2 = new JLabel("Y2: ");
	public static JButton enter = new JButton("Plot");
	public static JButton clear = new JButton("Clear");
	public static int linecount = 1;
	
	public panel2(){
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(20,20,20,20);
		
		Font font = new Font("Calibri",Font.PLAIN,20); 
		Font newfont = new Font("Calibri",Font.PLAIN,40);
		
		txtx1.setPreferredSize(new Dimension(400,50));
		txty1.setPreferredSize(new Dimension(400,50));
		txtx2.setPreferredSize(new Dimension(400,50));
		txty2.setPreferredSize(new Dimension(400,50));
		lblx1.setPreferredSize(new Dimension(75,50));
		lbly1.setPreferredSize(new Dimension(75,50));
		lblx2.setPreferredSize(new Dimension(75,50));
		lbly2.setPreferredSize(new Dimension(75,50));
		enter.setPreferredSize(new Dimension(200,75));
		clear.setPreferredSize(new Dimension(200,75));
		rbline.setPreferredSize(new Dimension(150,100));
		rbcircle.setPreferredSize(new Dimension(150,100));
		rbrect.setPreferredSize(new Dimension(200,100));
		txtx1.setFont(newfont);
		txty1.setFont(newfont);
		txtx2.setFont(newfont);
		txty2.setFont(newfont);
		lblx1.setFont(newfont);
		lbly1.setFont(newfont);
		lblx2.setFont(newfont);
		lbly2.setFont(newfont);
		enter.setFont(newfont);
		clear.setFont(newfont);
		rbline.setFont(newfont);
		rbcircle.setFont(newfont);
		rbrect.setFont(newfont);
		
		group.add(rbline);
		group.add(rbcircle);
		group.add(rbrect);
		
		c.gridx = 0;
		c.gridy = 0;
		add(lblx1,c);
		
		c.gridx = 1;
		add(txtx1,c);
		
		c.gridx = 2;
		add(lbly1, c);
		
		c.gridx = 3;
		add(txty1,c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(lblx2,c);
		
		c.gridx = 1;
		add(txtx2,c);
		
		c.gridx = 2;
		add(lbly2,c);
		
		c.gridx = 3;
		add(txty2,c);
		
		c.gridx = 0;
		c.gridy = 0;
		add(enter,c);
		add(clear,c);
		
		c.gridy = 3;
		c.gridx = 0;
		add(rbline,c);
		add(rbcircle, c);
		add(rbrect,c);
		
	}
}
