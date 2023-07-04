/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import repository.NhanVienRepository;
import service.NhanVienSevice;
import viewModel.QLNhanVienModel;

/**
 *
 * @author ACER
 */
public class NhanVienSeviceImpl implements NhanVienSevice {

    private NhanVienRepository nvrs = new NhanVienRepository();

    @Override
    public NhanVien getOne(String ma) {
        return nvrs.getOne(ma);
    }
    @Override
    public ArrayList<QLNhanVienModel> getAll() {
        List<QLNhanVienModel> listql = new ArrayList<>();
        for (NhanVien nv : nvrs.getAll()) {
            listql.add(new QLNhanVienModel(nv.getMa(),nv.getHoTen(),nv.getSdt(),nv.getTenTaiKhoan(),nv.getMatKhau(),nv.getNgaySinh(),nv.getGioiTinh(),nv.getDiaChi(),nv.getChucVu(),nv.getTrangThai(),nv.getHinhAnh()));
        }
        return (ArrayList<QLNhanVienModel>) listql;
    }

    @Override
    public void insert(QLNhanVienModel nv) {
        this.nvrs.insert(nv);
    }

    @Override
    public void delete(String ma) {
        this.nvrs.delete(ma);
    }

    @Override
    public void update(QLNhanVienModel nv) {
        this.nvrs.update(nv);
    }

    @Override
    public NhanVien getOne1(String ma) {
        return nvrs.getOne1(ma);
    }
}
