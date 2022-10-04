package koulu.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import koulu.bookstore.domain.AppUser;
import koulu.bookstore.domain.AppUserRepository;
import koulu.bookstore.domain.Book;
import koulu.bookstore.domain.BookRepository;
import koulu.bookstore.domain.Category;
import koulu.bookstore.domain.CategoryRepository;

@DataJpaTest
class RepositoryTests {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository catRepository;
	
	@Autowired
	AppUserRepository userRepository;
	
	@Test
	public void findBookByAuthor() {
		List<Book> books = bookRepository.findByAuthor("George Orwell");
		assertEquals(books.size(), 1);
	}
	
	@Test
	public void findCategoryByBookId() {
		Category cat = bookRepository.findById((long) 5).get().getCategory();
		assertEquals(cat.getCategoryname(), "Thriller");
	}
	
    @Test
    public void findBookByTitle() {
        List<Book> books = bookRepository.findByTitle("A Farewell to Arms"); 
        assertThat(books).hasSize(1);
        assertEquals(books.get(0).getTitle(), ("A Farewell to Arms"));
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Test Author", "Junit tests for Dummies", "001101010-11", 2022, 42.0, new Category("Educational"));
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test
    public void deleteBook() {
		List<Book> books = bookRepository.findByTitle("Animal Farm");
		Book book = books.get(0);
		bookRepository.delete(book);
		List<Book> newBooks = bookRepository.findByTitle("Animal Farm");
		assertEquals(newBooks.size(), 0);
     }
    
    @Test
    public void createNewUser() {
    	AppUser user = new AppUser("Testi", "Käyttäjä", "test@usermail.com", "USER", "testuser", "$2a$10$Rc25Yhstdcr9Ce3WcQFKLeHT3nN1Yr.ud6M0AywXA8Q1tidWcdvqy");
    	userRepository.save(user);
    	assertThat(user.getUserid()).isNotNull();
    }
    
    @Test
    public void findUserbyUsername() {
        AppUser user = userRepository.findByUsername("user"); 
        assertEquals(user.getUsername(), "user");
    }
}
