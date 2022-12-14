package koulu.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 20)
	private String author;
	
	@Size(min = 1, max = 40)
	private String title;
	
	@Size(min = 1, max = 20)
	private String isbn;
	
	@Min(value = 1800, message = "Min year is 1800!")
	@Max(value = 2023, message = "Year cannot be in the future!")
	@Column(name = "book_year")
	private int bookYear;
	
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Book() {}
	
	public Book(String author, String title, String isbn, int bookYear, double price, Category category) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.bookYear = bookYear;
		this.price = price;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public int getBookYear() {
		return bookYear;
	}

	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id= " + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + bookYear + ", price=" + price
				+ "]";
	}
}
