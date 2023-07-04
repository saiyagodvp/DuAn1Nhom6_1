/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.NXB;
import repository.NXBRepository;
import service.NXBSevice;

/**
 *
 * @author ACER
 */
public class NXBSeviceImpl implements NXBSevice{
    private NXBRepository nxbx = new NXBRepository();
    @Override
    public List<NXB> getAll() {
        return nxbx.listNXBAll();
    }

    @Override
    public NXB getOne(String name) {
        return nxbx.getOne(name);
    }

    @Override
    public String add(NXB nxb) {
        boolean add = nxbx.add(nxb);
        if(add){
            return "Add thành công";
        }else{
            return "Add thất bại";
        }
    }

    @Override
    public String delete(String maNXB) {
        boolean delete = nxbx.delete(maNXB);
        if(delete){
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(NXB nxb, String maNXB) {
        boolean update = nxbx.update(nxb, maNXB);
        if(update){
            return "Update thành công";
        }else{
            return "Update thất bại";
        }
    }
    
}
