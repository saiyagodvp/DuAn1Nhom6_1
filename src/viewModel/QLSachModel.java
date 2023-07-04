/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author ACER
 */
public class QLSachModel {

    private String maSach;
    private String tenSach;
    private String tentacGia;
    private String tenTheLoai;
    private String tenNXB;
    private Integer namXB;
    private Integer gia;
    private Integer soTrang;
    private Integer soLuong;

    public QLSachModel() {
    }

    public QLSachModel(String maSach, String tenSach, String tentacGia, String tenTheLoai, String tenNXB, Integer namXB, Integer gia, Integer soTrang, Integer soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tentacGia = tentacGia;
        this.tenTheLoai = tenTheLoai;
        this.tenNXB = tenNXB;
        this.namXB = namXB;
        this.gia = gia;
        this.soTrang = soTrang;
        this.soLuong = soLuong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTentacGia() {
        return tentacGia;
    }

    public void setTentacGia(String tentacGia) {
        this.tentacGia = tentacGia;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
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

}
