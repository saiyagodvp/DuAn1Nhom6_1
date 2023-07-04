package service;

import java.util.ArrayList;
import model.phieuMuonChoMuon;
import repository.phieuMuonRepository;
import viewModel.phieuMuonViewModel;

public class phieuMuonService {

    phieuMuonRepository pmRepo;

    public phieuMuonService() {
        this.pmRepo = new phieuMuonRepository();
    }

    public ArrayList<phieuMuonViewModel> getAllListPhieuMuon() {
        return pmRepo.getAllListPhieuMuon();
    }

    public void insertPhieuMuonChoMuon(phieuMuonChoMuon pm) {
        this.pmRepo.insertPhieuMuonChoMuon(pm);
    }

    public String checkMaTTV(String maTTV) {
        return pmRepo.checkMaTTV(maTTV);
    }

    public void updatePhieuMuonChoMuon(phieuMuonChoMuon pm, String maPM) {
        this.pmRepo.updatePhieuMuonChoMuon(pm, maPM);
    }

    public String checkMaTTVConHieuLuc(String maTTV) {
        return this.pmRepo.checkMaTTVConHieuLuc(maTTV);
    }

}
