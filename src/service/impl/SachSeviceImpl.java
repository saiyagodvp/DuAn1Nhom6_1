/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;
import repository.SachRepository;
import service.SachSevice;
import viewModel.QLSachModel;

/**
 *
 * @author ACER
 */
public class SachSeviceImpl implements SachSevice {

    private SachRepository sachrs = new SachRepository();

    @Override
    public List<QLSachModel> getAll() {
        List<QLSachModel> listql = new ArrayList<>();
        for (Sach s : this.sachrs.listSachAll()) {
            listql.add(new QLSachModel(s.getMaSach(), s.getTenSach(), s.getTenTacGia(), s.getTheLoai().getTenTL(), s.getNxb().getTenNXB(), s.getNamXB(), s.getGia(), s.getSoTrang(), s.getSoLuong()));
        }
        return listql;
    }

    @Override
    public String add(Sach s) {
        boolean add = sachrs.add(s);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = sachrs.delete(id);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(Sach s, String ma) {
        boolean update = sachrs.update(s, ma);
        if (update) {
            return "Cập Nhật thành công";
        } else {
            return "Cập Nhật thất bại";
        }
    }

    @Override
    public Sach getOne(String ma) {
        try {
            return this.sachrs.getOne(ma);
        } catch (Exception ex) {
            Logger.getLogger(SachSeviceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Sach s = new SachSeviceImpl().getOne("S006");
        System.out.println(s);
    }

    @Override
    public List<QLSachModel> listSearch(List<QLSachModel> listql, String ten) {
        List<QLSachModel> listSearch = new ArrayList<>();
        for (QLSachModel qlSach : listql) {
            if (qlSach.getTenSach().equalsIgnoreCase(ten)) {
                listSearch.add(qlSach);
            }
        }
        return listSearch;
    }
}
