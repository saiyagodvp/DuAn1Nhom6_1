package model;

public class phieuMuonChiTietChoMuon {

    private String maPhieuMuon;
    private String maISBN;

    public phieuMuonChiTietChoMuon() {
    }

    public phieuMuonChiTietChoMuon(String maPhieuMuon, String maISBN) {
        this.maPhieuMuon = maPhieuMuon;
        this.maISBN = maISBN;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaISBN() {
        return maISBN;
    }

    public void setMaISBN(String maISBN) {
        this.maISBN = maISBN;
    }

}
