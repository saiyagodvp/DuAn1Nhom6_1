/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phngn
 */
public class PhieuDen_model {
    
    private String id;
    private String mapd;
    private String idphieumuon;
    private String idnhanvien;
    private String idthethuvien;
    private double sotienphat;
    private String ngaytra;

    public PhieuDen_model() {
    }

    public PhieuDen_model(String id, String mapd, String idphieumuon, String idnhanvien, String idthethuvien, double sotienphat, String ngaytra) {
        this.id = id;
        this.mapd = mapd;
        this.idphieumuon = idphieumuon;
        this.idnhanvien = idnhanvien;
        this.idthethuvien = idthethuvien;
        this.sotienphat = sotienphat;
        this.ngaytra = ngaytra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMapd() {
        return mapd;
    }

    public void setMapd(String mapd) {
        this.mapd = mapd;
    }

    public String getIdphieumuon() {
        return idphieumuon;
    }

    public void setIdphieumuon(String idphieumuon) {
        this.idphieumuon = idphieumuon;
    }

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public String getIdthethuvien() {
        return idthethuvien;
    }

    public void setIdthethuvien(String idthethuvien) {
        this.idthethuvien = idthethuvien;
    }

    public double getSotienphat() {
        return sotienphat;
    }

    public void setSotienphat(double sotienphat) {
        this.sotienphat = sotienphat;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }
    
}
