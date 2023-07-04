/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChiTietSach;

/**
 *
 * @author ACER
 */
public interface ChiTietSachSevice {

    List<ChiTietSach> getAll(String ids);

    String add(ChiTietSach ct, String ma);

    String update(ChiTietSach ct, String ma);

    String delete(String ma);
    
    ChiTietSach getOne(String maISBN);
}
