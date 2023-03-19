package pl.coderslab.model;

import lombok.Data;

@Data //wygenerowała gettery, settery
public class Book {

    private String title;
    private int rating;
    private String description;

    private Publisher publisher;

}
