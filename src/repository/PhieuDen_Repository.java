/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import Utilities.DBContext;
import Utilities.JDBC_Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import model.PhieuDenCT;
import model.PhieuDen_model;
import model.PhieuMuon;
import model.TTV;
import viewModel.InPhieuDen;
import viewModel.quanlysachthethuvien;
/**
 *
 * @author phngn
 */
public class PhieuDen_Repository {
     public static List<quanlysachthethuvien> getSachBymaTTV(String mattv) {
        ResultSet rs = null;
        List<quanlysachthethuvien> listpm = new ArrayList<>();
        quanlysachthethuvien pm = null;
        String sql = "select PhieuMuon.maphieumuon ,PhieuMuonChiTiet.MaSach,PhieuMuonChiTiet.TenSach,PhieuMuon.NgayMuon,PhieuMuon.NgayHenTra,PhieuMuonChiTiet.dohuhao,DocGia.HoTen from PhieuMuonChiTiet join PhieuMuon on PhieuMuonChiTiet.IdPhieuMuon=PhieuMuon.id join TheThuVien on TheThuVien.Id=PhieuMuon.IdTTV join DocGia on TheThuVien.IdDocGia=DocGia.Id\n"
                + "where PhieuMuonChiTiet.IdPhieuMuon=(select id from PhieuMuon WHERE IdTTV=(select id from TheThuVien where MaTTV=?))";
        rs = JDBC_Helper.SelectTongQuat(sql, mattv);
        try {
            while (rs.next()) {

                String id = rs.getString(1);

                String masach = rs.getString(2);
                String tensach = rs.getString(3);
                String ngaymuon = rs.getString(4);
                String ngaytra = rs.getString(5);
                String tinhtrangsach = rs.getString(6);
                String hoten = rs.getString(7);
                pm = new quanlysachthethuvien(id, masach, tensach, ngaymuon, ngaytra, tinhtrangsach, hoten);
                listpm.add(pm);
            }
            return listpm;
        } catch (SQLException ex) {
            return null;
        }
    }
     public static List<InPhieuDen> getphieudenctbymapd(String mapd) {
        ResultSet rs = null;
        List<InPhieuDen> listpm = new ArrayList<>();
        InPhieuDen inpd = null;
        String sql = " select phieuden.sotienphat,phieuden.ngaytra,phieudenchitiet.MaQuyenSach,phieudenchitiet.tensach,phieudenchitiet.dohuhao,PhieuDen.LyDoPhat from phieudenChiTiet\n" +
" join phieuden on phieudenchitiet.idphieuden=phieuden.id where phieuden.MaPhieuDen=?";
        rs = JDBC_Helper.SelectTongQuat(sql, mapd);
        try {
            while (rs.next()) {

                double sotienphat= rs.getDouble(1);
                String ngaytra = rs.getString(2);
                String masach= rs.getString(3);
                String tensach = rs.getString(4);
                int dohuhao = rs.getInt(5);
                 String ld = rs.getString(6);
                inpd = new InPhieuDen(masach, ngaytra, tensach, dohuhao, sotienphat,ld);
                listpm.add(inpd);
            }
            return listpm;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static String getidpmbyma(String ma) {
        String id = "";
        ResultSet rs = null;
        String sql = " select ID from Phieumuon where maphieumuon=? ";
        rs = JDBC_Helper.SelectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                id = rs.getString(1);

//                pm = new PhieuDen_model(idnhanvien, idthethuvien);
            }
            return id;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int insertPhieuDenCT(PhieuDenCT pdct) {

        String query = "insert into PhieuDenChitiet(idPhieuDen,MaQuyenSach,tensach,tinhtrangsach,dohuhao) values(?,?,?,?,?)";

        return JDBC_Helper.UpdateTongQuat(query, pdct.getId(), pdct.getMasach(), pdct.getTensach(), pdct.getTinhtrangsach(), pdct.getDohuhao());

    }

    public static List<PhieuDenCT> getALLPDCT(String idpd) {

        ResultSet rs = null;
        PhieuDenCT pd = new PhieuDenCT();

        List<PhieuDenCT> list = new ArrayList<>();
        String sql = "select * from PhieuDenChiTiet join phieuden on phieudenchitiet.idphieuden=phieuden.id \n" +
"order by phieuden.maphieuden desc";
        rs = JDBC_Helper.SelectTongQuat(sql);
        try {
            while (rs.next()) {
                String id1 = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
               
                String tinhTrang = rs.getString(4);
                int dhh = rs.getInt(5);

                pd = new PhieuDenCT(id1, ma, ten, tinhTrang, dhh);
                list.add(pd);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int updatePhieuDen(double stpa,String ldo, String mapd) {
        String query = "update PhieuDen\n" +
" set LyDoPhat=?,SoTienPhat=? where MaPhieuDen = ?";
        return JDBC_Helper.UpdateTongQuat(query,ldo, stpa,mapd);
    }
    
     public static int updatePhieuDenChiTiet( String idpd, String dohuhao, String ghichu) {
        String query = "update PhieuDenChiTiet set DoHuHao=?, TinhTrangSach=? where idphieuden=?";
        return JDBC_Helper.UpdateTongQuat(query, dohuhao,ghichu,idpd);
    }

    public static int getsotrangbymasach(String ma) {
        PhieuDen_model pm = null;
        ResultSet rs = null;
        int sotrang = 0;
        String sql = " select sotrang from dausach where Masach=? ";
        rs = JDBC_Helper.SelectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                String idnhanvien = rs.getString(1);
                sotrang = rs.getInt(1);
            }
            return sotrang;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getidpdbyma(String ma) {
        String id = "";
        ResultSet rs = null;
        String sql = " select ID from Phieuden where MaPhieuDen=? ";
        rs = JDBC_Helper.SelectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                id = rs.getString(1);

//                pm = new PhieuDen_model(idnhanvien, idthethuvien);
            }
            return id;
        } catch (SQLException ex) {
            return null;
        }
    }
    
     public static String getidpmbyidpd(String id1) {
        String id = "";
        ResultSet rs = null;
        String sql = " select IDPhieuMuon from PhieuDen where Id=?";
        rs = JDBC_Helper.SelectTongQuat(sql, id1);
        try {
            while (rs.next()) {
                id = rs.getString(1);

//                pm = new PhieuDen_model(idnhanvien, idthethuvien);
            }
            return id;
        } catch (SQLException ex) {
            return null;
        }
    }
    
     public static String getstpbyid(String id1) {
        String id = "";
        ResultSet rs = null;
        String sql = " select sotienphat from Phieuden where id=? ";
        rs = JDBC_Helper.SelectTongQuat(sql, id1);
        try {
            while (rs.next()) {
                id = rs.getString(1);

//                pm = new PhieuDen_model(idnhanvien, idthethuvien);
            }
            return id;
        } catch (SQLException ex) {
            return null;
        }
    }

     
//      public static String getdohuhaobyid(String id1) {
//        String id = "";
//        ResultSet rs = null;
//        String sql = " select sotienphat from Phieuden where id=? ";
//        rs = JDBC_Helper.SelectTongQuat(sql, id1);
//        try {
//            while (rs.next()) {
//                id = rs.getString(1);
//
////                pm = new PhieuDen_model(idnhanvien, idthethuvien);
//            }
//            return id;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }

    public static String getidttvbyma(String ma) {
        String id = "";
        ResultSet rs = null;
        String sql = " select ID from TheThuVien where maTTV=? ";
        rs = JDBC_Helper.SelectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                id = rs.getString(1);

//                pm = new PhieuDen_model(idnhanvien, idthethuvien);
            }
            return id;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static String getMaPmById(String idnv) {

        ResultSet rs = null;
        String ten = "";

        PhieuDen_model pd = new PhieuDen_model();
        String sql = "select MaPhieuMuon from phieumuon where id=?";
        rs = JDBC_Helper.SelectTongQuat(sql, idnv);
        try {
            while (rs.next()) {
                ten = rs.getString(1);
            }
            return ten;
        } catch (SQLException ex) {
            return null;
        }
    }
     public static String getMaPDById(String idnv) {

        ResultSet rs = null;
        String ten = "";

        PhieuDen_model pd = new PhieuDen_model();
        String sql = "select MaPhieuDen from phieuden where id=?";
        rs = JDBC_Helper.SelectTongQuat(sql, idnv);
        try {
            while (rs.next()) {
                ten = rs.getString(1);
            }
            return ten;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int insertPhieuDen(String idpm, String idnv, String idttv, double stp, String ngaytra) {

        String query = "insert into PhieuDen(MaPhieuDen,idphieumuon,idnhanvien,idttv,SoTienPhat,ngaytra) values(dbo.ma_phieuden(),?,?,?,?,?)";

        return JDBC_Helper.UpdateTongQuat(query, idpm, idnv, idttv, stp, ngaytra);

    }

    public static List<PhieuDen_model> getALL(String idttv, String idnv, String idpm) {

        ResultSet rs = null;

        PhieuDen_model pd = new PhieuDen_model();
        List<PhieuDen_model> list = new ArrayList<>();
        String sql = "select * from PhieuDen where id not in (select IdPhieuDen from PhieuDenChiTiet) and IDPhieuMuon=? and IDNhanVien=? and IDTTV=?";
        rs = JDBC_Helper.SelectTongQuat(sql, idpm, idnv, idttv);
        try {
            while (rs.next()) {
                String id1 = rs.getString(1);
                String ma = rs.getString(2);
                String idpm1 = rs.getString(3);
                String idnv1 = rs.getString(4);
                String idttv1 = rs.getString(5);
                String stp = rs.getString(6);
                String ngayTra = rs.getString(7);
                pd = new PhieuDen_model(id1, ma, idpm1, idnv1, idttv1, Double.parseDouble(stp), ngayTra);
                list.add(pd);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static String getTenNvById(String idnv) {

        ResultSet rs = null;
        String ten = "";

        PhieuDen_model pd = new PhieuDen_model();
        String sql = "select hoten from nhanvien where id=?";
        rs = JDBC_Helper.SelectTongQuat(sql, idnv);
        try {
            while (rs.next()) {
                ten = rs.getString(1);
            }
            return ten;
        } catch (SQLException ex) {
            return null;
        }
    }

    
}
