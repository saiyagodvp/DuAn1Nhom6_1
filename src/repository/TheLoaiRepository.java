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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TheLoai;

/**
 *
 * @author ACER
 */
public class TheLoaiRepository {

    public List<TheLoai> listTheLoaiAll() {
        ArrayList<TheLoai> listTheLoai = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT [Id]\n"
                    + "      ,[MaTheLoai]\n"
                    + "      ,[TenTheLoai]\n"
                    + "  FROM [dbo].[TheLoai]";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String maTL = rs.getString("MaTheLoai");
                String tenTL = rs.getString("TenTheLoai");
                TheLoai tl = new TheLoai(id, maTL, tenTL);
                listTheLoai.add(tl);
            }
            return listTheLoai;
        } catch (Exception e) {
        }
        return null;
    }

    public TheLoai getOne(String name) {
        String query = "SELECT [Id]\n"
                + "      ,[MaTheLoai]\n"
                + "      ,[TenTheLoai]\n"
                + "  FROM [dbo].[TheLoai]"
                + "WHERE [TenTheLoai] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String maTL = rs.getString("MaTheLoai");
                String tenTL = rs.getString("TenTheLoai");
                TheLoai tl = new TheLoai(id, maTL, tenTL);
                return tl;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NXBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean add(TheLoai tl) {
        String query = "INSERT INTO [dbo].[TheLoai]\n"
                + "           ([MaTheLoai]\n"
                + "           ,[TenTheLoai])\n"
                + "     VALUES\n"
                + "           ([dbo].[ma_TL] (),?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tl.getTenTL());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maTL) {
        String query = "DELETE FROM [dbo].[TheLoai]\n"
                + "      WHERE MaTheLoai = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maTL);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(TheLoai tl, String maTL) {
        String query = "UPDATE [dbo].[TheLoai]\n"
                + "   SET [TenTheLoai] = ?"
                + " WHERE [MaTheLoai] = ?\n";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tl.getTenTL());
            ps.setObject(2, maTL);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
