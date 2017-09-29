import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class panel extends JPanel {

	public static point center = new point();
	public static line line1 = new line();
	public static line line2 = new line();
	public static int count = 0;
	public static double width = 0;
	public static double height = 0;

	public panel(Color backColor) {
		setBackground(backColor);
		addMouseListener(new PanelListener());
		addMouseMotionListener(new PanelMotionListener());

		panel2.enter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (panel2.linecount == 1) {
					line1.getp1().setcartX(Double.parseDouble(panel2.txtx1.getText()));
					line1.getp1().setcartY((Double.parseDouble(panel2.txty1.getText()) - 10) * -1);
					line1.getp2().setcartX(Double.parseDouble(panel2.txtx2.getText()));
					line1.getp2().setcartY((Double.parseDouble(panel2.txty2.getText()) - 10) * -1);
					count = 2;
					panel2.linecount = 2;
				} else if (panel2.linecount == 2) {
					line2.getp1().setcartX(Double.parseDouble(panel2.txtx1.getText()));
					line2.getp1().setcartY((Double.parseDouble(panel2.txty1.getText()) - 10) * -1);
					line2.getp2().setcartX(Double.parseDouble(panel2.txtx2.getText()));
					line2.getp2().setcartY((Double.parseDouble(panel2.txty2.getText()) - 10) * -1);
					count = 3;
				}
				repaint();
			}
		});

		panel2.clear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				count = 0;
				repaint();
			}
		});
		
	    panel2.rbline.addActionListener(new ActionListener() {
	
	        public void actionPerformed(ActionEvent e) {
	        	count = 0;
	        	repaint();
	        }
	    });
	    
	    panel2.rbcircle.addActionListener(new ActionListener() {
	    	
	        public void actionPerformed(ActionEvent e) {
	        	count = 0;
	        	repaint();
	        }
	    });
	    
	    panel2.rbrect.addActionListener(new ActionListener() {
	    	
	        public void actionPerformed(ActionEvent e) {
	        	count = 0;
	        	repaint();
	        }
	    });

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Calibri", Font.PLAIN, 16));
		g2.setStroke(new BasicStroke(3));
		int x = (getWidth() / 2);
		int y = (getHeight() / 2);
		width = getWidth();
		height = getHeight();
		g2.clearRect(0, 0, (int) width, (int) height);
		center.setX(x);
		center.setY(y);
		g2.setColor(Color.black);
		g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		g2.setColor(Color.red);
		for (int i = 0; i <= 20; i++) {
			if (i != 10) {
				g2.drawLine((int)(((double)(getWidth() / 2)) - 15), (int)(((double)(getHeight() / 20)) * i), (int)(((double)(getWidth() / 2)) + 15), (int)((double)(getHeight() / 20)) * i);
				g2.drawLine((int)(((double)(getWidth() / 20)) * i), (int)(((double)(getHeight() / 2)) + 15), (int)(((double)(getWidth() / 20)) * i),(int)(((double)(getHeight() / 2)) - 15));
				//g.drawString(getWidth() + " " + getHeight(),  20,20);
			}

			if (count == 1 || count == 2) {
				if (panel2.rbline.isSelected()) {
					line1.drawline(g2);
				} else if (panel2.rbcircle.isSelected()) {
					line1.drawCircle(g2);
				} else if (panel2.rbrect.isSelected()) {
					line1.drawRect(g2);
				}
			} else if (count == 3) {
				if (panel2.rbline.isSelected()) {
					line2.drawline(g2);
					line1.drawline(g2);
					findInt(g2);
				} else if (panel2.rbcircle.isSelected()) {
					line1.drawCircle(g2);
					line2.drawCircle(g2);
				} else if (panel2.rbrect.isSelected()) {
					line1.drawRect(g2);
					line2.drawRect(g2);
				}
			}
		}
	}

	public void findInt(Graphics g) {
		point inter = new point();
		inter.setcartX((line2.getYint() - line1.getYint()) / (line1.getSlope() - line2.getSlope()));
		inter.setcartY((((line1.getSlope() * inter.getcartx()) + line1.getYint()) - 10) * -1);
		// System.out.println(inter.toString());
		g.drawOval((int) (Math.round((((inter.getcartx() + 10) / 20) * width))) - 5,
				(int) Math.round((10 + ((inter.getcarty() / 20) * panel.height))) - 5, 10, 10);
		g.drawString(inter.toString(), (int) (Math.round((((inter.getcartx() + 10) / 20) * width))) + 10,
				(int) Math.round((10 + ((inter.getcarty() / 20) * panel.height))) + 10);
	}

	private class PanelListener extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if (!panel2.rbline.isSelected() && !panel2.rbcircle.isSelected() && !panel2.rbrect.isSelected()) {
				JOptionPane.showMessageDialog(null, "Please select a graphing option (Line, Circle, Rectangle)","ERROR", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (count == 0) {
					// set point 1 on line 1//
					line1.getp1().setX(e.getX());
					line1.getp1().setY(e.getY());
					line1.getp1().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
					line1.getp1().setcartY(Math.rint(((e.getY() / height) * 20)));
					// set temp point 2 on line 1//
					line1.getp2().setX(e.getX());
					line1.getp2().setY(e.getY());
					line1.getp2().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
					line1.getp2().setcartY(Math.rint(((e.getY() / height) * 20)));
					// change counter and repaint//
					count = 1;
					repaint();
				} else if (count == 2) {
					// set point 1 on line 2//
					line2.getp1().setX(e.getX());
					line2.getp1().setY(e.getY());
					line2.getp1().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
					line2.getp1().setcartY(Math.rint(((e.getY() / height) * 20)));
					// set temp point 2 on line 2//
					line2.getp2().setX(e.getX());
					line2.getp2().setY(e.getY());
					line2.getp2().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
					line2.getp2().setcartY(Math.rint(((e.getY() / height) * 20)));
					// change counter and repaint//
					count = 3;
					repaint();
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (count == 1) {
				// set point 2 on line 1//
				line1.getp2().setX(e.getX());
				line1.getp2().setY(e.getY());
				line1.getp2().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
				line1.getp2().setcartY(Math.rint(((e.getY() / height) * 20)));
				// change counter and repaint//
				repaint();
				count = 2;
			} else if (count == 3) {
				// set point 2 on line 2//
				line2.getp2().setX(e.getX());
				line2.getp2().setY(e.getY());
				line2.getp2().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
				line2.getp2().setcartY(Math.rint(((e.getY() / height) * 20)));
				// change counter and repaint//
				repaint();
				count = 3;

			}
		}
	}

	private class PanelMotionListener extends MouseMotionAdapter {

		public void mouseDragged(MouseEvent e) {
			if (count == 1) {
				// set drag point 2 on line 1//
				line1.getp2().setX(e.getX());
				line1.getp2().setY(e.getY());
				line1.getp2().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
				line1.getp2().setcartY(Math.rint(((e.getY() / height) * 20)));
				repaint();
			} else if (count == 3) {
				// set drag point 2 on line 2
				line2.getp2().setX(e.getX());
				line2.getp2().setY(e.getY());
				line2.getp2().setcartX(Math.rint(-10 + ((e.getX() / width) * 20)));
				line2.getp2().setcartY(Math.rint(((e.getY() / height) * 20)));
				repaint();
			}
		}

	}

}
