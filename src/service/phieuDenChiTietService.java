package service;

import java.util.ArrayList;
import repository.phieuDenChiTietRepository;
import viewModel.phieuDenChiTietViewModel;

public class phieuDenChiTietService {

    private phieuDenChiTietRepository pdctRepo;

    public phieuDenChiTietService() {
        this.pdctRepo = new phieuDenChiTietRepository();
    }

    public ArrayList<phieuDenChiTietViewModel> getAllListPhieuDenChiTietByMaPhieuDen(String maPhieuDen) {
        return pdctRepo.getAllListPhieuDenChiTietByMaPhieuDen(maPhieuDen);
    }

    public void insertPhieuDenChiTiet(String maPhieuDen, String maQuyenSach, String tenSach) {
        this.pdctRepo.insertPhieuDenChiTiet(maPhieuDen, maQuyenSach, tenSach);
    }

    public String checkTrungSach(String maPhieuDen, String maQuyenSach) {
        return pdctRepo.checkTrungSach(maPhieuDen, maQuyenSach);
    }
    
    public void updatePhieuDenChiTiet(String doHuHao, String maQuyenSach, String maPhieuDen) {
        this.pdctRepo.updatePhieuDenChiTiet(doHuHao, maQuyenSach, maPhieuDen);
    }
}
