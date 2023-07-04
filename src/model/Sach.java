/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Sach {

    private String id;
    private String tenSach;
    private String maSach;
    private String tenTacGia;
    private NXB nxb;
    private TheLoai theLoai;
    private Integer namXB;
    private Integer gia;
    private Integer soTrang;
    private Integer soLuong;
    private String anh;

    public Sach() {
    }

    public Sach(String tenSach, String tenTacGia, NXB nxb, TheLoai theLoai, Integer namXB, Integer gia, Integer soTrang, String anh) {
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.nxb = nxb;
        this.theLoai = theLoai;
        this.namXB = namXB;
        this.gia = gia;
        this.soTrang = soTrang;
        this.anh = anh;
    }

    public Sach(String id, String tenSach, String maSach, String tenTacGia, NXB nxb, TheLoai theLoai, Integer namXB, Integer gia, Integer soTrang, Integer soLuong, String anh) {
        this.id = id;
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.tenTacGia = tenTacGia;
        this.nxb = nxb;
        this.theLoai = theLoai;
        this.namXB = namXB;
        this.gia = gia;
        this.soTrang = soTrang;
        this.soLuong = soLuong;
        this.anh = anh;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public NXB getNxb() {
        return nxb;
    }

    public void setNxb(NXB nxb) {
        this.nxb = nxb;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public Integer getNamXB() {
        return namXB;
    }

    public void setNamXB(Integer namXB) {
        this.namXB = namXB;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(Integer soTrang) {
        this.soTrang = soTrang;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "Sach{" + "id=" + id + ", tenSach=" + tenSach + ", maSach=" + maSach + ", tenTacGia=" + tenTacGia + ", nxb=" + nxb + ", theLoai=" + theLoai + ", namXB=" + namXB + ", gia=" + gia + ", soTrang=" + soTrang + ", anh=" + anh + '}';
    }

}
