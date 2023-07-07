package one_to_one_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one_to_one_book.entity.Book;
import one_to_one_book.exception.ResourceNotFoundException;
import one_to_one_book.helper.BookHelper;
import one_to_one_book.repository.BookRepository;
import one_to_one_book.request.BookRequest;
import one_to_one_book.response.BookResponce;
import one_to_one_book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private	BookRepository bookRepository;
	@Autowired
	private	BookHelper bookHelper;
	@Override
	public BookResponce saveBooksAndAuthor(BookRequest bookRequest) throws ResourceNotFoundException {
		Book book= new Book();
		if (bookRequest.getId() !=null)
		{
			book =this.bookRepository.findById(bookRequest.getId()).orElseThrow(()-> new ResourceNotFoundException("Book is Not present this id : "));
		}
		book.setId(bookRequest.getId());
		book.setTitle(bookRequest.getTitle());
		book.setAuthor(bookRequest.getAuthor());
		bookRepository.save(book);
		return bookHelper.getResponce(book);
	}
	
	
	
}
