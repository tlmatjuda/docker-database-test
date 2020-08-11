package za.co.anylytical.showcase.dockerdatabasetest.dao;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import za.co.anylytical.showcase.dockerdatabasetest.model.Book;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("integrate-the-tests")
public class BookDAOTest {

    @Autowired
    private BookDAO bookDAO;

    private Book lordOfTheRings_001 = new Book();

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:13");

    @BeforeEach
    public void setUp() {
        assertNotNull( bookDAO);
        lordOfTheRings_001.setTitle("Lord Of The Rings, Fellowship Of The Ring");
    }

    @Test
    void assert_That_We_Can_Save_A_Book() {
        Book saved_lordOfTheRings_001 = bookDAO.saveAndFlush(lordOfTheRings_001);
        assertNotNull( saved_lordOfTheRings_001);
        assertNotNull( saved_lordOfTheRings_001.getId());
    }
}
