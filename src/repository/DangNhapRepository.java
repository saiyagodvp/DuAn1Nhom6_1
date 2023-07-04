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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;

/**
 *
 * @author ACER
 */
public class DangNhapRepository {

    public NhanVien getOne(String tk, String mk) {
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
                + "WHERE [TaiKhoan] = ? AND [MatKhau] = ? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tk);
            ps.setObject(2, mk);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaNV");
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
}
