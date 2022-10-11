package koulu.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import koulu.bookstore.domain.AppUser;
import koulu.bookstore.domain.AppUserRepository;
import koulu.bookstore.domain.Book;
import koulu.bookstore.domain.BookRepository;
import koulu.bookstore.domain.Category;
import koulu.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired 
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository catRepository;
	
	@Autowired
	AppUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
			/*
			Category cat1 = new Category("Thriller");
			catRepository.save(cat1);
			Category cat2 = new Category("Novel");
			catRepository.save(cat2);
			Category cat3 = new Category("Sci-Fi");
			catRepository.save(cat3);
			Category cat4 = new Category("Classics");
			catRepository.save(cat4);
			
			bookRepository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929, 19.29, cat1));
			bookRepository.save(new Book("George Orwell", "Animal Farm", "2212343-5", 1945, 8.90, cat2));
			
			userRepository.save(new AppUser("Anssi", "Sirkiä", "admin@gmail.com", "ADMIN", "admin", "$2a$10$Xp67oEDHyODcnTzkIIp9z.SpmmpZg33mqZe/jvaSHMnpWtEQGov5e"));
			userRepository.save(new AppUser("Kari", "Käyttäjä", "user@usermail.com", "USER", "user", "$2a$10$Rc25Yhstdcr9Ce3WcQFKLeHT3nN1Yr.ud6M0AywXA8Q1tidWcdvqy"));
			*/
	}
}
