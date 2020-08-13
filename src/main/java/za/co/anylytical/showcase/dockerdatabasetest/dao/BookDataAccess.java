package za.co.anylytical.showcase.dockerdatabasetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.anylytical.showcase.dockerdatabasetest.model.Book;

/**
 * @author: Thabo Lebogang Matjuda
 * @since: 2020-08-11
 * @email: <a href="mailto:thabo@anylytical.co.za">Anylytical Technologies</a>
 * <a href="mailto:tl.matjuda@gmail.com">Personal GMail</a>
 */

@Repository
public interface BookDataAccess extends JpaRepository<Book, Long> {}
