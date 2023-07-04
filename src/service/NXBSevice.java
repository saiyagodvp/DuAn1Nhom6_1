/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NXB;

/**
 *
 * @author ACER
 */
public interface NXBSevice {

    List<NXB> getAll();

    NXB getOne(String name);
    
    String add(NXB nxb);
    
    String delete(String maNXB);
    
    String update(NXB nxb,String maNXB);
}
