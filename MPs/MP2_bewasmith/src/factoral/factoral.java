package factoral;
import java.util.Scanner;
public class factoral {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String choice = "yes";
		int N;
		while (choice.equalsIgnoreCase("yes")) {
			System.out.println("enter in N: ");
			N = scan.nextInt();
			int FirstN=N;

			for (int i =1 ; i<FirstN ; i++) {
				N = N*(FirstN-i) ;
			};

		System.out.println("Factoral is: "+N);
		scan.nextLine();
		System.out.println("would you like to try again?(yes/no)");
		choice=scan.nextLine();
		}
		System.out.println("Goodbye!");
	}

}
