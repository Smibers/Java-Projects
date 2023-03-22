package temperature;

import java.util.Scanner;

public class Temp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double centigrade;
		int count = 0;
		double averageC=0;
		double averageF=0;
		System.out.println("Enter Temp in Centigrade or <= -100.0 to quit: ");
		centigrade = scan.nextInt();
		while (centigrade > -100) {
			
			double far = (9.0/5.0)*centigrade + 32.0;
			System.out.println("Temperature: Farenheit ("+ far +")  Cantigrade ("+centigrade+")" );
			count++;
			averageC = averageC + centigrade;
			averageF = averageF + far;
			System.out.println("Enter Temp in Centigrade or <= -100.0 to quit: ");
			centigrade = scan.nextInt();
		}
		averageC= averageC/count;
		averageF = averageF/count;
		System.out.println("Average Centigrade: "+ averageC +  "  Average Farenheit: "+averageF);
	}

}
