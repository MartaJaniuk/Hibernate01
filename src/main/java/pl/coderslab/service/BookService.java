package pl.coderslab.service;

import pl.coderslab.entity.Book;

public interface BookService {

    public void save(Book book);

    public void update(Book book);

    public Book findById(Long id);

    public void deleteById(Long id);

}
