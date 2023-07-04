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

/**
 *
 * @author ACER
 */
public class NXBRepository {

    public List<NXB> listNXBAll() {
        List<NXB> listNXB = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT [Id]\n"
                    + "      ,[MaNhaXuatBan]\n"
                    + "      ,[TenNhaXuatBan]\n"
                    + "      ,[DiaChi]\n"
                    + "      ,[SDT]\n"
                    + "      ,[EMAIL]\n"
                    + "      ,[WEBSITE]\n"
                    + "  FROM [dbo].[NhaXuatBan]";
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String maNXB = rs.getString("MaNhaXuatBan");
                String tenNXB = rs.getString("TenNhaXuatBan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                String email = rs.getString("EMAIL");
                String website = rs.getString("WEBSITE");
                NXB nxb = new NXB(id, maNXB, tenNXB, diaChi, sdt, email, website);
                listNXB.add(nxb);
            }
            return listNXB;
        } catch (Exception e) {
        }
        return null;
    }

    public NXB getOne(String name) {
        String query = "SELECT [Id]\n"
                + "      ,[MaNhaXuatBan]\n"
                + "      ,[TenNhaXuatBan]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SDT]\n"
                + "      ,[EMAIL]\n"
                + "      ,[WEBSITE]\n"
                + "  FROM [dbo].[NhaXuatBan]"
                + "WHERE [TenNhaXuatBan] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String maNXB = rs.getString("MaNhaXuatBan");
                String tenNXB = rs.getString("TenNhaXuatBan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                String email = rs.getString("EMAIL");
                String website = rs.getString("WEBSITE");
                NXB nxb = new NXB(id, maNXB, tenNXB, diaChi, sdt, email, website);
                return nxb;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NXBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean add(NXB nxb) {
        String query = "INSERT INTO [dbo].[NhaXuatBan]\n"
                + "           ([MaNhaXuatBan]\n"
                + "           ,[TenNhaXuatBan]\n"
                + "           ,[DiaChi]\n"
                + "           ,[SDT]\n"
                + "           ,[EMAIL]\n"
                + "           ,[WEBSITE])\n"
                + "     VALUES\n"
                + "           ([dbo].[ma_NXB] (),?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nxb.getTenNXB());
            ps.setObject(2, nxb.getDiaChi());
            ps.setObject(3, nxb.getSdt());
            ps.setObject(4, nxb.getEmail());
            ps.setObject(5, nxb.getWebsite());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maNXB) {
        String query = "DELETE FROM [dbo].[NhaXuatBan]\n"
                + "      WHERE MaNhaXuatBan = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maNXB);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NXB nxb, String maNXB) {
        String query = "UPDATE [dbo].[NhaXuatBan]\n"
                + "   SET [TenNhaXuatBan] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[EMAIL] = ?\n"
                + "      ,[WEBSITE] = ?"
                + " WHERE [MaNhaXuatBan] = ?\n";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nxb.getTenNXB());
            ps.setObject(2, nxb.getDiaChi());
            ps.setObject(3, nxb.getSdt());
            ps.setObject(4, nxb.getEmail());
            ps.setObject(5, nxb.getWebsite());
            ps.setObject(6, maNXB);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<NXB> lists = new NXBRepository().listNXBAll();
        for (NXB list : lists) {
            System.out.println(list.toString());
        }
    }
}
