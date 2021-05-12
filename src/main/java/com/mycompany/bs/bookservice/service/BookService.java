package com.mycompany.bs.bookservice.service;

import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.mycompany.bs.bookservice.dto.BookDto;

@Service
public class BookService {
	
	private final List<BookDto> books = new ArrayList<>();
	
	public BookDto getBook(Integer bookId) {
		return books
				.stream()
				.filter(book -> bookId.equals(book.getId()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException("The book doesn't exists."));
	}
	
	public void updateBook(BookDto book) {
		for (final BookDto bookDto: books) {
			if (bookDto.getId().equals(book.getId())) {
				bookDto.setCount(bookDto.getCount() - book.getCount());
			}
		}
	}
	
	public List<BookDto> getAllBooks() {
		return books;
	}
	
	@PostConstruct
	public void setUp() {
		IntStream
			.range(1, 10)
			.forEach(i -> books.add(new BookDto(i, "title"+i, "author"+i, now(), i + 100)));
	}

}
