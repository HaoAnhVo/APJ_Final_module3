package org.example.finalexam.service;

import org.example.finalexam.model.Book;
import org.example.finalexam.model.BookLoan;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();
    public Book getBookById(int maSach);
    public void updateBook(Book book);
    public List<BookLoan> getAllBooksOnLoan();
    public List<BookLoan> getAllReturnedBooks();
}
