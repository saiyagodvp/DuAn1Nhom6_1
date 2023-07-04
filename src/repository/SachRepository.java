/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NXB;
import model.Sach;
import model.TheLoai;

/**
 *
 * @author ACER
 */
public class SachRepository {

    public List<Sach> listSachAll() {
        List<Sach> listSachAll = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT dbo.DauSach.Id, dbo.DauSach.TenSach, dbo.DauSach.MaSach, dbo.DauSach.TacGia, dbo.TheLoai.TenTheLoai, dbo.NhaXuatBan.TenNhaXuatBan, dbo.DauSach.NamXuatBan, dbo.DauSach.HinhAnh, dbo.DauSach.Gia, \n"
                    + "                  dbo.DauSach.SoTrang, dbo.DauSach.SoLuong\n"
                    + "FROM     dbo.DauSach INNER JOIN\n"
                    + "                  dbo.NhaXuatBan ON dbo.DauSach.IDNhaXuatBan = dbo.NhaXuatBan.Id INNER JOIN\n"
                    + "                  dbo.TheLoai ON dbo.DauSach.IDTheLoai = dbo.TheLoai.Id ORDER BY dbo.DauSach.MaSach ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String maSach = rs.getString("MaSach");
                String tenSach = rs.getString("TenSach");
                String tentg = rs.getString("TacGia");
                TheLoai tl = new TheLoai(rs.getString("TenTheLoai"));
                NXB nxb = new NXB(rs.getString("TenNhaXuatBan"));
                Integer namXB = rs.getInt("NamXuatBan");
                Integer gia = rs.getInt("Gia");
                Integer soTrang = rs.getInt("SoTrang");
                Integer soLuong = rs.getInt("SoLuong");
                String anh = rs.getString("HinhAnh");
                Sach sach = new Sach(id, tenSach, maSach, tentg, nxb, tl, namXB, gia, soTrang, soLuong, anh);
                listSachAll.add(sach);
            }
            return listSachAll;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(Sach s) {
        String query = "INSERT INTO [dbo].[DauSach]\n"
                + "           ([TenSach]\n"
                + "           ,[MaSach]\n"
                + "           ,[TacGia]\n"
                + "           ,[IDTheLoai]\n"
                + "           ,[IDNhaXuatBan]\n"
                + "           ,[NamXuatBan]\n"
                + "           ,[HinhAnh]\n"
                + "           ,[Gia]\n"
                + "           ,[SoTrang]\n"
                + "           ,[SoLuong])\n"
                + "     VALUES \n"
                + "           (?,[dbo].[ma_Sach] (),?,?,?,?,?,?,?,0)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, s.getTenSach());
            ps.setObject(2, s.getTenTacGia());
            ps.setObject(3, s.getTheLoai().getId());
            ps.setObject(4, s.getNxb().getId());
            ps.setObject(5, s.getNamXB());
            ps.setObject(6, s.getAnh());
            ps.setObject(7, s.getGia());
            ps.setObject(8, s.getSoTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Id) {
        String query = "DELETE QuyenSach WHERE IdDauSach = ?\n"
                + "DELETE DauSach WHERE Id = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, Id);
            ps.setObject(2, Id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Sach s, String maSach) {
        String query = "UPDATE [dbo].[DauSach]\n"
                + "   SET [TenSach] = ?\n"
                + "      ,[TacGia] = ?\n"
                + "      ,[IDTheLoai] = ?\n"
                + "      ,[IDNhaXuatBan] = ?\n"
                + "      ,[NamXuatBan] = ?\n"
                + "      ,[Gia] = ?\n"
                + "      ,[SoTrang] = ?\n"
                + "      ,[HinhAnh] = ?\n"
                + " WHERE [MaSach] = ?\n";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, s.getTenSach());
            ps.setObject(2, s.getTenTacGia());
            ps.setObject(3, s.getTheLoai().getId());
            ps.setObject(4, s.getNxb().getId());
            ps.setObject(5, s.getNamXB());
            ps.setObject(6, s.getGia());
            ps.setObject(7, s.getSoTrang());
            ps.setObject(8, s.getAnh());
            ps.setObject(9, maSach);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public Sach getOne(String ma) throws Exception {
        String query = "SELECT dbo.DauSach.Id, dbo.DauSach.TenSach, dbo.DauSach.MaSach, dbo.DauSach.TacGia, dbo.TheLoai.TenTheLoai, dbo.NhaXuatBan.TenNhaXuatBan, dbo.DauSach.NamXuatBan, dbo.DauSach.HinhAnh, dbo.DauSach.Gia, \n"
                + "                  dbo.DauSach.SoTrang, dbo.DauSach.SoLuong\n"
                + "FROM     dbo.DauSach INNER JOIN\n"
                + "                  dbo.NhaXuatBan ON dbo.DauSach.IDNhaXuatBan = dbo.NhaXuatBan.Id INNER JOIN\n"
                + "                  dbo.TheLoai ON dbo.DauSach.IDTheLoai = dbo.TheLoai.Id\n"
                + "WHERE dbo.DauSach.MaSach = ? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String maSach = rs.getString("MaSach");
                String tenSach = rs.getString("TenSach");
                String tentg = rs.getString("TacGia");
                TheLoai tl = new TheLoai(rs.getString("TenTheLoai"));
                NXB nxb = new NXB(rs.getString("TenNhaXuatBan"));
                Integer namXB = rs.getInt("NamXuatBan");
                Integer gia = rs.getInt("Gia");
                Integer soTrang = rs.getInt("SoTrang");
                Integer soLuong = rs.getInt("SoLuong");
                String anh = rs.getString("HinhAnh");
                Sach s = new Sach(id, tenSach, maSach, tentg, nxb, tl, namXB, gia, soTrang, soLuong, anh);
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        List<Sach> lists = new SachRepository().listSachAll();
        Sach s = new SachRepository().getOne("S0003");
        System.out.print(s.toString());

    }
}
