package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @GetMapping(path="/bookform")
    String showAddBookForm(Model model){
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping(path="/bookform")
    String processAddBook(Book book){
        bookService.save(book);
      //  return "book/success";
        return "redirect:/booklist";
    }

    @GetMapping(path = "/booklist")
    String showBookList(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    @ModelAttribute("publishers")
    List<Publisher> publishers(){
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    List<Author> authors(){
        return authorService.findAll();
    }
}
