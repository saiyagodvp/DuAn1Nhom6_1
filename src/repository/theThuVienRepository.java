package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import viewModel.theThuVienViewModel;

public class theThuVienRepository {

    public ArrayList<theThuVienViewModel> getAllListTTV() {
        ArrayList<theThuVienViewModel> listTTV = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT TheThuVien.MaTTV, DocGia.MaDocGia,"
                    + " DocGia.HoTen, TheThuVien.NgayCap, TheThuVien"
                    + ".NgayHetHan, TheThuVien.GhiChu, TheThuVien.TrangThai"
                    + " FROM TheThuVien INNER JOIN DocGia ON DocGia.Id = "
                    + "TheThuVien.IdDocGia  WHERE TheThuVien.TrangThai = 1 ORDER BY TheThuVien.MaTTV ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                theThuVienViewModel ttv = new theThuVienViewModel();
                ttv.setMaTTV(rs.getString("MaTTV"));
                ttv.setMaDocGia(rs.getString("MaDocGia"));
                ttv.setHoTen(rs.getString("HoTen"));
                ttv.setNgayCap(rs.getString("NgayCap"));
                ttv.setNgayHetHan(rs.getString("NgayHetHan"));
                ttv.setGhiChu(rs.getString("GhiChu"));
                ttv.setTrangThai(rs.getInt("TrangThai"));
                listTTV.add(ttv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTTV;
    }

    public void insertTheThuVien(String maDocGia, String ngayCap, String ngayHetHan, String ghiChu) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO TheThuVien(IdDocGia, MaTTV, NgayCap,"
                    + " NgayHetHan, GhiChu, TrangThai) VALUES((SELECT ID FROM"
                    + " DocGia WHERE DocGia.MaDocGia = ?),dbo.AUTO_MaHD(), "
                    + "?, ?, ?, 1)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maDocGia);
            ps.setString(2, ngayCap);
            ps.setString(3, ngayHetHan);
            ps.setString(4, ghiChu);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upadateTheThuVien(String maTheThuVien) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE TheThuVien SET TrangThai = 0 WHERE TheThuVien.MaTTV = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTheThuVien);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
