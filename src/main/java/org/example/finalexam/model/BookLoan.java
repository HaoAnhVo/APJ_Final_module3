package org.example.finalexam.model;

import java.util.Date;

public class BookLoan {
    private int maMuonSach;
    private int maSach;
    private int maHocSinh;
    private String tenSach;
    private String hoTen;
    private Date ngayMuon;
    private Date ngayTra;
    private String trangThai;

    public BookLoan(int maMuonSach, int maSach, int maHocSinh, String tenSach, String hoTen, Date ngayMuon, Date ngayTra, String trangThai) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHocSinh = maHocSinh;
        this.tenSach = tenSach;
        this.hoTen = hoTen;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public int getMaMuonSach() { return maMuonSach; }
    public void setMaMuonSach(int maMuonSach) { this.maMuonSach = maMuonSach; }
    public int getMaSach() { return maSach; }
    public void setMaSach(int maSach) { this.maSach = maSach; }
    public int getMaHocSinh() { return maHocSinh; }
    public void setMaHocSinh(int maHocSinh) { this.maHocSinh = maHocSinh; }
    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public Date getNgayMuon() { return ngayMuon; }
    public void setNgayMuon(Date ngayMuon) { this.ngayMuon = ngayMuon; }
    public Date getNgayTra() { return ngayTra; }
    public void setNgayTra(Date ngayTra) { this.ngayTra = ngayTra; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}
