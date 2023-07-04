package service;

import java.util.ArrayList;
import repository.phieuDenRepository;
import viewModel.phieuDenSearchByMaTTVViewModel;
import viewModel.phieuDenViewModel;

public class phieuDenService {

    private phieuDenRepository pdRepo;

    public phieuDenService() {
        pdRepo = new phieuDenRepository();
    }

    public ArrayList<phieuDenSearchByMaTTVViewModel> getAllSachByMaTTV(String maTheThuVien) {
        return pdRepo.getAllSachByMaTTV(maTheThuVien);
    }

    public ArrayList<phieuDenViewModel> getAllListPhieuDen() {
        return pdRepo.getAllListPhieuDen();
    }

    public void insertPhieuDen(String maPhieuMuon, String maNhanVien, String maTTV, String soTienPhat, String ngayPhat, String lyDoPhat) {
        this.pdRepo.insertPhieuDen(maPhieuMuon, maNhanVien, maTTV, soTienPhat, ngayPhat, lyDoPhat);
    }

}
