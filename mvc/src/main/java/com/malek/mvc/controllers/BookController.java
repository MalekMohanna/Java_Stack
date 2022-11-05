package com.malek.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malek.mvc.models.Book;
import com.malek.mvc.services.BookService;

@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
	
	@RequestMapping("/books/{bookId}")
	public String book(@PathVariable("bookId") Long bookId, Model model)
	{
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "book.jsp";
	}
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
}