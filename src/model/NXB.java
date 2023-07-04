/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class NXB {
    private String id;
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    private String sdt;
    private String email;
    private String website;

    public NXB() {
    }

    public NXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public NXB(String id, String maNXB, String tenNXB, String diaChi, String sdt, String email, String website) {
        this.id = id;
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "NXB{" + "id=" + id + ", maNXB=" + maNXB + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", website=" + website + '}';
    }
    
}
