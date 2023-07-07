package one_to_one_book.helper;



import org.springframework.stereotype.Component;

import one_to_one_book.entity.Book;
import one_to_one_book.request.BookRequest;
import one_to_one_book.response.BookResponce;



@Component
public class BookHelper {

	public Book getRequest(BookRequest bookRequest)
	{
		Book book= new Book();
		book.setId(bookRequest.getId());
		book.setTitle(bookRequest.getTitle());
		book.setAuthor(bookRequest.getAuthor());
		return book;
		
	}
	public BookResponce getResponce(Book book)
	{
		BookResponce bookResponce= new BookResponce();
		bookResponce.setId(book.getId());
		bookResponce.setTitle(book.getTitle());
		bookResponce.setAuthor(book.getAuthor());
		return bookResponce;
	}
}
