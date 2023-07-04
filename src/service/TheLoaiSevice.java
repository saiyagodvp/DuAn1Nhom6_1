/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.TheLoai;

/**
 *
 * @author ACER
 */
public interface TheLoaiSevice {
    List<TheLoai> getAll();
    
    TheLoai getOne(String name);
    
    String add(TheLoai tl);
    
    String delete(String maTL);
    
    String update(TheLoai tl,String maTL);
}
