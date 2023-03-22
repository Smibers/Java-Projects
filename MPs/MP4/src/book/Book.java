package book;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.*;
public class Book {
	private String author;
	private String isbn;
	private double price;
	private String name;
	public static LocalDate localdate = LocalDate.of(2022, 11, 3);
	public Book(String name) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor( String name) {
		this.author = name + ", birthday: " + localdate ;
	}

//	public void setAuthor(String author) {
//		this.author = author;
//	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [ name=" + name +", author=" + author + ", isbn=" + isbn + ", price=" + price +  "]";
	}

	public boolean equal (Book bookother) {
		return name.equals(bookother.name) && author.equals(bookother.author)&& isbn.equals(bookother.isbn)&& price==(bookother.price);
	}
	
	
	
}
