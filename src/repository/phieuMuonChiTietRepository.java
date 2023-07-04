package repository;

import viewModel.phieuMuonChiTietViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.phieuMuonChiTietChoMuon;

public class phieuMuonChiTietRepository {

    public ArrayList<phieuMuonChiTietViewModel> getAllListPhieuMuonChiTiet(String maPhieuMuon) {
        ArrayList<phieuMuonChiTietViewModel> listPMCT = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PM.MaPhieuMuon, QS.MaQuyenSach, "
                    + "PMCT.TenSach,QS.TinhTrangSach, PMCT.DoHuHao"
                    + " FROM PhieuMuonChiTiet AS PMCT INNER JOIN PhieuMuon"
                    + " AS PM ON PM.ID = PMCT.IdPhieuMuon INNER  JOIN "
                    + "QuyenSach AS QS ON PMCT.IdQuyenSach =  QS.Id WHERE "
                    + "PM.MaPhieuMuon = ? order by QS.MaQuyenSach asc";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuMuon);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuMuonChiTietViewModel pm = new phieuMuonChiTietViewModel();
                pm.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                pm.setMaQuyenSach(rs.getString("MaQuyenSach"));
                pm.setTenSach(rs.getString("TenSach"));
                pm.setTinhTrangSach(rs.getBoolean("TinhTrangSach"));
                pm.setDoHuHao(rs.getDouble("DoHuHao"));
                listPMCT.add(pm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPMCT;
    }

    public void insertPhieuMuonChiTietChoMuonChoMuon(phieuMuonChiTietChoMuon pm) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "insert into PhieuMuonChiTiet(IdPhieuMuon, \n"
                    + "IdQuyenSach, MaPhieuMuon, MaSach, TenSach,\n"
                    + "TinhTrangSach, DoHuHao)\n"
                    + "values((select id from PhieuMuon where\n"
                    + "PhieuMuon.MaPhieuMuon = ?),\n"
                    + "(select QuyenSach.Id from QuyenSach WHERE \n"
                    + "QuyenSach.MaISBN = ?), ? ,\n"
                    + "(SELECT QS.MaQuyenSach FROM QuyenSach AS QS WHERE QS.MaISBN = ?) ,\n"
                    + "(select DS.TenSach from DauSach AS DS INNER JOIN\n"
                    + "QuyenSach AS QS ON QS.IdDauSach = DS.Id WHERE\n"
                    + "QS.MaISBN = ?),  \n"
                    + "(select QS.TinhTrangSach FROM QuyenSach AS QS \n"
                    + "WHERE QS.MaISBN = ?),\n"
                    + "(select QS.DoHuHao FROM QuyenSach AS QS WHERE \n"
                    + "QS.MaISBN = ?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pm.getMaPhieuMuon());
            ps.setString(2, pm.getMaISBN());
            ps.setString(3, pm.getMaPhieuMuon());
            ps.setString(4, pm.getMaISBN());
            ps.setString(5, pm.getMaISBN());
            ps.setString(6, pm.getMaISBN());
            ps.setString(7, pm.getMaISBN());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkTrungSach(String maISBN) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "select TrangThai from QuyenSach AS QS WHERE QS.MaISBN = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
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

    public String checkMaISBN(String maISBN) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "select QuyenSach.MaISBN from QuyenSach where QuyenSach.MaISBN = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
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

    public String checkMaISBNGetMaQuyenSach(String maISBN) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "select QuyenSach.MaQuyenSach from QuyenSach where QuyenSach.MaISBN = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
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

    public void deletePhieuMuonChiTietChoMuonChoMuon(String maISBN) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "DELETE FROM PhieuMuonChiTiet  WHERE"
                    + " PhieuMuonChiTiet.IdQuyenSach = (SELECT QS.Id "
                    + " FROM QuyenSach as QS  WHERE QS.MaISBN = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDaMuonPhieuMuonChiTietChoMuonChoMuon(String maISBN) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "update QuyenSach set TrangThai = 1 WHERE QuyenSach.MaISBN = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateChuaMuonPhieuMuonChiTietChoMuonChoMuon(String MaQuyenSach) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "update QuyenSach set TrangThai = 0 WHERE QuyenSach.MaQuyenSach = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, MaQuyenSach);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSoLuongDaChoMuon(String maISBN) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE DauSach SET SoLuong = SOLUONG - 1 WHERE "
                    + "DauSach.Id = (SELECT IdDauSach FROM QuyenSach WHERE "
                    + "QuyenSach.MaISBN = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSoLuongChuaChoMuon(String maQuyenSach) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE DauSach SET SoLuong = SOLUONG + 1 WHERE "
                    + "DauSach.Id = (SELECT IdDauSach FROM QuyenSach WHERE "
                    + "QuyenSach.MaQuyenSach = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maQuyenSach);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getMaISBNByMaQuyenSach(String maQuyenSach) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT QS.MaISBN FROM QuyenSach "
                    + "AS QS WHERE QS.MaQuyenSach = ?";

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
