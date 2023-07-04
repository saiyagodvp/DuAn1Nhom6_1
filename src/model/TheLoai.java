/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class TheLoai {
    private String id;
    private String maTL;
    private String tenTL;

    public TheLoai() {
    }

    public TheLoai(String tenTL) {
        this.tenTL = tenTL;
    }

    public TheLoai(String id, String maTL, String tenTL) {
        this.id = id;
        this.maTL = maTL;
        this.tenTL = tenTL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }
    
    
}
