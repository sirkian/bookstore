package koulu.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import koulu.bookstore.web.AppUserController;
import koulu.bookstore.web.BookController;
import koulu.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	BookController bookController;
	
	@Autowired 
	CategoryController catController;
	
	@Autowired
	AppUserController userController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(catController).isNotNull();
		assertThat(userController).isNotNull();
	}


}
