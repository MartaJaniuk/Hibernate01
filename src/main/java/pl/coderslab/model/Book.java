package pl.coderslab.model;

import lombok.Data;
import pl.coderslab.entity.Publisher;

@Data //wygenerowała gettery, settery
public class Book {

    private String title;
    private int rating;
    private String description;

}
