package service;

import java.util.ArrayList;
import model.phieuMuonChiTietChoMuon;
import repository.phieuMuonChiTietRepository;
import viewModel.phieuMuonChiTietViewModel;

public class phieuMuonChiTietService {

    private phieuMuonChiTietRepository pmctRepo;

    public phieuMuonChiTietService() {
        this.pmctRepo = new phieuMuonChiTietRepository();
    }

    public ArrayList<phieuMuonChiTietViewModel> getAllListPhieuMuonChiTiet(String maPhieuMuon) {
        return pmctRepo.getAllListPhieuMuonChiTiet(maPhieuMuon);
    }

    public void insertPhieuMuonChiTietChoMuonChoMuon(phieuMuonChiTietChoMuon pm) {
        this.pmctRepo.insertPhieuMuonChiTietChoMuonChoMuon(pm);
    }

    public String checkTrungSach(String maISBN) {
        return pmctRepo.checkTrungSach(maISBN);
    }

    public String checkMaISBN(String maISBN) {
        return pmctRepo.checkMaISBN(maISBN);
    }

    public String checkMaISBNGetMaQuyenSach(String maISBN) {
        return pmctRepo.checkMaISBNGetMaQuyenSach(maISBN);
    }

    public void deletePhieuMuonChiTietChoMuonChoMuon(String maISBN) {
        this.pmctRepo.deletePhieuMuonChiTietChoMuonChoMuon(maISBN);
    }

    public void updateDaMuonPhieuMuonChiTietChoMuonChoMuon(String maISBN) {
        this.pmctRepo.updateDaMuonPhieuMuonChiTietChoMuonChoMuon(maISBN);
    }

    public void updateChuaMuonPhieuMuonChiTietChoMuonChoMuon(String maQuyenSach) {
        this.pmctRepo.updateChuaMuonPhieuMuonChiTietChoMuonChoMuon(maQuyenSach);
    }

    public String getMaISBNByMaQuyenSach(String maQuyenSach) {
        return pmctRepo.getMaISBNByMaQuyenSach(maQuyenSach);
    }

    public void updateSoLuongDaChoMuon(String maISBN) {
        this.pmctRepo.updateSoLuongDaChoMuon(maISBN);
    }

    public void updateSoLuongChuaChoMuon(String maQuyenSach) {
        this.pmctRepo.updateSoLuongChuaChoMuon(maQuyenSach);
    }
}
