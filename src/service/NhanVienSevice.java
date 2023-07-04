/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.NhanVien;
import viewModel.QLNhanVienModel;

/**
 *
 * @author ACER
 */
public interface NhanVienSevice {
    NhanVien getOne(String ma);
    NhanVien getOne1(String ma);
    ArrayList<QLNhanVienModel> getAll();
    void insert(QLNhanVienModel nv);
    void delete(String ma);
    void update(QLNhanVienModel nv);
}
