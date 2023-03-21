package book;

import java.util.Scanner;

public class Newbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname = "";
		String Isbn = "";
		double price;
		String name = "";

		Scanner scan = new Scanner(System.in);
		System.out.println("what is the name of the book");
		name = scan.nextLine();
		Book book1 = new Book(name);
		System.out.println("what is the name of the author");
		fname = scan.nextLine();
		System.out.println("what is your ISBN number");
		Isbn = scan.nextLine();
		System.out.println("what is the price of the book");
		price = scan.nextDouble();
		scan.nextLine();
		book1.setAuthor(fname);
		book1.setIsbn(Isbn);
		book1.setPrice(price);
		System.out.println("\n please enter another book\n");
		System.out.println("what is the name of the book");
		name = scan.nextLine();
		Book book2 = new Book(name);
		System.out.println("what is the name of the author");
		fname = scan.nextLine();
		System.out.println("what is your ISBN number");
		Isbn = scan.nextLine();
		System.out.println("what is the price of the book");
		price = scan.nextDouble();
		scan.nextLine();
		book2.setAuthor(fname);
		book2.setIsbn(Isbn);
		book2.setPrice(price);

		System.out.println(book1);
		System.out.println(book2);
		
		if (book1.equals(book2)) {
			System.out.println("they are the same book");
		}
		else {
			System.out.println("they are not the same book");
		}

	}
}
