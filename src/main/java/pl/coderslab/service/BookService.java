package pl.coderslab.service;

import pl.coderslab.entity.Book;

import java.util.List;

public interface BookService {

    public void save(Book book);

    public void update(Book book);

    public Book findById(Long id);

    public List<Book> findAll();

    public void deleteById(Long id);

}
