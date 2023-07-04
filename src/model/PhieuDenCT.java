/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phngn
 */
public class PhieuDenCT {
    private String id;
    private String masach;
    private String tensach;
   
    private String tinhtrangsach;
    private double dohuhao;

    public PhieuDenCT() {
    }

    public PhieuDenCT(String id, String masach, String tensach, String tinhtrangsach, double dohuhao) {
        this.id = id;
        this.masach = masach;
        this.tensach = tensach;
       
        this.tinhtrangsach = tinhtrangsach;
        this.dohuhao = dohuhao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    

    

    public String getTinhtrangsach() {
        return tinhtrangsach;
    }

    public void setTinhtrangsach(String tinhtrangsach) {
        this.tinhtrangsach = tinhtrangsach;
    }

    public double getDohuhao() {
        return dohuhao;
    }

    public void setDohuhao(double dohuhao) {
        this.dohuhao = dohuhao;
    }
    
    
    
}
