/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.ChiTietSach;
import repository.ChiTietSachRepository;
import service.ChiTietSachSevice;

/**
 *
 * @author ACER
 */
public class ChiTietSachSeviceImpl implements ChiTietSachSevice{
    private ChiTietSachRepository cts = new ChiTietSachRepository();

    @Override
    public String add(ChiTietSach ct,String ma) {
        boolean add = cts.add(ct,ma);
        if(add){
            return "Add thành công";
        }else{
            return "Add thất bại";
        }
    }

    @Override
    public String update(ChiTietSach ct, String ma) {
        boolean update = cts.update(ct, ma);
        if(update){
            return "Update thành công";
        }else{
            return "Update thất bại";
        }
    }

    @Override
    public List<ChiTietSach> getAll(String ids) {
        return cts.listCTSachAll(ids);
    }

    @Override
    public String delete(String ma) {
        boolean delete = cts.delete( ma);
        if(delete){
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        }
    }

    @Override
    public ChiTietSach getOne(String maISBN) {
        return cts.getOne(maISBN);
    }
    
}
