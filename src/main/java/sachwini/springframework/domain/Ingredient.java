package sachwini.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne//no cascade
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)//no cascade to affect UnitOfMeasure
    private UnitOfMeasure uom;

    public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom,
                      Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}
