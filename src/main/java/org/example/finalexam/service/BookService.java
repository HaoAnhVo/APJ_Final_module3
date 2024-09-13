package org.example.finalexam.service;

import org.example.finalexam.model.Book;
import org.example.finalexam.model.BookLoan;
import org.example.finalexam.repository.BookRepository;
import org.example.finalexam.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService {
    IBookRepository iBookRepository = new BookRepository();

    @Override
    public List<Book> getAllBooks() {
        return iBookRepository.getAllBooks();
    }

    @Override
    public Book getBookById(int maSach) {
        return iBookRepository.getBookById(maSach);
    }

    @Override
    public void updateBook(Book book) {
        iBookRepository.updateBook(book);
    }

    @Override
    public List<BookLoan> getAllBooksOnLoan() {
        return iBookRepository.getAllBooksOnLoan();
    }

    @Override
    public List<BookLoan> getAllReturnedBooks() {
        return iBookRepository.getAllReturnedBooks();
    }
}
