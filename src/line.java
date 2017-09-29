import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class line {

	private point myp1 = new point();
	private point myp2 = new point();
	private DecimalFormat round = new DecimalFormat("###0.0");
	private double yint = 0;
	private double slope = 0;
	private double distance = 0;
	
	public line() {

	}

	public line(point p1, point p2) {
		myp1 = p1;
		myp2 = p2;
	}

	public void setP1(point p1) {
		myp1 = p1;
	}

	public void setP2(point p2) {
		myp2 = p2;
	}

	public point getp1() {
		return myp1;
	}

	public point getp2() {
		return myp2;
	}
	
	public double getSlope(){
		return slope;
	}
	
	public double getYint(){
		return yint;
	}
	

	public void drawline(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Calibri",Font.PLAIN,24));
		g2.setStroke(new BasicStroke(3));
		int x1 = contonormx(myp1.getcartx());
		int y1 = contonormy(myp1.getcarty());
		int x2 = contonormx(myp2.getcartx());
		int y2 = contonormy(myp2.getcarty());
		
		g2.fillOval(x1 - 5, y1 - 5, 10, 10);
		
		g2.fillOval(x2 - 5, y2 - 5, 10,10);

		g2.drawString("( " + round.format(myp1.getcartx()) + " , " + round.format((myp1.getcarty()-10) *-1) + " )",x1 + 10, y1 + 10);

		g2.drawLine(x1, y1, x2, y2);

		g2.drawString("( " + round.format(myp2.getcartx()) + " , " + round.format((myp2.getcarty()-10) *-1 ) + " )",x2 + 10, y2 + 10);
		stats();
		g2.drawString("Slope: " + round.format(slope), x2 + 20, y2 + 35);
		g2.drawString("Yint: " + round.format(yint), x2 + 20, y2 + 55);
		g2.drawString("Distance: " + round.format(distance), x2 + 20, y2 +75);
	}
	
	public void drawCircle(Graphics g){
		int r =  (int)(Math.sqrt(Math.pow((myp2.getY() + myp1.getY()),2) + Math.pow((myp2.getY() + myp1.getY()), 2)));
		System.out.println(r);
		g.drawOval(myp1.getX(), myp1.getY(), myp2.getX() - myp1.getX(), myp2.getY() - myp1.getY());
		g.drawOval(((myp2.getX() + myp1.getX())/2) - 5, ((myp2.getY() + myp1.getY())/2) - 5, 10,10);
	}
	
	public void drawRect(Graphics g){
		g.drawRect(myp1.getX(), myp1.getY(), Math.abs(myp2.getX() - myp1.getX()), Math.abs(myp2.getY() - myp1.getY()));
	}
	
	public static int contonormx(double num){
		//System.out.println("Normal X: " + (int) Math.round((((num + 10) / 20) * panel.width)));
		return (int) Math.round((((num + 10) / 20) * panel.width));
	}
	
	public static int contonormy(double num){
		//System.out.println("Normal Y: " + (int) Math.round((10 + ((num / 20) * panel.height))));
		return (int) Math.round((10 + ((num / 20) * panel.height)));
	}
	
	public void stats(){
		slope = (((myp2.getcarty() * -1) + 10) - ((myp1.getcarty()*-1)+10)) / (myp2.getcartx() - myp1.getcartx());
		yint = ((myp1.getcarty()*-1) +10) - slope * myp1.getcartx();
		distance = Math.sqrt(Math.pow((((myp2.getcarty() * -1) + 10)+((myp1.getcarty()*-1)+10)),2) + Math.pow((myp2.getcartx() + myp1.getcartx()), 2));
	}


}
