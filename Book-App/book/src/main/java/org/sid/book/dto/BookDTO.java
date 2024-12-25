package org.sid.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.book.dao.entities.Book;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private Long id_Book;
    private String titre;
    private String publisher;
    private LocalDate datePublication;
    private double price;
    private String resume;

    public Book orElseThrow(Object bookNotFound) {
        return null;
    }
}
