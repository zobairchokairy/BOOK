package org.sid.book;

import org.sid.book.dao.entities.Book;
import org.sid.book.dao.repositories.BookRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class BookApplication {

	private BookRepositories bookRepositories;

	public BookApplication(BookRepositories bookRepositories) {
		this.bookRepositories = bookRepositories;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}


	@Bean
	CommandLineRunner start(){
		return args -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
			List<Book> books =List.of(

					Book.builder()
							.titre("Book1")
							.price(500.0)
							.datePublication(LocalDate.parse("4/2/2012",formatter))
							.publisher("Auteur1")
							.resume("Book 1 resume")
							.build(),

					Book.builder()
							.titre("Book2")
							.price(200.0)
							.datePublication(LocalDate.parse("4/2/2015",formatter))
							.publisher("Auteur2")
							.resume("Book 2 resume")
							.build(),

					Book.builder()
							.titre("Book3")
							.price(300.0)
							.datePublication(LocalDate.parse("4/2/2013",formatter))
							.publisher("Auteur3")
							.resume("Book 3 resume")
							.build());

				bookRepositories.saveAll(books);

		};
	}
}
