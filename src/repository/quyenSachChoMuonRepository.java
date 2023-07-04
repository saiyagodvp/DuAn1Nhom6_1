package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.quyenSachChoMuon;

public class quyenSachChoMuonRepository {

    public void insertQuyenSachChiTietChoMuonChoMuon(quyenSachChoMuon qs) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "insert into QuyenSachChiTiet(idQuyenSach, maPhieuMuon)\n"
                    + "values((select id from QuyenSach where QuyenSach.MaQuyenSach = ?), ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, qs.getMaQuyenSach());
            ps.setString(2, qs.getMaPhieuMuon());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuyenSachChiTietChoMuonChoMuon(String MaQuyenSach) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "delete from QuyenSachChiTiet where QuyenSachChiTiet."
                    + "idQuyenSach = (select id from QuyenSach where QuyenSach.MaQuyenSach = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, MaQuyenSach);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
