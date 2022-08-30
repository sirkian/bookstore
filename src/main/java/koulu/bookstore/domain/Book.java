package koulu.bookstore.domain;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private int year;
	private double price;
	
	public Book() {
		isbn = "";
		title = "";
		author = "";
		year = 0;
		price = 0.0;
	}
	
	public Book(String isbn, String title, String author, int year, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + year + ", price=" + price
				+ "]";
	}
	
	
	
	
}
