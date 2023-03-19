package pl.coderslab.controller;


import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;

import java.util.List;
import java.util.Objects;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //create book
    @PostMapping(path="/book")
    void save (@RequestParam String title, @RequestParam int rating, @RequestParam String description, @RequestParam String publisherName){
        final Book book = new Book();

        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        Publisher publisher = new Publisher();
        publisher.setName(publisherName);

        book.setPublisher(publisher);



        bookService.save(book);
    }


    //edycja
    @PutMapping(path="book/{id}")
    public void update(@PathVariable Long id, @RequestParam String title, @RequestParam int rating, @RequestParam String description){
        Book book = bookService.findById(id);

        if(Objects.nonNull(book)){
            book.setTitle(title);
            book.setDescription(description);
            book.setRating(rating);
            bookService.update(book);
        }
    }

    //get book by id
    @GetMapping(path="/book/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        final Book book = bookService.findById(id);
        return Objects.nonNull(book) ? book.toString() : "Nie znaleziono książki o podanym id " + id;
    }

    //find all
    @GetMapping(path="/books", produces = "text/plain;charset=utf-8")
    String findAll(){
        final List<Book> books= bookService.findAll();
        return books.toString();
    }


    //delete book by id
    @DeleteMapping(path="book/{id}")
    void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }


}
