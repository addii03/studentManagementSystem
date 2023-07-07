package one_to_one_book.service;

import one_to_one_book.exception.ResourceNotFoundException;
import one_to_one_book.request.BookRequest;
import one_to_one_book.response.BookResponce;

public interface BookService {

	BookResponce saveBooksAndAuthor(BookRequest bookRequest) throws ResourceNotFoundException;
}
