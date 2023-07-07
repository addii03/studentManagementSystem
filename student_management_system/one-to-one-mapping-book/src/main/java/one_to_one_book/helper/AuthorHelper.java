package one_to_one_book.helper;

import org.springframework.stereotype.Component;

import one_to_one_book.entity.Author;
import one_to_one_book.request.AuthorRequest;
import one_to_one_book.response.AuthorResponce;

@Component
public class AuthorHelper {

	public Author getRequest (AuthorRequest authorRequest)
	{
		Author author= new Author();
		author.setAuthorId(authorRequest.getAuthorId());
		author.setFirstName(authorRequest.getFirstName());
		author.setLastName(authorRequest.getLastName());
		author.setLanguage(authorRequest.getLanguage());
		return author;
	}
	
	public AuthorResponce getResponce(Author author)
	{
		AuthorResponce authorResponce= new AuthorResponce();
		authorResponce.setAuthorId(author.getAuthorId());
		authorResponce.setFirstName(author.getFirstName());
		authorResponce.setLastName(author.getLastName());
		authorResponce.setLanguage(author.getLanguage());
		return authorResponce;
	}
}
