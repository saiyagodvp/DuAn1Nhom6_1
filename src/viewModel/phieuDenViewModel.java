package viewModel;

public class phieuDenViewModel {

    private String maPhieuDen, maPhieuMuon, maNV, maTTV, tenDocGia;
    private double soTienPhat;
    private String ngayPhat;
    private String lyDoPhat;

    public phieuDenViewModel() {
    }

    public phieuDenViewModel(String maPhieuDen, String maPhieuMuon, String maNV, String maTTV, String tenDocGia, double soTienPhat, String ngayPhat, String lyDoPhat) {
        this.maPhieuDen = maPhieuDen;
        this.maPhieuMuon = maPhieuMuon;
        this.maNV = maNV;
        this.maTTV = maTTV;
        this.tenDocGia = tenDocGia;
        this.soTienPhat = soTienPhat;
        this.ngayPhat = ngayPhat;
        this.lyDoPhat = lyDoPhat;
    }

    public String getMaPhieuDen() {
        return maPhieuDen;
    }

    public void setMaPhieuDen(String maPhieuDen) {
        this.maPhieuDen = maPhieuDen;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public double getSoTienPhat() {
        return soTienPhat;
    }

    public void setSoTienPhat(double soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    public String getNgayPhat() {
        return ngayPhat;
    }

    public void setNgayPhat(String ngayPhat) {
        this.ngayPhat = ngayPhat;
    }

    public String getLyDoPhat() {
        return lyDoPhat;
    }

    public void setLyDoPhat(String lyDoPhat) {
        this.lyDoPhat = lyDoPhat;
    }

}
