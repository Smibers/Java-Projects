package container;
import java.util.Scanner;
public abstract class Container {
	public abstract double height();

	public abstract double getTopArea();

	public abstract double getTopPeri();

	public double getSurfaceArea() {
		return 2 * getTopArea() + height() * getTopPeri();
	}

	public double getVolume() {
		return height() * getTopArea();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("is it a triangle, circle, polygon, or rectangle?");
		String shape = scan.nextLine().toLowerCase();
		if (shape.charAt(0) == 'r') {
			System.out.println("what is the height");
			double height = scan.nextDouble();
			System.out.println("what is the width?");
			double width = scan.nextDouble();
			System.out.println("what is the length?");
			double length = scan.nextDouble();
			Container rectangle = new Rectangular(height, width, length);
			System.out.println(rectangle);
		} else if (shape.charAt(0) == 't') {
			System.out.println("what is the height?");
			double height = scan.nextDouble();
			System.out.println("what is the length of the first side?");
			double sidea = scan.nextDouble();
			System.out.println("what is the length of the second side?");
			double sideb = scan.nextDouble();
			System.out.println("what is the length of the third side?");
			double sidec = scan.nextDouble();
			Container triangle = new Triangular(height, sidea, sideb, sidec);
			System.out.println(triangle);
		} else if (shape.charAt(0) == 'c') {
			System.out.println("what is the height?");
			double height = scan.nextDouble();
			System.out.println("what is the radius?");
			double radius = scan.nextDouble();
			Container circle = new Circular(height, radius);
			System.out.println(circle);
		} else if(shape.charAt(0) == 'p') {
			System.out.println("what is the height");
			double height = scan.nextDouble();
			System.out.println("what is the side?");
			double side = scan.nextDouble();
			System.out.println("what is the number of sides?");
			double num = scan.nextDouble();
			Container polygon = new Polygon(height, side, num);
			System.out.println(polygon);
		}else {
			System.out.println("input invalid");
		}

	}

}
