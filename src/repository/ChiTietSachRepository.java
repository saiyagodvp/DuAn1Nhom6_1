/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSach;
import model.Sach;

/**
 *
 * @author ACER
 */
public class ChiTietSachRepository {

    public List<ChiTietSach> listCTSachAll(String ids) {
        List<ChiTietSach> listCTSachAll = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT [Id]\n"
                    + "      ,[IdDauSach]\n"
                    + "      ,[MaQuyenSach]\n"
                    + "      ,[MaISBN]\n"
                    + "      ,[DoHuHao]\n"
                    + "      ,[TrangThai]\n"
                    + "      ,[TinhTrangSach]\n"
                    + "  FROM [dbo].[QuyenSach]\n"
                    + "WHERE [IdDauSach] = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, ids);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String iddauSach = rs.getString("IdDauSach");
                String ma = rs.getString("MaQuyenSach");
                String maisbn = rs.getString("MaISBN");
                Float dohuhao = rs.getFloat("DoHuHao");
                boolean trangThai = rs.getBoolean("TrangThai");
                boolean tinhTrang = rs.getBoolean("TinhTrangSach");
                ChiTietSach ct = new ChiTietSach(id, iddauSach, ma, maisbn, dohuhao, trangThai, tinhTrang);
                listCTSachAll.add(ct);
            }
            return listCTSachAll;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(ChiTietSach ct, String ma) {
        String query = "INSERT INTO [dbo].[QuyenSach]\n"
                + "           ([IdDauSach]\n"
                + "           ,[MaQuyenSach]\n"
                + "           ,[MaISBN]\n"
                + "           ,[DoHuHao]\n"
                + "           ,[TrangThai]"
                + "           ,[TinhTrangSach])"
                + "     VALUES \n"
                + "           (?,[dbo].[ma_QuyenSach](?),?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ct.getIdDauSach());
            ps.setObject(2, ma);
            ps.setObject(3, ct.getMaISBN());
            ps.setObject(4, ct.getDoHuHao());
            ps.setObject(5, ct.isTrangThai());
            ps.setObject(6, ct.isTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChiTietSach ct, String maCTSach) {
        String query = "UPDATE [dbo].[QuyenSach]\n"
                + "   SET[MaISBN] = ?\n"
                + "      ,[DoHuHao] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[TinhTrangSach] = ?\n"
                + " WHERE MaQuyenSach = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ct.getMaISBN());
            ps.setObject(2, ct.getDoHuHao());
            ps.setObject(3, ct.isTrangThai());
            ps.setObject(4, ct.isTinhTrang());
            ps.setObject(5, maCTSach);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maCTSach) {
        String query = "DELETE FROM [dbo].[QuyenSach]\n"
                + " WHERE MaQuyenSach = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maCTSach);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public ChiTietSach getOne(String maISBN) {
        List<ChiTietSach> listCTSachAll = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT [Id]\n"
                    + "      ,[IdDauSach]\n"
                    + "      ,[MaQuyenSach]\n"
                    + "      ,[MaISBN]\n"
                    + "      ,[DoHuHao]\n"
                    + "      ,[TrangThai]\n"
                    + "      ,[TinhTrangSach]\n"
                    + "  FROM [dbo].[QuyenSach]\n"
                    + "WHERE [MaISBN] = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, maISBN);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String iddauSach = rs.getString("IdDauSach");
                String ma = rs.getString("MaQuyenSach");
                String maisbn = rs.getString("MaISBN");
                Float dohuhao = rs.getFloat("DoHuHao");
                boolean trangThai = rs.getBoolean("TrangThai");
                boolean tinhTrang = rs.getBoolean("TinhTrangSach");
                ChiTietSach ct = new ChiTietSach(id, iddauSach, ma, maisbn, dohuhao, trangThai, tinhTrang);
                return ct;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
