
package viewModel;

public class phieuMuonViewModel {
    private String maPhieuMuon,
                   maTTV,
                   tenDocGia,
                   diaChi,
                   ngayMuon,
                   ngayTra,
                   ngayHenTra,
                   ghiChu;
    private double tienCoc;

    public phieuMuonViewModel() {
    }

    public phieuMuonViewModel(String maPhieuMuon, String maTTV, String tenDocGia, String diaChi, String ngayMuon, String ngayTra, String ngayHenTra, String ghiChu, double tienCoc) {
        this.maPhieuMuon = maPhieuMuon;
        this.maTTV = maTTV;
        this.tenDocGia = tenDocGia;
        this.diaChi = diaChi;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ngayHenTra = ngayHenTra;
        this.ghiChu = ghiChu;
        this.tienCoc = tienCoc;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaTTV() {
        return maTTV;
    }

    public void setMaTTV(String maTTV) {
        this.maTTV = maTTV;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
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
