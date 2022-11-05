package com.malek.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.malek.mvc.models.Book;
import com.malek.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(long x) {
    	bookRepository.deleteById(x);
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book toUpdate= findBook(id);
		toUpdate.setTitle(title);
		toUpdate.setDescription(desc);
		toUpdate.setLanguage(lang);
		toUpdate.setNumberOfPages(numOfPages);
		bookRepository.save(toUpdate);
		return null;
	}
    
}