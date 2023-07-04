package service;

import java.util.ArrayList;
import repository.phieuTraRepository;
import viewModel.phieuMuonInTraSach;
import viewModel.phieuTraViewModel;

public class phieuTraService {

    private phieuTraRepository ptRepo;

    public phieuTraService() {
        this.ptRepo = new phieuTraRepository();
    }

    public ArrayList<phieuTraViewModel> getAllListPhieuTra() {
        return ptRepo.getAllListPhieuTra();
    }

    public void insertPhieuTraTraSach(String maPM, String ngayTra, String ghiChu) {
        this.ptRepo.insertPhieuTraTraSach(maPM, ngayTra, ghiChu);
    }

    public String checkMaISBN(String maISBN) {
        return this.ptRepo.checkMaISBN(maISBN);
    }

    public String getMaTTV(String maPhieuMuon) {
        return ptRepo.getMaTTV(maPhieuMuon);
    }

    public ArrayList<phieuMuonInTraSach> searchPhieuMuonByMaTTV(String maTTV) {
        return ptRepo.searchPhieuMuonByMaTTV(maTTV);
    }

    public String checkTrungSachh(String maQuyenSach, String maPhieuTra) {
        return ptRepo.checkTrungSachh(maQuyenSach, maPhieuTra);
    }
}
