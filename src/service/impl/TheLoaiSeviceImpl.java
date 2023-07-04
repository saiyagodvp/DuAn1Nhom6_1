/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.TheLoai;
import repository.TheLoaiRepository;
import service.TheLoaiSevice;

/**
 *
 * @author ACER
 */
public class TheLoaiSeviceImpl implements TheLoaiSevice {

    private TheLoaiRepository tlx = new TheLoaiRepository();

    @Override
    public List<TheLoai> getAll() {
        return tlx.listTheLoaiAll();
    }

    @Override
    public TheLoai getOne(String name) {
        return tlx.getOne(name);
    }

    @Override
    public String add(TheLoai tl) {
        boolean add = tlx.add(tl);
        if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String delete(String maTL) {
        boolean delete = tlx.delete(maTL);
        if (delete) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String update(TheLoai tl, String maTL) {
        boolean update = tlx.update(tl, maTL);
        if (update) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }

}
