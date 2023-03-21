package container;

public class Rectangular extends Container{
double height;
double width;
double length;
	public Rectangular(double height, double width, double length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	@Override
	public double height() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getTopArea() {
		// TODO Auto-generated method stub
		return width * length;
	}

	@Override
	public String toString() {
		return "Rectangular height=" + height + ", width=" + width + ", length=" + length 
				+ ", Top Area=" + getTopArea() + ", Top Perimeter=" + getTopPeri() + ", Surface Area="
				+ calcSurfaceArea() + ", Volume=" + calcVolume();
	}
	@Override
	public double getTopPeri() {
		// TODO Auto-generated method stub
		return 2 * (width * length);
	}

}
