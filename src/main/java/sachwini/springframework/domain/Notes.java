package sachwini.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne//no cascade type because if notes is deleted, Recipe would not be deleted.
    private Recipe recipe;

    @Lob//large object, use when more than 250 characters of String is expected
    private String recipeNotes;


}
