package com.malek.mvc.controllers;

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
	public String index(@PathVariable("bookId") Long bookId, Model model)
	{
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "index.jsp";
	}
}