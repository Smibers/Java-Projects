package container;

public class Polygon extends Container{
double height;
double numSide;
double side;

public Polygon(double height, double side, double numSide) {
	this.height = height;
	this.numSide =numSide;
	this.side = side;
}
	@Override
	public double height() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getTopArea() {
		// TODO Auto-generated method stub
		return numSide * side * side / ( 4*Math.tan(Math.PI/numSide));
	}

	@Override
	public double getTopPeri() {
		// TODO Auto-generated method stub
		return numSide * side;

	}
	@Override
	public String toString() {
		return "Polygon height=" + height + ", numSide=" + numSide + ", side=" + side 
				+ ", Top Area()=" + getTopArea() + ", Top Perimeter=" + getTopPeri() + ", Surface Area="
				+ getSurfaceArea() + ", Volume=" + getVolume(); 
	}

}
