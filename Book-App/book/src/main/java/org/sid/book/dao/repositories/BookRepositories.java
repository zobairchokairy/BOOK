package org.sid.book.dao.repositories;

import org.sid.book.dao.entities.Book;
import org.sid.book.dto.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepositories extends JpaRepository<Book, Long> {
    List<Book> findByTitreContaining(String title);
}
