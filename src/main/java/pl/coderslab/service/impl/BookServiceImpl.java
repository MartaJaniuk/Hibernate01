package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }

}
