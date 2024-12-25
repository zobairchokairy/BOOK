package org.sid.book.service;

import org.sid.book.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBookByTitle(String title);
    BookDTO saveBook(BookDTO bookDto);
}
