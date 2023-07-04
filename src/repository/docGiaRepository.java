package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.docGiaModel;
import viewModel.cbbMaDocGia;

public class docGiaRepository {

    public ArrayList<docGiaModel> getAllListDocGia() {
        ArrayList<docGiaModel> listDG = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT MaDocGia, HoTen, NgaySinh, GioiTinh, DiaChi,"
                    + " SDT FROM DocGia ORDER BY MaDocGia ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                docGiaModel dg = new docGiaModel();
                dg.setMaDocGia(rs.getString("MaDocGia"));
                dg.setHoTen(rs.getString("HoTen"));
                dg.setNgaySinh(rs.getString("NgaySinh"));
                dg.setGioiTinh(rs.getString("GioiTinh"));
                dg.setDiaChi(rs.getString("DiaChi"));
                dg.setSdt(rs.getString("SDT"));
                listDG.add(dg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDG;
    }

    public void insertDocGia(docGiaModel dg) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO DocGia(MaDocGia, HoTen, NgaySinh,"
                    + "GioiTinh, DiaChi, SDT) VALUES(dbo.AUTO_MaDG()"
                    + ",?, ?, ?,?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dg.getHoTen());
            ps.setString(2, dg.getNgaySinh());
            ps.setString(3, dg.getGioiTinh());
            ps.setString(4, dg.getDiaChi());
            ps.setString(5, dg.getSdt());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDocGia(docGiaModel dg, String maDocGia) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE DocGia SET HoTen = ?, NgaySinh = ?, "
                    + "GioiTinh = ?, DiaChi = ?, SDT = ? "
                    + "WHERE DocGia.MaDocGia = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dg.getHoTen());
            ps.setString(2, dg.getNgaySinh());
            ps.setString(3, dg.getGioiTinh());
            ps.setString(4, dg.getDiaChi());
            ps.setString(5, dg.getSdt());
            ps.setString(6, maDocGia);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<docGiaModel> searchDocGia(String maDocGia) {
        ArrayList<docGiaModel> listDG = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT MaDocGia, HoTen, NgaySinh, GioiTinh,"
                    + " DiaChi, SDT FROM DocGia WHERE MaDocGia LIKE ? "
                    + "ORDER BY MaDocGia ASC ";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maDocGia);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                docGiaModel dg = new docGiaModel();
                dg.setMaDocGia(rs.getString("MaDocGia"));
                dg.setHoTen(rs.getString("HoTen"));
                dg.setNgaySinh(rs.getString("NgaySinh"));
                dg.setGioiTinh(rs.getString("GioiTinh"));
                dg.setDiaChi(rs.getString("DiaChi"));
                dg.setSdt(rs.getString("SDT"));
                listDG.add(dg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDG;
    }

    public ArrayList<cbbMaDocGia> getAllMaDocGia() {
        ArrayList<cbbMaDocGia> listMaDG = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT MaDocGia, HoTen, NgaySinh, GioiTinh, DiaChi,"
                    + " SDT FROM DocGia ORDER BY MaDocGia ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                cbbMaDocGia maDG = new cbbMaDocGia();
                maDG.setMaDocGia(rs.getString("MaDocGia"));
                listMaDG.add(maDG);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMaDG;
    }

}
