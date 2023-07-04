package service;

import java.util.ArrayList;
import repository.theThuVienRepository;
import viewModel.theThuVienViewModel;

public class theThuVienService {

    private theThuVienRepository ttvRepo;

    public theThuVienService() {
        this.ttvRepo = new theThuVienRepository();
    }

    public ArrayList<theThuVienViewModel> getAllListTTV() {
        return this.ttvRepo.getAllListTTV();
    }
    
    public void insertTheThuVien(String maDocGia, String ngayCap, String ngayHetHan, String ghiChu) {
        this.ttvRepo.insertTheThuVien(maDocGia, ngayCap, ngayHetHan, ghiChu);
    }
    
    public void upadateTheThuVien(String maTheThuVien) {
        this.ttvRepo.upadateTheThuVien(maTheThuVien);
    }
}
