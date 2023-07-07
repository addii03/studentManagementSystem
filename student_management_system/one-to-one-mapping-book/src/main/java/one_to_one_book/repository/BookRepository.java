package one_to_one_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one_to_one_book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
