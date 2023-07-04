package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.phieuMuonChoMuon;
import viewModel.phieuDenSearchByMaTTVViewModel;
import viewModel.phieuDenViewModel;

public class phieuDenRepository {

    public ArrayList<phieuDenSearchByMaTTVViewModel> getAllSachByMaTTV(String maTheThuVien) {
        ArrayList<phieuDenSearchByMaTTVViewModel> listPD = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PMCT.MaPhieuMuon, QS.MaQuyenSach , PMCT.TenSach, PM.NgayMuon, PM.NgayHenTra, TenNguoiMuon = (SELECT DocGia.HoTen FROM DocGia WHERE DocGia.Id = (SELECT TTV.IdDocGia FROM TheThuVien AS TTV WHERE TTV.Id = PM.IdTTV)), PMCT.TinhTrangSach,PMCT.DoHuHao FROM PhieuMuonChiTiet AS PMCT INNER JOIN PhieuMuon AS PM ON PM.Id = PMCT.IdPhieuMuon INNER JOIN QuyenSach AS QS ON QS.Id = PMCT.IdQuyenSach WHERE PM.IdTTV = (SELECT TheThuVien.Id FROM TheThuVien WHERE TheThuVien.MaTTV = ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTheThuVien);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuDenSearchByMaTTVViewModel pd = new phieuDenSearchByMaTTVViewModel();
                pd.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                pd.setMaQuyenSach(rs.getString("MaQuyenSach"));
                pd.setTenSach(rs.getString("TenSach"));
                pd.setNgayMuon(rs.getString("NgayMuon"));
                pd.setNgayHenTra(rs.getString("NgayHenTra"));
                pd.setTenNguoiMuon(rs.getString("TenNguoiMuon"));
                pd.setTinhTrangSach(rs.getString("TinhTrangSach"));
                pd.setDoHuHao(rs.getDouble("DoHuHao"));
                listPD.add(pd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPD;
    }

    public ArrayList<phieuDenViewModel> getAllListPhieuDen() {
        ArrayList<phieuDenViewModel> listPD = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();

            String query = "SELECT PD.MaPhieuDen, PM.MaPhieuMuon, NV.MaNV, TTV.MaTTV, TenDocGia = (DG.HoTen) ,PD.SoTienPhat,NgayPhat = (PD.NgayTra), PD.LyDoPhat FROM PhieuDen AS PD INNER JOIN PhieuMuon AS PM ON PM.Id = PD.IDPhieuMuon INNER JOIN NhanVien AS NV ON NV.Id = PD.IDNhanVien INNER JOIN TheThuVien AS TTV ON TTV.Id = PD.IDTTV INNER JOIN DocGia AS DG ON DG.Id = TTV.IdDocGia ORDER BY PD.MaPhieuDen ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                phieuDenViewModel pd = new phieuDenViewModel();
                pd.setMaPhieuDen(rs.getString("MaPhieuDen"));
                pd.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                pd.setMaNV(rs.getString("MaNV"));
                pd.setMaTTV(rs.getString("MaTTV"));
                pd.setTenDocGia(rs.getString("TenDocGia"));
                pd.setSoTienPhat(rs.getDouble("SoTienPhat"));
                pd.setNgayPhat(rs.getString("NgayPhat"));
                pd.setLyDoPhat(rs.getString("LyDoPhat"));
                listPD.add(pd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPD;
    }

    public void insertPhieuDen(String maPhieuMuon, String maNhanVien, String maTTV, String soTienPhat, String ngayPhat, String lyDoPhat) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO PhieuDen(MaPhieuDen,IDPhieuMuon,IDNhanVien,IDTTV,SoTienPhat,NgayTra,LyDoPhat) VALUES(dbo.AUTO_MaPD(), (SELECT ID FROM PhieuMuon WHERE PhieuMuon.MaPhieuMuon = ?), (SELECT ID FROM NhanVien WHERE NhanVien.MaNV = ?), (SELECT ID FROM TheThuVien WHERE TheThuVien.MaTTV = ?), ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maPhieuMuon);
            ps.setString(2, maNhanVien);
            ps.setString(3, maTTV);
            ps.setString(4, soTienPhat);
            ps.setString(5, ngayPhat);
            ps.setString(6, lyDoPhat);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
