package com.universitas.book_service.service;

import com.universitas.book_service.model.Book;
import com.universitas.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<Book> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(bookDetails.getAuthor());
                    book.setTitle(bookDetails.getTitle());
                    book.setTahunTerbit(bookDetails.getTahunTerbit());
                    book.setIsbn(bookDetails.getIsbn());
                    return ResponseEntity.ok(bookRepository.save(book));
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteBook(Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
} 
