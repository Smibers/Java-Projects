package container;

public class Triangular extends Container{

	double height;
	double sideA;
	double sideB;
	double sideC;
	public Triangular(double height, double sideA, double sideB, double sideC) {
		super();
		this.height = height;
		this.sideA =sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	@Override
	public double height() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getTopArea() {
		// TODO Auto-generated method stub
		double s = (sideA + sideB + sideC)/2.0;
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));

	}

	@Override
	public double getTopPeri() {
		// TODO Auto-generated method stub
		return sideA + sideB + sideC;
	}
	@Override
	public String toString() {
		return "Triangular height=" + height + ", sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC
				+ ", Top Area=" + getTopArea() + ", Top Perimeter=" + getTopPeri()
				+ ", Surface Area=" + calcSurfaceArea() + ", Volume=" + calcVolume() ;
	}

}
