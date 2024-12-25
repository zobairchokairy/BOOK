package org.sid.book.web;
import jakarta.persistence.EntityNotFoundException;
import org.sid.book.dao.entities.Book;
import org.sid.book.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.sid.book.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookGraphQLController {

    private BookService bookService;

    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public BookDTO getBookByTitle(@Argument String title) {
        List<BookDTO> books = bookService.getBookByTitle(title);
        if (books != null && !books.isEmpty()) {
            return books.get(0);
        }
        return null; 
    }
    @MutationMapping
    public BookDTO saveBook(@Argument BookDTO bookDto) {
        return bookService.saveBook(bookDto);
    }
}