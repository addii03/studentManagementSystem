package one_to_one_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one_to_one_book.exception.ResourceNotFoundException;
import one_to_one_book.helper.BookHelper;
import one_to_one_book.request.BookRequest;
import one_to_one_book.response.BookResponce;
import one_to_one_book.service.BookService;

@RestController
@RequestMapping("/api/bookone")
public class BookController {

	@Autowired
	private BookHelper bookHelper;
	@Autowired
	private BookService bookService;
	
	@PostMapping("/save")
	public ResponseEntity<BookResponce> saveBooksAndAuthor(@RequestBody BookRequest bookRequest) throws ResourceNotFoundException
	{
	 return new ResponseEntity<BookResponce>(bookService.saveBooksAndAuthor(bookRequest), HttpStatus.CREATED);
	}
}
