package viewModel;

public class phieuTraViewModel {

    String maPhieuTra, maPhieuMuon, tenDocGia, diaChiDocGia, ngayMuon, ngayHenTra, ngayTra, ghiChu;

    String maISBN;

    public phieuTraViewModel() {
    }

    public phieuTraViewModel(String maPhieuTra, String maPhieuMuon, String tenDocGia, String diaChiDocGia, String ngayMuon, String ngayHenTra, String ngayTra, String ghiChu) {
        this.maPhieuTra = maPhieuTra;
        this.maPhieuMuon = maPhieuMuon;
        this.tenDocGia = tenDocGia;
        this.diaChiDocGia = diaChiDocGia;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
    }

    public phieuTraViewModel(String ngayTra, String ghiChu, String maISBN) {
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
        this.maISBN = maISBN;
    }

    

    public String getMaISBN() {
        return maISBN;
    }

    public void setMaISBN(String maISBN) {
        this.maISBN = maISBN;
    }

    public String getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(String maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getDiaChiDocGia() {
        return diaChiDocGia;
    }

    public void setDiaChiDocGia(String diaChiDocGia) {
        this.diaChiDocGia = diaChiDocGia;
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

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
