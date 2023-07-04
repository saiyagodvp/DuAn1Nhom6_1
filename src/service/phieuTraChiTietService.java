package service;

import java.util.ArrayList;
import repository.phieuTraChiTietRepository;
import viewModel.phieuTraChiTietTraSachViewModel;

public class phieuTraChiTietService {

    private phieuTraChiTietRepository ptctRepo;

    public phieuTraChiTietService() {
        this.ptctRepo = new phieuTraChiTietRepository();
    }

    public ArrayList<phieuTraChiTietTraSachViewModel> getAllListPhieuTraChiTiet(String maPhieuTra) {
        return ptctRepo.getAllListPhieuTraChiTiet(maPhieuTra);
    }

    public void insertPhieuTraChiTiet(String maPhieuTra, String maQuyenSach, String tenSach, String tinhTrangSach, String doHuHao) {
        this.ptctRepo.insertPhieuTraChiTiet(maPhieuTra, maQuyenSach, tenSach, tinhTrangSach, doHuHao);
    }

    public String checkMaISBN(String maISBN, String maPhieuTra) {
        return this.ptctRepo.checkMaISBN(maISBN, maPhieuTra);
    }

    public void updatePhieuTraChiTiet(double doHuHao, String maPhieuTra, String maQuyenSach) {
        this.ptctRepo.updatePhieuTraChiTiet(doHuHao, maPhieuTra, maQuyenSach);
    }

    public String getMaISBN(String maQuyenSach) {
        return ptctRepo.getMaISBN(maQuyenSach);
    }
    
    public void updateQuyenSachByPhieuTraChiTiet(double doHuHao, String maQuyenSach) {
        this.ptctRepo.updateQuyenSachByPhieuTraChiTiet(doHuHao, maQuyenSach);
    }
}
