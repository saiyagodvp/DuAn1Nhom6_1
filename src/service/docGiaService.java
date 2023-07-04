package service;

import java.util.ArrayList;
import model.docGiaModel;
import repository.docGiaRepository;
import viewModel.cbbMaDocGia;

public class docGiaService {

    private docGiaRepository dgRepo;

    public docGiaService() {
        this.dgRepo = new docGiaRepository();
    }

    public ArrayList<docGiaModel> getAllListDocGia() {
        return dgRepo.getAllListDocGia();
    }

    public void insertDocGia(docGiaModel dg) {
        this.dgRepo.insertDocGia(dg);
    }

    public void updateDocGia(docGiaModel dg, String maDocGia) {
        this.dgRepo.updateDocGia(dg, maDocGia);
    }

    public ArrayList<docGiaModel> searchDocGia(String maDocGia) {
        return dgRepo.searchDocGia(maDocGia);
    }

    public ArrayList<cbbMaDocGia> getAllMaDocGia() {
        return dgRepo.getAllMaDocGia();
    }
}
