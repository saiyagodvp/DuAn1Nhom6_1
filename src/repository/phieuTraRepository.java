package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import viewModel.phieuMuonInTraSach;
import viewModel.phieuTraViewModel;

public class phieuTraRepository {

    public ArrayList<phieuTraViewModel> getAllListPhieuTra() {
        ArrayList<phieuTraViewModel> listPT = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PT.MaPhieuTra, PM.MaPhieuMuon, PT.TenDocGia,"
                    + " PT.DiaChiDocGia, PT.NgayMuon, PT.NgayHenTra, PT.NgayTra,"
                    + " PT.GhiChu FROM PhieuTra AS PT INNER JOIN PhieuMuon AS "
                    + "PM ON PM.Id = PT.IDPhieuMuon ORDER BY PT.MaPhieuTra ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuTraViewModel pm = new phieuTraViewModel();
                pm.setMaPhieuTra(rs.getString("MaPhieuTra"));
                pm.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                pm.setTenDocGia(rs.getString("TenDocGia"));
                pm.setDiaChiDocGia(rs.getString("DiaChiDocGia"));
                pm.setNgayMuon(rs.getString("NgayMuon"));
                pm.setNgayHenTra(rs.getString("NgayHenTra"));
                pm.setNgayTra(rs.getString("NgayTra"));
                pm.setGhiChu(rs.getString("GhiChu"));
                listPT.add(pm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPT;
    }

    public ArrayList<phieuMuonInTraSach> searchPhieuMuonByMaTTV(String maTTV) {
        ArrayList<phieuMuonInTraSach> listPM = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PhieuMuon.MaPhieuMuon, TheThuVien.MaTTV, TenNguoiMuon = (SELECT DocGia.HoTen FROM DocGia WHERE DocGia.Id = TheThuVien.IdDocGia), PhieuMuon.NgayMuon, PhieuMuon.NgayHenTra, PhieuMuon.GhiChu FROM PhieuMuon INNER JOIN TheThuVien ON TheThuVien.Id = PhieuMuon.IdTTV	WHERE PhieuMuon.IdTTV = (SELECT ID FROM TheThuVien WHERE TheThuVien.MaTTV = ? ) ORDER BY PhieuMuon.MaPhieuMuon ASC";

            System.out.println(maTTV);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTTV);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuMuonInTraSach pm = new phieuMuonInTraSach();
                pm.setMaPM(rs.getString("MaPhieuMuon"));
                pm.setMaTTV(rs.getString("MaTTV"));
                pm.setTenNguoiMuon(rs.getString("TenNguoiMuon"));
                pm.setNgayMuon(rs.getString("NgayMuon"));
                pm.setNgayHenTra(rs.getString("NgayHenTra"));
                pm.setGhiChu(rs.getString("GhiChu"));
                listPM.add(pm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPM;
    }

    public void insertPhieuTraTraSach(String maPM, String ngayTra, String ghiChu) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO PhieuTra(IDPhieuMuon,MaPhieuTra, TenDocGia, DiaChiDocGia,\n"
                    + "NgayMuon,NgayHenTra,NgayTra,GhiChu)\n"
                    + "VALUES(\n"
                    + "(SELECT ID FROM PhieuMuon WHERE PhieuMuon.MaPhieuMuon = ?),\n"
                    + "dbo.AUTO_MaPT(),\n"
                    + "(SELECT DG.HoTen FROM DocGia AS DG INNER JOIN TheThuVien AS TTV ON TTV.IdDocGia = DG.Id INNER JOIN PhieuMuon AS PM ON PM.IdTTV = TTV.Id WHERE PM.MaPhieuMuon = ?),\n"
                    + "(SELECT DG.DiaChi FROM DocGia AS DG INNER JOIN TheThuVien AS TTV ON TTV.IdDocGia = DG.Id INNER JOIN PhieuMuon AS PM ON PM.IdTTV = TTV.Id WHERE PM.MaPhieuMuon = ?),\n"
                    + "(SELECT PM.NgayMuon FROM DocGia AS DG INNER JOIN TheThuVien AS TTV ON TTV.IdDocGia = DG.Id INNER JOIN PhieuMuon AS PM ON PM.IdTTV = TTV.Id WHERE PM.MaPhieuMuon = ?),\n"
                    + "(SELECT PM.NgayHenTra FROM DocGia AS DG INNER JOIN TheThuVien AS TTV ON TTV.IdDocGia = DG.Id INNER JOIN PhieuMuon AS PM ON PM.IdTTV = TTV.Id WHERE PM.MaPhieuMuon = ?),\n"
                    + "?,\n"
                    + "?\n"
                    + ")";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPM);
            ps.setString(2, maPM);
            ps.setString(3, maPM);
            ps.setString(4, maPM);
            ps.setString(5, maPM);
            ps.setString(6, ngayTra);
            ps.setString(7, ghiChu);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkTrungSachh(String maQuyenSach, String maPhieuTra) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PTCT.IdQuyenSach FROM PhieuTraChiTiet AS PTCT WHERE PTCT.IdQuyenSach = (SELECT ID FROM QuyenSach WHERE QuyenSach.MaQuyenSach = ?) AND PTCT.IdPhieuTra = (SELECT ID FROM PhieuTra WHERE PhieuTra.MaPhieuTra = ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maQuyenSach);
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

    public String checkMaISBN(String maISBN) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "select qsct.maPhieuMuon from QuyenSachChiTiet as "
                    + "qsct inner join QuyenSach on QuyenSach.Id = qsct.idQuye"
                    + "nSach where QuyenSach.MaISBN = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maISBN);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                result = rs.getString("maPhieuMuon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getMaTTV(String maPhieuMuon) {
        String result = null;
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT MaTTV FROM TheThuVien WHERE TheThuVien.Id = (SELECT PhieuMuon.IdTTV FROM PhieuMuon WHERE PhieuMuon.MaPhieuMuon = ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuMuon);
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

}
