package pl.coderslab.service;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

public interface AuthorService {
    public void save(Author author);

    public void update(Author author);

    public Author findById(Long id);

    public void deleteById(Long id);
}
