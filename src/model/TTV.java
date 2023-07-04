/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phngn
 */
public class TTV {
     private String idttv;
    private String iddocgia;
    private String mattv;
    private String ngaycap;
    private String ngayhethan;
    private String ghichu;
    private String trangthai;

    public TTV() {
    }

    public TTV(String idttv, String iddocgia, String mattv, String ngaycap, String ngayhethan, String ghichu, String trangthai) {
        this.idttv = idttv;
        this.iddocgia = iddocgia;
        this.mattv = mattv;
        this.ngaycap = ngaycap;
        this.ngayhethan = ngayhethan;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    public String getIdttv() {
        return idttv;
    }

    public void setIdttv(String idttv) {
        this.idttv = idttv;
    }

    public String getIddocgia() {
        return iddocgia;
    }

    public void setIddocgia(String iddocgia) {
        this.iddocgia = iddocgia;
    }

    public String getMattv() {
        return mattv;
    }

    public void setMattv(String mattv) {
        this.mattv = mattv;
    }

    public String getNgaycap() {
        return ngaycap;
    }

    public void setNgaycap(String ngaycap) {
        this.ngaycap = ngaycap;
    }

    public String getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(String ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "TTV{" + "idttv=" + idttv + ", iddocgia=" + iddocgia + ", mattv=" + mattv + ", ngaycap=" + ngaycap + ", ngayhethan=" + ngayhethan + ", ghichu=" + ghichu + ", trangthai=" + trangthai + '}';
    }
    
}
