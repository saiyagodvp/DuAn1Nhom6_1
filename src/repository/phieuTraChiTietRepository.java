package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import viewModel.phieuTraChiTietTraSachViewModel;

public class phieuTraChiTietRepository {

    public ArrayList<phieuTraChiTietTraSachViewModel> getAllListPhieuTraChiTiet(String maPhieuTra) {
        ArrayList<phieuTraChiTietTraSachViewModel> listPTCT = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PT.MaPhieuTra, QS.MaQuyenSach, PTCT.TenSach, PTCT.TinhTrangSach, PTCT.DoHuHao FROM PhieuTraChiTiet AS PTCT INNER JOIN PhieuTra AS PT ON PT.Id = PTCT.IdPhieuTra INNER JOIN QuyenSach AS QS ON QS.Id = PTCT.IdQuyenSach WHERE PT.MaPhieuTra = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuTra);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuTraChiTietTraSachViewModel pt = new phieuTraChiTietTraSachViewModel();
                pt.setMaPhieuTra(rs.getString("MaPhieuTra"));
                pt.setMaQuyenSach(rs.getString("MaQuyenSach"));
                pt.setTenSach(rs.getString("TenSach"));
                pt.setTinhTrangSach(rs.getString("TinhTrangSach"));
                pt.setDoHuHao(rs.getDouble("DoHuHao"));
                listPTCT.add(pt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPTCT;
    }

    public void insertPhieuTraChiTiet(String maPhieuTra, String maQuyenSach, String tenSach, String tinhTrangSach, String doHuHao) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO PhieuTraChiTiet(IdPhieuTra,IdQuyenSach,MaSach,TenSach,TinhTrangSach, DoHuHao)VALUES((SELECT PT.Id FROM PhieuTra AS PT WHERE PT.MaPhieuTra = ?),(SELECT ID FROM QuyenSach WHERE QuyenSach.MaQuyenSach = ?),?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuTra);
            ps.setString(2, maQuyenSach);
            ps.setString(3, maQuyenSach);
            ps.setString(4, tenSach);
            ps.setString(5, tinhTrangSach);
            ps.setString(6, doHuHao);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePhieuTraChiTiet(double doHuHao, String maPhieuTra, String maQuyenSach) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE PhieuTraChiTiet SET DoHuHao = ? WHERE PhieuTraChiTiet.IdPhieuTra = (SELECT ID FROM PhieuTra WHERE PhieuTra.MaPhieuTra = ?) AND PhieuTraChiTiet.IdQuyenSach = (SELECT ID FROM QuyenSach WHERE QuyenSach.MaQuyenSach = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, doHuHao);
            ps.setString(2, maPhieuTra);
            ps.setString(3, maQuyenSach);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuyenSachByPhieuTraChiTiet(double doHuHao, String maQuyenSach) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE QuyenSach SET DoHuHao = ? WHERE QuyenSach.MaQuyenSach = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(2, doHuHao);
            ps.setString(1, maQuyenSach);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkMaISBN(String maISBN, String maPhieuTra) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PTCT.IdQuyenSach FROM PhieuTraChiTiet AS "
                    + "PTCT INNER JOIN QuyenSach AS QS ON QS.Id ="
                    + " PTCT.IdQuyenSach WHERE QS.MaISBN = ? AND PTCT.IdPhieuTra"
                    + " = (SELECT PT.ID FROM PhieuTra AS PT WHERE PT.MaPhieuTra = ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
            ps.setString(2, maPhieuTra);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                result = rs.getString("IdQuyenSach");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getMaISBN(String maQuyenSach) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT QuyenSach.MaISBN FROM QuyenSach WHERE QuyenSach.MaQuyenSach = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maQuyenSach);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                result = rs.getString("MaISBN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
