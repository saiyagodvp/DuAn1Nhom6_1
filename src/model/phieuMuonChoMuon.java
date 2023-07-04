
package model;


public class phieuMuonChoMuon {
    private String  maTTV;
    private String  ngayMuon;
    private String  ngayHenTra;
    private String  ghiChu;
    private double  tienCoc;

    public phieuMuonChoMuon() {
    }

    public phieuMuonChoMuon(String maTTV, String ngayMuon, String ngayHenTra, String ghiChu, double tienCoc) {
        this.maTTV = maTTV;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ghiChu = ghiChu;
        this.tienCoc = tienCoc;
    }

    public String getMaTTV() {
        return maTTV;
    }

    public void setMaTTV(String maTTV) {
        this.maTTV = maTTV;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(String ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(double tienCoc) {
        this.tienCoc = tienCoc;
    }
    
    
}
