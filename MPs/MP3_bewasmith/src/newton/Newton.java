package newton;

import java.util.Scanner;

public class Newton {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter 'N' for Newton");
		double N = scan.nextInt();
		double last_guess = mySQRT(N);
		double guessVar = mySQRT2(N, last_guess);
		System.out.println("Newton (" + N + ")= " + guessVar);
		double sqrt = Math.sqrt(N);
		System.out.println("Math.sqrt = " + sqrt);
	}

	static double mySQRT(double N) {
		double last_guess = N / 2;
		return last_guess;
	}

	static double mySQRT2(double N, double last_guess) {

		double new_guess1 = ((N / last_guess) + last_guess) / 2;
		double guessVar = new_guess1;
		double new_guess = 0;
		double low_value = 0;
		while (guessVar - low_value > .000001) {
			low_value = guessVar;
			new_guess = ((N / guessVar) + guessVar) / 2;
			guessVar = new_guess;

		}
		return new_guess;
	}

}
