package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import viewModel.phieuDenChiTietViewModel;

public class phieuDenChiTietRepository {

    public ArrayList<phieuDenChiTietViewModel> getAllListPhieuDenChiTietByMaPhieuDen(String maPhieuDen) {
        ArrayList<phieuDenChiTietViewModel> listPDCT = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PD.MaPhieuDen, PDCT.MaQuyenSach, PDCT.TenSach, PDCT.TinhTrangSach, PDCT.DoHuHao FROM PhieuDenChiTiet AS PDCT INNER JOIN PhieuDen AS PD ON PD.Id = PDCT.IdPhieuDen WHERE PD.MaPhieuDen = ? ORDER BY PDCT.MaQuyenSach ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuDen);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuDenChiTietViewModel pdct = new phieuDenChiTietViewModel();
                pdct.setMaPhieuDen(rs.getString("MaPhieuDen"));
                pdct.setMaQuyenSach(rs.getString("MaQuyenSach"));
                pdct.setTenSach(rs.getString("TenSach"));
                pdct.setTinhTrangSach(rs.getString("TinhTrangSach"));
                pdct.setDoHuHao(rs.getDouble("DoHuHao"));
                listPDCT.add(pdct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPDCT;
    }

    public void insertPhieuDenChiTiet(String maPhieuDen, String maQuyenSach, String tenSach) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO PhieuDenChiTiet(IdPhieuDen, MaQuyenSach, TenSach, TinhTrangSach, DoHuHao) VALUES((SELECT PhieuDen.ID FROM PhieuDen WHERE PhieuDen.MaPhieuDen = ?),?, ?, (SELECT PMCT.TinhTrangSach FROM PhieuMuonChiTiet AS PMCT INNER JOIN QuyenSach AS QS ON QS.Id = PMCT.IdQuyenSach WHERE QS.MaQuyenSach = ?),(SELECT PMCT.DoHuHao FROM PhieuMuonChiTiet AS PMCT INNER JOIN QuyenSach AS QS ON QS.Id = PMCT.IdQuyenSach WHERE QS.MaQuyenSach = ?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuDen);
            ps.setString(2, maQuyenSach);
            ps.setString(3, tenSach);
            ps.setString(4, maQuyenSach);
            ps.setString(5, maQuyenSach);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkTrungSach(String maPhieuDen, String maQuyenSach) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PDCT.MaQuyenSach FROM PhieuDenChiTiet AS PDCT INNER JOIN PhieuDen AS PD ON PD.Id = PDCT.IdPhieuDen WHERE PD.MaPhieuDen = ? AND PDCT.MaQuyenSach = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuDen);
            ps.setString(2, maQuyenSach);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                result = rs.getString("MaQuyenSach");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updatePhieuDenChiTiet(String doHuHao, String maQuyenSach, String maPhieuDen) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE PhieuDenChiTiet SET DoHuHao = ? WHERE PhieuDenChiTiet.MaQuyenSach = ? AND PhieuDenChiTiet.IdPhieuDen = (SELECT ID FROM PhieuDen WHERE PhieuDen.MaPhieuDen = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, doHuHao);
            ps.setString(2, maQuyenSach);
            ps.setString(3, maPhieuDen);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
