package org.example.finalexam.controller;

import org.example.finalexam.model.BookLoan;
import org.example.finalexam.service.BookService;
import org.example.finalexam.service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookLoanServlet")
public class BookLoanServlet extends HttpServlet {
    private IBookService iBookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        List<BookLoan> bookLoans;

        if ("returned".equals(status)) {
            bookLoans = iBookService.getAllReturnedBooks();
        } else {
            bookLoans = iBookService.getAllBooksOnLoan();
        }

        request.setAttribute("bookLoans", bookLoans);
        request.setAttribute("status", status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookLoanList.jsp");
        dispatcher.forward(request, response);
    }
}
