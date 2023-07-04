/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.NhanVien;
import repository.DangNhapRepository;
import service.DangNhapSevice;

/**
 *
 * @author ACER
 */
public class DangNhapSeviceImpl implements DangNhapSevice {

    private DangNhapRepository dangNhap = new DangNhapRepository();

    @Override
    public NhanVien getOne(String tk, String mk) {
        return dangNhap.getOne(tk, mk);
    }

}
