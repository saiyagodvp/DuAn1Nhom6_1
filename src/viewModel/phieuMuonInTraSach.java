package viewModel;

public class phieuMuonInTraSach {
    private String maPM;
    private String maTTV;
    private String tenNguoiMuon;
    private String ngayMuon;
    private String ngayHenTra;
    private String ghiChu;

    public phieuMuonInTraSach() {
    }

    public phieuMuonInTraSach(String maPM, String maTTV, String tenNguoiMuon, String ngayMuon, String ngayHenTra, String ghiChu) {
        this.maPM = maPM;
        this.maTTV = maTTV;
        this.tenNguoiMuon = tenNguoiMuon;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ghiChu = ghiChu;
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public String getMaTTV() {
        return maTTV;
    }

    public void setMaTTV(String maTTV) {
        this.maTTV = maTTV;
    }

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
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
    
    
}
