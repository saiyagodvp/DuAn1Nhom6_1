package viewModel;

public class phieuDenChiTietViewModel {

    private String maPhieuDen, maQuyenSach, tenSach, tinhTrangSach;
    private double doHuHao;

    public phieuDenChiTietViewModel() {
    }

    public phieuDenChiTietViewModel(String maPhieuDen, String maQuyenSach, String tenSach, String tinhTrangSach, double doHuHao) {
        this.maPhieuDen = maPhieuDen;
        this.maQuyenSach = maQuyenSach;
        this.tenSach = tenSach;
        this.tinhTrangSach = tinhTrangSach;
        this.doHuHao = doHuHao;
    }

    public String getMaPhieuDen() {
        return maPhieuDen;
    }

    public void setMaPhieuDen(String maPhieuDen) {
        this.maPhieuDen = maPhieuDen;
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
