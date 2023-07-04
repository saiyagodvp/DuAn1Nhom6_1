/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Sach;
import viewModel.QLSachModel;

/**
 *
 * @author ACER
 */
public interface SachSevice {
    List<QLSachModel> getAll();
    
    String add(Sach s);
    
    String delete(String id);
    
    String update(Sach s,String ma);
    
    Sach getOne(String ma);
    
    List<QLSachModel> listSearch(List<QLSachModel> listql, String ten);
}
