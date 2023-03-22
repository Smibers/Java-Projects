package container;

import java.util.Scanner;

public class Containerdemo {
	public static void main(String[] args) {
		//ignore the syntax for array.
		//If you created the classes following the instruction your code should work.
		double totalSurfaceArea = 0;
		double totalVolume = 0;
		Container[] containers = new Container[8];
		containers[0] = new Circular(10., 2.0); // height, radius
		containers[1] = new Rectangular(10., 2.0, 3.0); // height, width, length
		containers[2] = new Triangular(10., 4.0, 3.0, 5.0); // height, sideA, sideB, sideC
		containers[3] = new Polygon(10., 1.0, 4); // height, side, numSides
		containers[4] = new Circular(5., 2.0); // height, radius
		containers[5] = new Rectangular(5., 2.0, 3.0); // height, width, length
		containers[6] = new Triangular(5., 4.0, 3.0, 5.0); // height, sideA, sideB, sideC
		containers[7] = new Polygon(5., 1.0, 4); // height, side, numSides

		for (Container container : containers) {
			System.out.println(container);
			System.out.println("surface area: "+container.calcSurfaceArea());
			System.out.println("volume: "+container.calcVolume());
			totalSurfaceArea+=container.calcSurfaceArea();
			totalVolume+=container.calcVolume();
			System.out.println("---------------------------------");
		}
		System.out.println("total surface area: " + totalSurfaceArea );
		System.out.println("total volume: " + totalVolume);
	}
}
