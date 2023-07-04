/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phngn
 */
public class PhieuMuon {
    private String id;
    private String idtt;
    private String maphieumuon;
    private String ngaymuon;
    private String ngayhentra;
    private String ghichu;
    private double tiencoc;

    public PhieuMuon() {
    }

    public PhieuMuon(String id, String idtt, String maphieumuon, String ngaymuon, String ngayhentra, String ghichu, double tiencoc) {
        this.id = id;
        this.idtt = idtt;
        this.maphieumuon = maphieumuon;
        this.ngaymuon = ngaymuon;
        this.ngayhentra = ngayhentra;
        this.ghichu = ghichu;
        this.tiencoc = tiencoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdtt() {
        return idtt;
    }

    public void setIdtt(String idtt) {
        this.idtt = idtt;
    }

    public String getMaphieumuon() {
        return maphieumuon;
    }

    public void setMaphieumuon(String maphieumuon) {
        this.maphieumuon = maphieumuon;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgayhentra() {
        return ngayhentra;
    }

    public void setNgayhentra(String ngayhentra) {
        this.ngayhentra = ngayhentra;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public double getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(double tiencoc) {
        this.tiencoc = tiencoc;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" + "id=" + id + ", idtt=" + idtt + ", maphieumuon=" + maphieumuon + ", ngaymuon=" + ngaymuon + ", ngayhentra=" + ngayhentra + ", ghichu=" + ghichu + ", tiencoc=" + tiencoc + '}';
    }
}
