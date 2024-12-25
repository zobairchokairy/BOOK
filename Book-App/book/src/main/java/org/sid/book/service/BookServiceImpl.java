package org.sid.book.service;

import org.sid.book.dao.entities.Book;
import org.sid.book.dao.repositories.BookRepositories;
import org.sid.book.dto.BookDTO;
import org.sid.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepositories bookRepository;
    private BookMapper bookMapper;

    BookServiceImpl(BookRepositories bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> getBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitreContaining(title);
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookDTO saveBook(BookDTO bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }
}
