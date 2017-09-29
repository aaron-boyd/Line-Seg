import java.text.DecimalFormat;

public class point {

	private int myx;
	private int myy;
	private double cartx;
	private double carty;
	private DecimalFormat round =  new DecimalFormat("##0.0");

	public point() {
		myx = 0;
		myy = 0;
	}

	public point(int x, int y) {
		myx = x;
		myy = y;
	}

	public void setX(int x) {
		myx = x;
	}

	public void setY(int y) {
		myy = y;
	}

	public void setcartX(double x){
		cartx = x;
	}
	public void setcartY(double y){
		carty = y;
	}
	
	public int getX() {
		return myx;
	}

	public int getY() {
		return myy;
	}
	
	public double getcartx(){
		return cartx;
	}
	
	public double getcarty(){
		return carty;
	}

	public String toString() {
		return ("( " + round.format(cartx) + " , " + round.format(((carty) -10) *-1) + " )");
	}
}
