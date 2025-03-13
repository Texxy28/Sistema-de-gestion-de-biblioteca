package com.wil.library.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(bookService.allBooks(), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Book> insertBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.newBook(book), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable ObjectId id, @RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.editBook(book, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable ObjectId id){ 
        return new ResponseEntity<String>(bookService.eraseBook(id), HttpStatus.OK);
    }

}
