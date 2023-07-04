package viewModel;

public class phieuTraChiTietTraSachViewModel {

    private String maPhieuTra, maQuyenSach, tenSach;
    private String tinhTrangSach;
    private double doHuHao;

    public phieuTraChiTietTraSachViewModel() {
    }

    public phieuTraChiTietTraSachViewModel(String maPhieuTra, String maQuyenSach, String tenSach, String tinhTrangSach, double doHuHao) {
        this.maPhieuTra = maPhieuTra;
        this.maQuyenSach = maQuyenSach;
        this.tenSach = tenSach;
        this.tinhTrangSach = tinhTrangSach;
        this.doHuHao = doHuHao;
    }

    public String getTinhTrangSachString() {
        if (doHuHao <= 100 && doHuHao >= 80) {
            return "Sách Mới!";
        } else {
            return "Sách Cũ!";
        }
    }

    public String getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(String maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
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
}
