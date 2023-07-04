package model;

public class quyenSachChoMuon {

    private String maQuyenSach, maPhieuMuon;

    public quyenSachChoMuon() {
    }

    public quyenSachChoMuon(String maQuyenSach, String maPhieuMuon) {
        this.maQuyenSach = maQuyenSach;
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(String maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }
    
    
}
