package org.example.finalexam.repository;

import org.example.finalexam.model.Book;
import org.example.finalexam.model.BookLoan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT maSach, tenSach, tacGia, soLuong, moTa FROM Sach";

        try (Connection con = BaseRepository.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int maSach = rs.getInt("maSach");
                String tenSach = rs.getString("tenSach");
                String tacGia = rs.getString("tacGia");
                int soLuong = rs.getInt("soLuong");
                String moTa = rs.getString("moTa");

                Book book = new Book(maSach, tenSach, tacGia, soLuong, moTa);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookById(int maSach) {
        Book book = null;
        String query = "SELECT maSach, tenSach, tacGia, soLuong, moTa FROM Sach WHERE maSach = ?";

        try (Connection con = BaseRepository.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, maSach);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String tenSach = rs.getString("tenSach");
                    String tacGia = rs.getString("tacGia");
                    int soLuong = rs.getInt("soLuong");
                    String moTa = rs.getString("moTa");
                    book = new Book(maSach, tenSach, tacGia, soLuong, moTa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void updateBook(Book book) {
        String query = "UPDATE Sach SET soLuong = ? WHERE maSach = ?";

        try (Connection con = BaseRepository.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, book.getSoLuong());
            ps.setInt(2, book.getMaSach());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookLoan> getAllBooksOnLoan() {
        List<BookLoan> bookLoans = new ArrayList<>();
        String query = "SELECT t.maMuonSach, t.maSach, t.maHocSinh, t.ngayMuon, t.ngayTra, s.tenSach, h.hoTen " +
                "FROM TheMuonSach t " +
                "JOIN Sach s ON t.maSach = s.maSach " +
                "JOIN HocSinh h ON t.maHocSinh = h.maHocSinh " +
                "WHERE t.trangThai = 1";

        try (Connection con = BaseRepository.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int maMuonSach = rs.getInt("maMuonSach");
                int maSach = rs.getInt("maSach");
                int maHocSinh = rs.getInt("maHocSinh");
                Date ngayMuon = rs.getDate("ngayMuon");
                Date ngayTra = rs.getDate("ngayTra");
                String tenSach = rs.getString("tenSach");
                String hoTen = rs.getString("hoTen");

                BookLoan bookLoan = new BookLoan(maMuonSach, maSach, maHocSinh, tenSach, hoTen, ngayMuon, ngayTra, "Đang mượn");
                bookLoans.add(bookLoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookLoans;
    }

    @Override
    public List<BookLoan> getAllReturnedBooks() {
        List<BookLoan> bookLoans = new ArrayList<>();
        String query = "SELECT t.maMuonSach, t.maSach, t.maHocSinh, t.ngayMuon, t.ngayTra, s.tenSach, h.hoTen " +
                "FROM TheMuonSach t " +
                "JOIN Sach s ON t.maSach = s.maSach " +
                "JOIN HocSinh h ON t.maHocSinh = h.maHocSinh " +
                "WHERE t.trangThai = 0";

        try (Connection con = BaseRepository.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int maMuonSach = rs.getInt("maMuonSach");
                int maSach = rs.getInt("maSach");
                int maHocSinh = rs.getInt("maHocSinh");
                Date ngayMuon = rs.getDate("ngayMuon");
                Date ngayTra = rs.getDate("ngayTra");
                String tenSach = rs.getString("tenSach");
                String hoTen = rs.getString("hoTen");

                BookLoan bookLoan = new BookLoan(maMuonSach, maSach, maHocSinh, tenSach, hoTen, ngayMuon, ngayTra, "Đã trả");
                bookLoans.add(bookLoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookLoans;
    }
}
