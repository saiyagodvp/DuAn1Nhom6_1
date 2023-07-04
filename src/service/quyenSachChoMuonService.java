package service;

import model.quyenSachChoMuon;
import repository.quyenSachChoMuonRepository;

public class quyenSachChoMuonService {

    private quyenSachChoMuonRepository qsRepo;

    public quyenSachChoMuonService() {
        this.qsRepo = new quyenSachChoMuonRepository();
    }

    public void insertQuyenSachChiTietChoMuonChoMuon(quyenSachChoMuon qs) {
        this.qsRepo.insertQuyenSachChiTietChoMuonChoMuon(qs);
    }

    public void deleteQuyenSachChiTietChoMuonChoMuon(String maISBN) {
        this.qsRepo.deleteQuyenSachChiTietChoMuonChoMuon(maISBN);
    }
}
