package pl.coderslab.service.impl;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public BookServiceImpl(BookDao bookDao, PublisherService publisherService, AuthorService authorService) {
        this.bookDao = bookDao;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public void save(Book book) {
//        final Publisher publisher = book.getPublisher();
//        publisherService.save(publisher);
//
//        List<Author> authors = new ArrayList<>();
//        authors.add(authorService.findById(1L));
//        authors.add(authorService.findById(2L));
//        book.setAuthors(authors);

        bookDao.save(book);
    }

    @Override
    public void save(pl.coderslab.model.Book book){
        Book bookEntity = new Book();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setRating(book.getRating());



        bookDao.save(bookEntity);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public Book findById(Long id) {
        Book book = bookDao.findById(id);
        //poniżej, żeby w zaciągało się w formularzu do edycji przy lazy
        Hibernate.initialize(book.getPublisher());
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    @Override
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByRating(int rating) {
        return bookDao.findByRating(rating);
    }

    @Override
    public List<Book> findNotEmptyPublisher(){
        return bookDao.findNotEmptyPublisher();
    }

    @Override
    public List<Book> findByPublisher(Publisher publisher){
        return bookDao.findByPublisher(publisher);
    }
    @Override
    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return null;
    }

    @Override
    public List<Book> findByCategoryId(Long id) {
        return null;
    }

}
