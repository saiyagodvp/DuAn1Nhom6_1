package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.phieuMuonChoMuon;
import viewModel.phieuMuonViewModel;

public class phieuMuonRepository {

    public ArrayList<phieuMuonViewModel> getAllListPhieuMuon() {
        ArrayList<phieuMuonViewModel> listPM = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PM.MaPhieuMuon, TTV.MaTTV, TenDocGia = "
                    + "(SELECT HoTen FROM DocGia AS DG2 INNER JOIN TheThuVien "
                    + "AS TTV2 ON TTV2.IdDocGia = DG2.Id WHERE TTV2.Id = TTV.ID)"
                    + ", DiaChi = (SELECT DiaChi FROM DocGia AS DG2 INNER JOIN "
                    + "TheThuVien AS TTV2 ON TTV2.IdDocGia = DG2.Id WHERE "
                    + "TTV2.Id = TTV.ID), PM.NgayMuon, PM.NgayHenTra, PM.GhiChu,"
                    + " PM.TienCoc  FROM PhieuMuon AS PM INNER JOIN TheThuVien"
                    + " AS TTV ON TTV.Id = PM.IdTTV order by PM.MaPhieuMuon asc";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuMuonViewModel pm = new phieuMuonViewModel();
                pm.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                pm.setMaTTV(rs.getString("MaTTV"));
                pm.setTenDocGia(rs.getString("TenDocGia"));
                pm.setDiaChi(rs.getString("DiaChi"));
                pm.setNgayMuon(rs.getString("NgayMuon"));
                pm.setNgayHenTra(rs.getString("NgayHenTra"));
                pm.setGhiChu(rs.getString("GhiChu"));
                pm.setTienCoc(rs.getDouble("TienCoc"));
                listPM.add(pm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPM;
    }

    public void insertPhieuMuonChoMuon(phieuMuonChoMuon pm) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO PhieuMuon"
                    + "(IdTTV, MaPhieuMuon, NgayMuon,NgayHenTra,GhiChu, TienCoc)"
                    + " VALUES((SELECT ID FROM TheThuVien WHERE TheThuVien."
                    + "MaTTV = ?), dbo.AUTO_MaPM(), "
                    + "?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pm.getMaTTV());
            ps.setString(2, pm.getNgayMuon());
            ps.setString(3, pm.getNgayHenTra());
            ps.setString(4, pm.getGhiChu());
            ps.setDouble(5, pm.getTienCoc());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePhieuMuonChoMuon(phieuMuonChoMuon pm, String maPM) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE PhieuMuon SET IdTTV = (SELECT TheThuVien.Id "
                    + "FROM TheThuVien WHERE TheThuVien.MaTTV = ?), NgayHenTra "
                    + "= ?, GhiChu = ?, TienCoc = ? where PhieuMuon.MaPhieuMuon = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pm.getMaTTV());
            ps.setString(2, pm.getNgayHenTra());
            ps.setString(3, pm.getGhiChu());
            ps.setDouble(4, pm.getTienCoc());
            ps.setString(5, maPM);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkMaTTV(String maTTV) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "	select MaTTV from TheThuVien where MaTTV = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTTV);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                result = rs.getString("MaTTV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deletePhieuMuonChoMuon(String maPhieuMuon) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "delete from ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuMuon);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkMaTTVConHieuLuc(String maTTV) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT TrangThai FROM TheThuVien WHERE MaTTV = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTTV);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            while (rs.next() == true) {
                result = rs.getString("TrangThai");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
