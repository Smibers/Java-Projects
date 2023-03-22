package container;

public class Circular extends Container{
double height;
double radius;
	public Circular(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}
	@Override
	public double height() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getTopArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	@Override
	public double getTopPeri() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}
	@Override
	public String toString() {
		return "Circular height=" + height + ", radius=" + radius + ", Top Area="
				+ getTopArea() + ", Top Perimeter=" + getTopPeri() + ", Surface Area=" + calcSurfaceArea()
				+ ", Volume=" + calcVolume();
	}
}
