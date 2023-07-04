package viewModel;

public class phieuMuonChiTietViewModel {

    private String maPhieuMuon,
            maQuyenSach,
            tenSach;
    private int soTrang;
    private boolean tinhTrangSach;
    private double doHuHao;

    public phieuMuonChiTietViewModel() {
    }

    public phieuMuonChiTietViewModel(String maPhieuMuon, String maQuyenSach, String tenSach, int soTrang, boolean tinhTrangSach, double doHuHao) {
        this.maPhieuMuon = maPhieuMuon;
        this.maQuyenSach = maQuyenSach;
        this.tenSach = tenSach;
        this.soTrang = soTrang;
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

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public boolean isTinhTrangSach() {
        return tinhTrangSach;
    }

    public void setTinhTrangSach(boolean tinhTrangSach) {
        this.tinhTrangSach = tinhTrangSach;
    }

    public double getDoHuHao() {
        return doHuHao;
    }

    public void setDoHuHao(double doHuHao) {
        this.doHuHao = doHuHao;
    }

    public String getTinhTrangSachString() {
        if (tinhTrangSach == true) {
            return "Sách Mới!";
        } else {
            return "Sách Cũ!";
        }
    }
}
