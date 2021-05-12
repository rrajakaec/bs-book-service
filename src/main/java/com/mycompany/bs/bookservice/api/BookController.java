package com.mycompany.bs.bookservice.api;

import static org.springframework.http.HttpStatus.OK;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.bs.bookservice.dto.BookDto;
import com.mycompany.bs.bookservice.service.BookService;

@Controller
@RequestMapping("/api")
public class BookController {
	
	@Resource
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAllBooks(), OK);
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<BookDto> getBook(@PathVariable Integer bookId) {
		return new ResponseEntity<>(bookService.getBook(bookId), OK);
	}
	
	@PutMapping("/books")
	public ResponseEntity<Void> updateBook(@RequestBody BookDto book) {
		bookService.updateBook(book);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
