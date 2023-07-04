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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import viewModel.QLNhanVienModel;

/**
 *
 * @author ACER
 */
public class NhanVienRepository {
    private ArrayList<NhanVien> lstNv = new ArrayList<>();
    public NhanVien getOne(String ma) {
        String query = "SELECT [Id]\n"
                + "      ,[MaNV]\n"
                + "      ,[TaiKhoan]\n"
                + "      ,[MatKhau]\n"
                + "      ,[HoTen]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SDT]\n"
                + "      ,[TrangThai]\n"
                + "      ,[ChucVu]\n"
                + "      ,[Avatar]\n"
                + "  FROM [dbo].[NhanVien]"
                + "WHERE [MaNV] = ? ";
        try (
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String manv = rs.getString("MaNV");
                String tenTK = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String hoTen = rs.getString("HoTen");
                String ngaySinh = rs.getString("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                int trangthai = rs.getInt("TrangThai");
                String chucVu = rs.getString("ChucVu");
                String hinhanh = rs.getString("Avatar");
                NhanVien nv = new NhanVien(id, ma, tenTK, matKhau, hoTen, diachi, ngaySinh, gioiTinh, sdt, trangthai, chucVu, hinhanh);
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NXBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public NhanVien getOne1(String ma){
        String query = "select * from NhanVien where MaNV like '%?%'";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(query);
            pr.setObject(1, ma);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {     
                String id = rs.getString("Id");
                String manv = rs.getString("MaNV");
                String tenTK = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String hoTen = rs.getString("HoTen");
                String ngaySinh = rs.getString("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                int trangthai = rs.getInt("TrangThai");
                String chucVu = rs.getString("ChucVu");
                String hinhanh = rs.getString("Avatar");
                NhanVien nv = new NhanVien(id, manv, tenTK, matKhau, hoTen, diachi, ngaySinh, gioiTinh, sdt, trangthai, chucVu, hinhanh);
                return nv;
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> lstNV = new ArrayList<>();
        String query = "select * from NhanVien";
                
        try (
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String manv = rs.getString("MaNV");
                String tenTK = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String hoTen = rs.getString("HoTen");
                String ngaySinh = rs.getString("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                int trangthai = rs.getInt("TrangThai");
                String chucVu = rs.getString("ChucVu");
                String hinhanh = rs.getString("Avatar");
                NhanVien nv = new NhanVien(id, manv, tenTK, matKhau, hoTen, diachi, ngaySinh, gioiTinh, sdt, trangthai, chucVu, hinhanh);
                lstNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NXBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstNV;
    }
    public void insert(QLNhanVienModel nv) {
        
        String query = "insert into NhanVien(MaNV,HoTen,SDT,TaiKhoan,MatKhau,NgaySinh,DiaChi,GioiTinh,ChucVu,TrangThai,Avatar) values ([dbo].[maNv] (),?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, nv.getHoten());
            pr.setString(2, nv.getSdt());
            pr.setString(3, nv.getTenTaiKhoan());
            pr.setString(4, nv.getMatKhau());
            pr.setString(5, nv.getNgaySinh());
            pr.setString(6, nv.getDiaChi());
            pr.setString(7, nv.getGioiTinh());
            pr.setString(8, nv.getChucVu());
            pr.setInt(9, nv.getTrangThai());
            pr.setInt(9, nv.getTrangThai());
            pr.setString(10, nv.getHinhAnh());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public void delete(String ma) {
       
        String query = "delete NhanVien where MaNV =?";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, ma);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(QLNhanVienModel nv) {
        String query = "update NhanVien set HoTen = ?,SDT=?, TaiKhoan=?,MatKhau = ?,NgaySinh=?, GioiTinh=?,DiaChi=?,ChucVu=?,TrangThai=?,Avatar = ? where MaNV =?";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, nv.getHoten());
            pr.setString(2, nv.getSdt());
            pr.setString(3, nv.getTenTaiKhoan());
            pr.setString(4, nv.getMatKhau());
            pr.setString(5, nv.getNgaySinh());
            pr.setString(6, nv.getGioiTinh());
            pr.setString(7, nv.getDiaChi());
            pr.setString(8, nv.getChucVu());
            pr.setInt(9, nv.getTrangThai());
            pr.setString(10, nv.getHinhAnh());
            pr.setString(11, nv.getMa());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
}

