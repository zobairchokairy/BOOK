package org.sid.book.dao.entities;

import lombok.*;
import org.sid.book.dto.BookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder @ToString
public class Book {
@Id @GeneratedValue
    private Long id_Book;
    private String titre;
    private String publisher;
    private LocalDate datePublication;
    private double price;
    private String resume;
}
