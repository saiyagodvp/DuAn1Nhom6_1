package viewModel;

public class phieuDenSearchByMaTTVViewModel {

    private String maPhieuMuon, maQuyenSach, tenSach, ngayMuon, ngayHenTra, tenNguoiMuon, tinhTrangSach;
    private double doHuHao;

    public phieuDenSearchByMaTTVViewModel() {
    }

    public phieuDenSearchByMaTTVViewModel(String maPhieuMuon, String maQuyenSach, String tenSach, String ngayMuon, String ngayHenTra, String tenNguoiMuon, String tinhTrangSach, double doHuHao) {
        this.maPhieuMuon = maPhieuMuon;
        this.maQuyenSach = maQuyenSach;
        this.tenSach = tenSach;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.tenNguoiMuon = tenNguoiMuon;
        this.tinhTrangSach = tinhTrangSach;
        this.doHuHao = doHuHao;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(String maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public String getTinhTrangSach() {
        return tinhTrangSach;
    }

    public void setTinhTrangSach(String tinhTrangSach) {
        this.tinhTrangSach = tinhTrangSach;
    }

    public double getDoHuHao() {
        return doHuHao;
    }

    public void setDoHuHao(double doHuHao) {
        this.doHuHao = doHuHao;
    }

    public String getTinhTrangSachSTR() {
        if (tinhTrangSach.equalsIgnoreCase("0")) {
            return "Sách Cũ";
        } else {
            return "Sách Mới";
        }
    }

}
