package org.example.finalexam.controller;

import org.example.finalexam.model.Book;
import org.example.finalexam.model.Student;
import org.example.finalexam.service.BookService;
import org.example.finalexam.service.IBookService;
import org.example.finalexam.service.IStudentService;
import org.example.finalexam.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IBookService iBookService;
    private IStudentService iStudentService;

    @Override
    public void init() {
        iBookService = new BookService();
        iStudentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String maSachStr = request.getParameter("maSach");

        if ("borrow".equals(action) && maSachStr != null) {
            int maSach = Integer.parseInt(maSachStr);
            Book book = iBookService.getBookById(maSach);

            if (book != null) {
                List<Student> students = iStudentService.getAllStudents();
                String nowDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

                request.setAttribute("book", book);
                request.setAttribute("students", students);
                request.setAttribute("nowDate", nowDate);

                RequestDispatcher dispatcher = request.getRequestDispatcher("borrowForm.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("message", "Sách không tồn tại.");
                List<Book> books = iBookService.getAllBooks();
                request.setAttribute("books", books);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            List<Book> books = iBookService.getAllBooks();
            request.setAttribute("books", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("processBorrow".equals(action)) {
            String maSachStr = request.getParameter("maSach");
            String studentIdStr = request.getParameter("studentId");
            String returnDateStr = request.getParameter("returnDate");

            int maSach = Integer.parseInt(maSachStr);
            int studentId = Integer.parseInt(studentIdStr);

            Book book = iBookService.getBookById(maSach);
            Student student = iStudentService.getStudentById(studentId);

            if (book != null && student != null) {
                if (book.getSoLuong() > 0) {
                    book.setSoLuong(book.getSoLuong() - 1);
                    iBookService.updateBook(book);
                    request.setAttribute("message", "Mượn sách thành công.");
                } else {
                    request.setAttribute("message", "Số lượng sách muốn mượn không hợp lệ.");
                }
            } else {
                request.setAttribute("message", "Sách hoặc học sinh không tồn tại.");
            }

            List<Book> books = iBookService.getAllBooks();
            request.setAttribute("books", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
