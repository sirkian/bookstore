package koulu.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import koulu.bookstore.domain.Book;
import koulu.bookstore.domain.BookRepository;
import koulu.bookstore.domain.Category;
import koulu.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Category cat1 = new Category("Thriller");
			crepository.save(cat1);
			Category cat2 = new Category("Novel");
			crepository.save(cat2);
			Category cat3 = new Category("Sci-Fi");
			crepository.save(cat3);
			Category cat4 = new Category("Classics");
			crepository.save(cat4);
			
			log.info("save a couple of books");
			
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929, 19.29, cat1));
			repository.save(new Book("George Orwell", "Animal Farm", "2212343-5", 1945, 8.90, cat2));
			
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
