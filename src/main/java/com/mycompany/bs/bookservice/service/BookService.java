package com.mycompany.bs.bookservice.service;

import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.mycompany.bs.bookservice.dto.BookDto;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Service
public class BookService {
	
	private final List<BookDto> books = new ArrayList<>();
	
	public BookDto getBook(Integer bookId) {
		log.info("Getting book with bookid: " + bookId);
		return books
				.stream()
				.filter(book -> bookId.equals(book.getId()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException("The book doesn't exists."));
	}
	
	public void updateBook(BookDto book) {
		log.info("update book: " + book);
		for (final BookDto bookDto: books) {
			if (bookDto.getId().equals(book.getId())) {
				bookDto.setCount(bookDto.getCount() - book.getCount());
			}
		}
	}
	
	public List<BookDto> getAllBooks() {
		log.info("Getting all books: " + books);
		return books;
	}
	
	@PostConstruct
	public void setUp() {
		IntStream
			.range(1, 10)
			.forEach(i -> books.add(new BookDto(i, "title"+i, "author"+i, now(), i + 100)));
		log.info("initial Books setup: " + books);
	}

}
