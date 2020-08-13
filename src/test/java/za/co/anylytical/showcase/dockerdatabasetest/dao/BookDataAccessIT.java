package za.co.anylytical.showcase.dockerdatabasetest.dao;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import za.co.anylytical.showcase.dockerdatabasetest.model.Book;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Thabo Lebogang Matjuda
 * @since: 2020-08-11
 * @email: <a href="mailto:thabo@anylytical.co.za">Anylytical Technologies</a>
 * <a href="mailto:tl.matjuda@gmail.com">Personal GMail</a>
 */

@SpringBootTest
@ActiveProfiles("integrate-the-tests")
public class BookDataAccessIT {

    @Autowired
    private BookDataAccess bookDataAccess;

    private Book lordOfTheRings_001 = new Book();

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:13");

    @BeforeEach
    public void setUp() {
        assertNotNull(bookDataAccess);
        lordOfTheRings_001.setTitle("Lord Of The Rings, Fellowship Of The Ring");
    }

    @Test
    public void assert_That_We_Can_Save_A_Book() {
        Book saved_lordOfTheRings_001 = bookDataAccess.saveAndFlush( lordOfTheRings_001);
        assertNotNull( saved_lordOfTheRings_001);
        assertNotNull( saved_lordOfTheRings_001.getId());
        assertEquals( saved_lordOfTheRings_001.getTitle(), lordOfTheRings_001.getTitle());
    }

    @Test
    public void assert_That_We_Can_Find_A_Book_ById() {
        Book saved_lordOfTheRings_001 = bookDataAccess.saveAndFlush( lordOfTheRings_001);
        assertNotNull( saved_lordOfTheRings_001.getId());

        Optional<Book> foundBookById = bookDataAccess.findById(saved_lordOfTheRings_001.getId());
        assertTrue( foundBookById.isPresent());
    }
}
