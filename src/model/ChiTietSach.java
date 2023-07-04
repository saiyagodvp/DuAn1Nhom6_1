/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class ChiTietSach {

    private String id;
    private String idDauSach;
    private String maQuyenSach;
    private String maISBN;
    private Float doHuHao;
    private boolean trangThai;
    private boolean tinhTrang;

    public ChiTietSach() {
    }

    public ChiTietSach(String id, String idDauSach, String maQuyenSach, String maISBN, Float doHuHao, boolean trangThai, boolean tinhTrang) {
        this.id = id;
        this.idDauSach = idDauSach;
        this.maQuyenSach = maQuyenSach;
        this.maISBN = maISBN;
        this.doHuHao = doHuHao;
        this.trangThai = trangThai;
        this.tinhTrang = tinhTrang;
    }

    public ChiTietSach(String idDauSach, String maISBN, Float doHuHao, boolean trangThai, boolean tinhTrang) {
        this.idDauSach = idDauSach;
        this.maISBN = maISBN;
        this.doHuHao = doHuHao;
        this.trangThai = trangThai;
        this.tinhTrang = tinhTrang;
    }

    

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getIdDauSach() {
        return idDauSach;
    }

    public void setIdDauSach(String idDauSach) {
        this.idDauSach = idDauSach;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(String maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public String getMaISBN() {
        return maISBN;
    }

    public void setMaISBN(String maISBN) {
        this.maISBN = maISBN;
    }

    public Float getDoHuHao() {
        return doHuHao;
    }

    public void setDoHuHao(Float doHuHao) {
        this.doHuHao = doHuHao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
