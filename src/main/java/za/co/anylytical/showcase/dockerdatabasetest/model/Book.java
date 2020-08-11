package za.co.anylytical.showcase.dockerdatabasetest.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Thabo Lebogang Matjuda
 * @since: 2020-08-11
 * @email: <a href="mailto:thabo@anylytical.co.za">Anylytical Technologies</a>
 * <a href="mailto:tl.matjuda@gmail.com">Personal GMail</a>
 */

@Entity
@Table( name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator( name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column( name = "book_title", nullable = false)
    private String title;

}
