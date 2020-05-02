package sachwini.springframework.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @OneToOne(cascade = CascadeType.ALL)//if Recipe is deleted, its notes will be deleted as well
    private Notes notes;

    //relationship n a recipe object owns ingredients
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();//better to initialize it to avoid NullPointerException

    @Lob
    private Byte[] image;

    //annotate to tell this attribute is enum. EnumType tells String value into Table (vs Ordinal which use number)
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}