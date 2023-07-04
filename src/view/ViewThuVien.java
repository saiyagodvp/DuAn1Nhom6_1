/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NXB;
import model.NhanVien;
import model.Sach;
import model.TheLoai;
import model.docGiaModel;
import model.phieuMuonChiTietChoMuon;
import model.phieuMuonChoMuon;
import model.quyenSachChoMuon;
import service.NXBSevice;
import service.NhanVienSevice;
import service.SachSevice;
import service.TheLoaiSevice;
import service.docGiaService;
import service.impl.NXBSeviceImpl;
import service.impl.NhanVienSeviceImpl;
import service.impl.SachSeviceImpl;
import service.impl.TheLoaiSeviceImpl;
import service.phieuDenChiTietService;
import service.phieuDenService;
import service.phieuMuonChiTietService;
import service.phieuMuonService;
import service.phieuTraChiTietService;
import service.phieuTraService;
import service.quyenSachChoMuonService;
import service.theThuVienService;
import viewModel.QLNhanVienModel;
import viewModel.phieuMuonViewModel;
import viewModel.QLSachModel;
import viewModel.cbbMaDocGia;
import viewModel.phieuDenChiTietViewModel;
import viewModel.phieuDenSearchByMaTTVViewModel;
import viewModel.phieuDenViewModel;
import viewModel.phieuMuonChiTietViewModel;
import viewModel.phieuTraChiTietTraSachViewModel;
import viewModel.phieuTraViewModel;
import viewModel.theThuVienViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import model.PhieuDenCT;
import model.PhieuDen_model;
import model.PhieuMuon;
import org.apache.log4j.BasicConfigurator;
import repository.NhanVienRepository;
import repository.PhieuDen_Repository;
import service.NhanVienSevice;
import service.PhieuDenSevice;
import service.impl.NhanVienSeviceImpl;
//import service.impl.PhieuDenSevicelmpl;
import viewModel.QLSachModel;
import viewModel.phieuMuonInTraSach;
import viewModel.quanlysachthethuvien;
//import viewModel.quanlysachthethuvien;

/**
 *
 * @author ACER
 */
public class ViewThuVien extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadScheduledExecutor(this);

    private String hotenDocGiaIntableDocGia;
    private String gioitinhDocGiaIntableDocGia;
    private String ngaysinhDocGiaIntableDocGia;
    private String diaChiDocGiaIntableDocGia;
    private String sdtDocGiaIntableDocGia;
    private String maDocGiaIntableDocGia;
    private String maDocGiaInComboboxMaDocGia;
    private String ghiChuInTheThuVien;
    private String maTheThuVienInTheThuVien;
    private theThuVienService ttvService;
    private phieuDenChiTietService pdctService;
    private docGiaService dgService;
    private String maQuyenSachInPhieuDen;
    private String tenSachInPhieuDen;
    private String maPhieuMuonInPhieuDen;
    private String maTTVInPhieuDen;
    private String ngayPhatInPhieuDen;
    private String maPhieuDenInPhieuDen;
    private String maQuyenSachInPhieuDenChiTiet;
    private String maPhieuMuonInTraSach;
    private String maQuyenSachInTraSach;
    private String tenSachInTraSach;
    private String tinhTrangSachInTraSach;
    private double doHuHaoSachInTraSach;
    private phieuDenService pdService;
    public CardLayout cardLayout;
    private SachSevice sachSevice;
    private phieuTraChiTietService ptctService;
    private TheLoaiSevice theLoaiSevice;
    private NXBSevice nXBSevice;
    private NhanVienSevice nhanVienSevice;
    private List<Sach> listSach = new ArrayList<>();
    private List<NXB> listNXB = new ArrayList<>();
    private List<TheLoai> listTL = new ArrayList<>();
    private List<QLSachModel> listCTSP = new ArrayList<>();
    public String partfile1 = "";
    private String manv;
    private String hinhAnh;

    private phieuMuonService pmChoMuonService;
    private phieuMuonChiTietService pmctChoMuonService;

    private String maPhieuMuonChoMuon;
    private String maQuyenSachTrongPMCTChoMuon;
    private String maQuyenSachTrongQSCTChoMuon;
    private String ngayMuon;
    private String maPhieuTraXXX;
    private String maPhieuMuonXXX;
    private String maQuyenSachXXX;
    private String tenDocGiaXXX;
    private String maTTVXXX;
    private String ngayMuonXXX;
    private String ngayHenTraXXX;
    private String ngayTraXXX;
    private String GhiChuXXX;
    private String maISBNXXX;
    private phieuTraService ptService;
    private DefaultTableModel mol;
    private String imageSeleted = "";
    private ArrayList<QLNhanVienModel> lstNV = new ArrayList<>();

    private quyenSachChoMuonService qsService;

    /**
     * Creates new form ViewSach
     */
    DefaultTableModel dtm = new DefaultTableModel();
    String mattv = "";

    public ViewThuVien(String manv, String hinhAnh) {
        initComponents();
        setLocationRelativeTo(null);
        initWebcam();
        this.ttvService = new theThuVienService();
        this.pdctService = new phieuDenChiTietService();
        this.dgService = new docGiaService();
        this.pdService = new phieuDenService();
        this.txtGhiChuTraSach.setText("Trống");
        this.ptService = new phieuTraService();
        this.ptctService = new phieuTraChiTietService();
        qsService = new quyenSachChoMuonService();
        this.pmChoMuonService = new phieuMuonService();
        this.pmctChoMuonService = new phieuMuonChiTietService();
        cardLayout = (CardLayout) (ViewChucNang.getLayout());
        cardLayout.show(ViewChucNang, "ViewMuonSach");
        this.setTitle("Phần Mềm Quản Lý Thư Viện");
        sachSevice = new SachSeviceImpl();
        theLoaiSevice = new TheLoaiSeviceImpl();
        nXBSevice = new NXBSeviceImpl();
        this.manv = manv;
        this.hinhAnh = hinhAnh;
        lbAnhNVA.setIcon(new ImageIcon(hinhAnh));
        nhanVienSevice = new NhanVienSeviceImpl();
        NhanVien nv1 = nhanVienSevice.getOne(manv);
        lbTenNVA.setText(nv1.getHoTen());

        loadTablePhieuMuonChoMuon();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        ngayPhatInPhieuDen = dtf.format(now);
        this.txtNgayHenTraChoMuon.setText(dtf.format(now));
        maPhieuMuonChoMuon = "";
        loadTablePhieuMuonChiTietchoMuon();
        this.txtGhiChuChoMuon.setText("Trống!");
        this.txtTienCocChoMuon.setText("0");
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuDenResultSearch.getModel();
        model.setRowCount(0);
        loadTablePhieuTraTraSach();
        loadTablePhieuDen();
        DefaultTableModel modelZZ = (DefaultTableModel) this.tblPhieuDenChiTiet.getModel();
        modelZZ.setRowCount(0);
        loadTableDocGia();
        loadTableTheThuVien();
        loadCBBMaDocGia();
        loadCbbNXB();
        loadCbbTheLoai();
        loadDataToTableSach();
        loadTableNV();
        maDocGiaInComboboxMaDocGia = this.cbbMaDocGia.getItemAt(0);
        DefaultTableModel modelX = (DefaultTableModel) this.tblDanhSachPhieuMuonInTraSach.getModel();
        modelX.setRowCount(0);
    }

    public QLNhanVienModel getData() {
        String gt, cv;
        int tt;
        String hoTen = txtHoTenNV.getText();
        String sdt = txtSDTNV.getText();
        String tk = txtTenTaiKhoan.getText();
        String mk = txtMatKhau.getText();
        String ns = txtNgaySinh.getText();
        String dc = txtDiaChi.getText();
        if (rdbNam.isSelected()) {
            gt = "Nam";
        } else {
            gt = "Nữ";
        }
        cv = (String) cbbChucVu.getSelectedItem();
        if (rdbTrangThai.isSelected()) {
            tt = 1;
        } else {
            tt = 0;
        }
        QLNhanVienModel nv;
        if (imageSeleted.isEmpty()) {
            nv = new QLNhanVienModel("", hoTen, sdt, tk, mk, ns, gt, dc, cv, tt);
        } else {
            nv = new QLNhanVienModel("", hoTen, sdt, tk, mk, ns, gt, dc, cv, tt, imageSeleted);
        }

        return nv;
    }

    public void loadCbbNXB() {
        cbbNXB.removeAllItems();
        listNXB = nXBSevice.getAll();
        DefaultComboBoxModel dtcm1 = (DefaultComboBoxModel) this.cbbNXB.getModel();
        for (NXB nxb : listNXB) {
            dtcm1.addElement(nxb.getTenNXB());
        }
    }

    public void loadSach(List<quanlysachthethuvien> listsach) {

        dtm = (DefaultTableModel) tblPhieuPhat.getModel();
        dtm.setRowCount(0);
        for (quanlysachthethuvien s : listsach) {
            Object[] rowData = {
                s.getMaphieu(),
                s.getMasach(),
                s.getTensach(),
                s.getNgaymuon(),
                s.getNgaytra(),
                s.getHoten()
            };
            dtm.addRow(rowData);

        }
    }

    private void loadPhieuDenChiTiet(List<PhieuDenCT> pd) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuDenCT.getModel();
        int row = tblPhieuPhat.getSelectedRow();
        int row1 = tblPhieuPhat1.getSelectedRow();
        String tensach = tblPhieuPhat.getValueAt(row, 2).toString();
        String tenDOcGia = tblPhieuPhat.getValueAt(row, 5).toString();
        String lyDo = txtLyDoPhat.getText();

        String ngay = tblPhieuPhat1.getValueAt(row1, 4).toString();
        dtm.setRowCount(0);
        int count = pd.size();
        for (PhieuDenCT x : pd) {
            String stp = PhieuDen_Repository.getstpbyid(x.getId());
            Object[] rowData = {
                PhieuDen_Repository.getMaPDById(x.getId()),
                x.getMasach(),
                x.getTensach(),
                tenDOcGia,
                x.getDohuhao(),
                stp,
                ngay,
                x.getTinhtrangsach(),};
            dtm.addRow(rowData);
        }
    }

    private void loadPhieuDen(List<PhieuDen_model> pd) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuPhat1.getModel();
        int row = tblPhieuPhat.getSelectedRow();
        String lyDo = txtLyDoPhat.getText();
        String dohuhao = txtDoHuHao.getText();
        dtm.setRowCount(0);
        for (PhieuDen_model x : pd) {
            String tennv = PhieuDen_Repository.getTenNvById(x.getIdnhanvien());
            String mapm = PhieuDen_Repository.getMaPmById(x.getIdphieumuon());
            Object[] rowData = {
                x.getMapd(),
                mapm,
                tennv,
                mattv,
                x.getNgaytra(),};
            dtm.addRow(rowData);
        }

    }

    public void loadCbbTheLoai() {
        cbbTheLoai.removeAllItems();
        listTL = theLoaiSevice.getAll();
        DefaultComboBoxModel dtcm2 = (DefaultComboBoxModel) this.cbbTheLoai.getModel();
        for (TheLoai tl : listTL) {
            dtcm2.addElement(tl.getTenTL());
        }
    }

    public void loadTableNV() {
        mol = (DefaultTableModel) tbListQLNV.getModel();
        mol.setRowCount(0);
        lstNV = nhanVienSevice.getAll();
        for (QLNhanVienModel x : lstNV) {
            mol.addRow(new Object[]{
                x.getMa(), x.getHoten(), x.getChucVu(), x.getGioiTinh(), x.getNgaySinh(), x.getSdt(), x.tt(), x.getDiaChi(), x.getTenTaiKhoan(), "*******", x.getHinhAnh()
            });
        }
    }

    public void loadOnedNV(NhanVien nv) {
        mol = (DefaultTableModel) tbListQLNV.getModel();
        if (nv == null) {
            loadTableNV();
        }
        mol.setRowCount(0);
        mol.addRow(new Object[]{
            nv.getMa(), nv.getHoTen(), nv.getChucVu(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSdt(), nv.tt(), nv.getTenTaiKhoan(), nv.getMatKhau(), nv.getHinhAnh()
        });
    }

    public void refresh() {
        txtMaNV.setText("");
        txtHoTenNV.setText("");
        txtSDTNV.setText("");
        txtTenTaiKhoan.setText("");
        txtMatKhau.setText("");
        txtDiaChi.setText("");
        txtNgaySinh.setText("");
        rdbTrangThai.setSelected(false);
    }

    public void loadSach(int i) {
        listCTSP = sachSevice.getAll();
        QLSachModel qls = listCTSP.get(i);
        txtMaSach.setText(qls.getMaSach());
        txtTenSach.setText(qls.getTenSach());
        txtTacGia.setText(qls.getTentacGia());
        txtNamXuatBan.setText(String.valueOf(qls.getNamXB()));
        txtGiaCa.setText(String.valueOf(qls.getGia()));
        txtSoTrang.setText(String.valueOf(qls.getSoTrang()));
        cbbNXB.setSelectedItem(qls.getTenNXB());
        cbbTheLoai.setSelectedItem(qls.getTenTheLoai());
        Sach s = sachSevice.getOne(qls.getMaSach());
        lbAnhSach.setIcon(new ImageIcon(s.getAnh()));
    }

    public void loadDataToTableSach() {
        listCTSP = sachSevice.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tbListQLSACH.getModel();
        dtm.setRowCount(0);
        for (QLSachModel x : listCTSP) {
            Object[] rowData = {
                x.getMaSach(), x.getTenSach(), x.getTentacGia(), x.getTenTheLoai(), x.getTenNXB(), x.getNamXB(), x.getGia(), x.getSoTrang(), x.getSoLuong()};
            dtm.addRow(rowData);
        }

    }

    public ImageIcon sizeanh(String imgPath) {
        ImageIcon im = new ImageIcon(imgPath);
        Image img = im.getImage();
        Image newIg = img.getScaledInstance(lbAnhNV.getWidth(), lbAnhNV.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newIg);
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuChonAnh = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        menuChonNXB = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        menuChiTietSP = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chucNang = new javax.swing.JPanel();
        btnMuonSach = new javax.swing.JButton();
        btnQLPhieuMuon = new javax.swing.JButton();
        btnQLNhanVien = new javax.swing.JButton();
        btnQuanLySach = new javax.swing.JButton();
        btnTheThanhVien = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbAnhNVA = new javax.swing.JLabel();
        lbTenNVA = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        btnTraSach = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        ViewChucNang = new javax.swing.JPanel();
        ViewMuonSach = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblPhieuMuonChoMuon = new javax.swing.JTable();
        btnTaoPhieuMuon = new javax.swing.JButton();
        btnReloadTable = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtMaTTVChoMuon = new javax.swing.JTextField();
        lblTenDocGiaChoMuon = new javax.swing.JLabel();
        lblDiaChiChoMuon = new javax.swing.JLabel();
        txtNgayHenTraChoMuon = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtGhiChuChoMuon = new javax.swing.JTextArea();
        jPanel33 = new javax.swing.JPanel();
        btnLuuThongTin = new javax.swing.JButton();
        btnInPhieuMuon = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        txtTienCocChoMuon = new javax.swing.JTextField();
        panelWebCam = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblPhieuMuonChiTietChoMuon = new javax.swing.JTable();
        btnAddSachVaoPM = new javax.swing.JButton();
        txtMaISBNChoMuon = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        btnAddSachVaoPM1 = new javax.swing.JButton();
        ViewNhanVien = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        txtSDTNV = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        rdbTrangThai = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        txtTenTaiKhoan = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        rdbNam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        txtHoTenNV = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        lbAnhNV = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiemNV = new javax.swing.JTextField();
        btnTimKiemNV = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnThemNV = new javax.swing.JButton();
        btnCapNhatNV = new javax.swing.JButton();
        btnRefresh1 = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbListQLNV = new javax.swing.JTable();
        ViewPhieuMuon = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtTimKiemMaPhieuMuon = new javax.swing.JTextField();
        btnTimKiemPhieuMuon = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbListTTChiTietPM = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbListTTPhieuMuon = new javax.swing.JTable();
        ViewDocGia = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDocGia = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        txtHoTenDG = new javax.swing.JTextField();
        txtNgaySinhDG = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        rdoGioiTinhNamDG = new javax.swing.JRadioButton();
        rdoGioiTinhNuDG = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtDiaChiDG = new javax.swing.JTextArea();
        txtSDTDG = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        txtSearchDocGia = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblTheThuVien = new javax.swing.JTable();
        btnTaoTheThuVien = new javax.swing.JButton();
        cbbMaDocGia = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtGhiChuTheThuVien = new javax.swing.JTextArea();
        btnVoHieuHoaTheThuVien = new javax.swing.JButton();
        ViewSach = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnThemSach = new javax.swing.JButton();
        btnCapNhatSach = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        panelAnh = new javax.swing.JPanel();
        lbAnhSach = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiemSach = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbTheLoai = new javax.swing.JComboBox<>();
        cbbNXB = new javax.swing.JComboBox<>();
        txtNamXuatBan = new javax.swing.JTextField();
        txtGiaCa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSoTrang = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbListQLSACH = new javax.swing.JTable();
        ViewTraSach = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuTraTraSach = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuTraChiTietTraSach = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnCreatePhieuTra = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnCapNhatDoHuHao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChuTraSach = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtDoHuHaoTraSach = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tblDanhSachPhieuMuonInTraSach = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tblPhieuMuonChiTietInTraSach = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        txtMaTheThuVienSearchInTraSach = new javax.swing.JTextField();
        ViewPhieuDen = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMaTTVPhieuDen = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPhieuDenResultSearch = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPhieuDen = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblPhieuDenChiTiet = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        btnTaoPhieuDen = new javax.swing.JButton();
        btnThemVaoPhieuDen = new javax.swing.JButton();
        btn_capnhatttphieuden = new javax.swing.JButton();
        btn_in = new javax.swing.JButton();
        btnCapNhatDoHuHaoInPhieuDenChiTiet = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtSoTienPhatInPhieuDen = new javax.swing.JTextField();
        txtDoHuHaoInPhieuDen = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtLyDoPhatInPhieuDen = new javax.swing.JTextArea();
        btnTimSachhhhhh = new javax.swing.JButton();
        ViewPhieuDenAnhDat = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtLyDoPhat = new javax.swing.JTextArea();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblPhieuPhat1 = new javax.swing.JTable();
        txtSoTienPhat = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblPhieuDenCT = new javax.swing.JTable();
        btn_tao = new javax.swing.JButton();
        txtDoHuHao = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblPhieuPhat = new javax.swing.JTable();
        txt_maTTV = new javax.swing.JTextField();

        menuChonAnh.setText("Chọn Ảnh");
        menuChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChonAnhActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuChonAnh);

        menuChonNXB.setText("Chi Tiết NXB");
        menuChonNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChonNXBActionPerformed(evt);
            }
        });
        jPopupMenu2.add(menuChonNXB);

        menuChiTietSP.setText("Chi Tiết Sản Phẩm");
        menuChiTietSP.setToolTipText("");
        menuChiTietSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChiTietSPActionPerformed(evt);
            }
        });
        jPopupMenu3.add(menuChiTietSP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(java.awt.Color.lightGray);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Thư Viện");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        chucNang.setBackground(new java.awt.Color(153, 153, 153));
        chucNang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMuonSach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMuonSach.setText("Mượn Sách");
        btnMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonSachActionPerformed(evt);
            }
        });

        btnQLPhieuMuon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnQLPhieuMuon.setText("Quản Lý Phiếu Mượn");
        btnQLPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLPhieuMuonActionPerformed(evt);
            }
        });

        btnQLNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnQLNhanVien.setText("Quản Lý Nhân Viên");
        btnQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNhanVienActionPerformed(evt);
            }
        });

        btnQuanLySach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnQuanLySach.setText("Quản Lý Sách");
        btnQuanLySach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySachActionPerformed(evt);
            }
        });

        btnTheThanhVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTheThanhVien.setText("Thẻ Thư Viện");
        btnTheThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheThanhVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAnhNVA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lbAnhNVA, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbTenNVA.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbTenNVA.setForeground(new java.awt.Color(255, 0, 0));
        lbTenNVA.setText("Nguyễn Hàng");

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("Thoát");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnTraSach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTraSach.setText("Trả Sách");
        btnTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTraSachMouseClicked(evt);
            }
        });
        btnTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSachActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton9.setText("Quản Lý Phiếu Đền");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chucNangLayout = new javax.swing.GroupLayout(chucNang);
        chucNang.setLayout(chucNangLayout);
        chucNangLayout.setHorizontalGroup(
            chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnQLPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnQuanLySach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTheThanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTraSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(chucNangLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenNVA, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        chucNangLayout.setVerticalGroup(
            chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chucNangLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lbTenNVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnQLPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnQuanLySach, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTheThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chucNangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMuonSach, btnQLNhanVien, btnQLPhieuMuon, btnQuanLySach, btnTheThanhVien, btnTraSach, jButton7, jButton9});

        ViewChucNang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ViewChucNang.setPreferredSize(new java.awt.Dimension(972, 752));
        ViewChucNang.setLayout(new java.awt.CardLayout());

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 0, 51));
        jLabel54.setText("Cho Mượn");

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Phiếu Mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblPhieuMuonChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblPhieuMuonChoMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Thẻ Thư Viện", "Tên Đọc Giả", "Địa Chỉ", "Ngày Mượn", "Ngày Hẹn Trả", "Ghi Chú", "Tiền Cọc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuMuonChoMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuonChoMuonMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tblPhieuMuonChoMuon);

        btnTaoPhieuMuon.setBackground(new java.awt.Color(255, 255, 102));
        btnTaoPhieuMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoPhieuMuon.setText("Tạo Phiếu Mượn");
        btnTaoPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuMuonActionPerformed(evt);
            }
        });

        btnReloadTable.setBackground(new java.awt.Color(255, 255, 102));
        btnReloadTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReloadTable.setText("Reload Table");
        btnReloadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(btnTaoPhieuMuon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReloadTable)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieuMuon)
                    .addComponent(btnReloadTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText("Mã Thẻ Thư Viện:");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setText("Tên Đọc Giả:");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setText("Địa Chỉ:");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setText("Ngày Hẹn Trả");

        txtMaTTVChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblTenDocGiaChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenDocGiaChoMuon.setText("Nguyễn Văn A");

        lblDiaChiChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiaChiChoMuon.setText("Hà Nội");

        txtNgayHenTraChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setText("Ghi Chú");

        txtGhiChuChoMuon.setColumns(20);
        txtGhiChuChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGhiChuChoMuon.setRows(5);
        jScrollPane18.setViewportView(txtGhiChuChoMuon);

        jPanel33.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));

        btnLuuThongTin.setBackground(new java.awt.Color(255, 255, 102));
        btnLuuThongTin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuThongTin.setText("Lưu Thông Tin");
        btnLuuThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuThongTinActionPerformed(evt);
            }
        });

        btnInPhieuMuon.setBackground(new java.awt.Color(255, 255, 102));
        btnInPhieuMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInPhieuMuon.setText("In Phiếu Mượn");
        btnInPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuMuonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLuuThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnLuuThongTin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnInPhieuMuon)
                .addGap(27, 27, 27))
        );

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setText("Tiền Cọc");

        txtTienCocChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        panelWebCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel60))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDiaChiChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayHenTraChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienCocChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenDocGiaChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaTTVChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(txtMaTTVChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60)
                                    .addComponent(txtTienCocChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel56)
                                    .addComponent(lblTenDocGiaChoMuon)
                                    .addComponent(jLabel62))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel57)
                                            .addComponent(lblDiaChiChoMuon))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel58)
                                            .addComponent(txtNgayHenTraChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelWebCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Chi Tiết Phiếu Mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblPhieuMuonChiTietChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblPhieuMuonChiTietChoMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Phiếu Mượn", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuMuonChiTietChoMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuonChiTietChoMuonMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tblPhieuMuonChiTietChoMuon);

        btnAddSachVaoPM.setBackground(new java.awt.Color(255, 255, 102));
        btnAddSachVaoPM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddSachVaoPM.setText("Thêm Vào Phiếu Mượn");
        btnAddSachVaoPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSachVaoPMActionPerformed(evt);
            }
        });

        txtMaISBNChoMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setText("Mã ISBN Sách");

        btnAddSachVaoPM1.setBackground(new java.awt.Color(255, 255, 102));
        btnAddSachVaoPM1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddSachVaoPM1.setText("Xóa Khỏi Phiếu");
        btnAddSachVaoPM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSachVaoPM1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaISBNChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSachVaoPM)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSachVaoPM1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtMaISBNChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSachVaoPM)
                    .addComponent(btnAddSachVaoPM1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ViewMuonSachLayout = new javax.swing.GroupLayout(ViewMuonSach);
        ViewMuonSach.setLayout(ViewMuonSachLayout);
        ViewMuonSachLayout.setHorizontalGroup(
            ViewMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewMuonSachLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ViewMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ViewMuonSachLayout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ViewMuonSachLayout.setVerticalGroup(
            ViewMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewMuonSachLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ViewChucNang.add(ViewMuonSach, "ViewMuonSach");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Nhân VIên"));

        jLabel22.setText("Số Điện Thoại");

        jLabel23.setText("Mật Khẩu");

        txtMatKhau.setText("jPasswordField1");

        jLabel24.setText("Chức Vụ");

        jLabel26.setText("Trạng Thái");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Thủ Thư" }));
        cbbChucVu.setToolTipText("");

        rdbTrangThai.setText("Đang làm");

        jLabel25.setText("Tên Tài Khoản");

        jLabel29.setText("Ngày Sinh");

        jLabel32.setText("Địa Chỉ");

        jLabel33.setText("Giới Tính");

        buttonGroup1.add(rdbNam);
        rdbNam.setText("Nam");

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        jLabel31.setText("Họ Tên");

        lbAnhNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAnhNV.setIconTextGap(1);
        lbAnhNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnhNVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAnhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(lbAnhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(rdbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgaySinh)
                    .addComponent(txtDiaChi)
                    .addComponent(txtSDTNV)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(txtTenTaiKhoan)
                    .addComponent(txtHoTenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdbNam)
                                .addComponent(rdbNu)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(rdbTrangThai))
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("Nhân Viên");

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("Mã Nhân Viên");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(204, 51, 255));
        txtMaNV.setText("NV0000");

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("Tìm Kiếm");

        btnTimKiemNV.setBackground(new java.awt.Color(255, 255, 51));
        btnTimKiemNV.setText("Search");
        btnTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtTimKiemNV))
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addComponent(btnTimKiemNV)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemNV)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(39, 39, 39)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMaNV))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThemNV.setBackground(new java.awt.Color(255, 255, 102));
        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnCapNhatNV.setBackground(new java.awt.Color(255, 255, 51));
        btnCapNhatNV.setText("Cập Nhật");
        btnCapNhatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatNVActionPerformed(evt);
            }
        });

        btnRefresh1.setBackground(new java.awt.Color(255, 255, 51));
        btnRefresh1.setText("Refresh");
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        btnXoaNV.setBackground(new java.awt.Color(255, 255, 51));
        btnXoaNV.setText("Delete");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnThemNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(btnCapNhatNV))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnRefresh1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNV)
                    .addComponent(btnCapNhatNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh1)
                    .addComponent(btnXoaNV))
                .addContainerGap())
        );

        tbListQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Gioi Tính", "Ngày Sinh", "Số Điện Thoại", "Trang Thái", "Dia chi", "Tai Khoan", "Mat Khau", "Anh"
            }
        ));
        tbListQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListQLNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbListQLNVMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbListQLNVMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbListQLNV);

        javax.swing.GroupLayout ViewNhanVienLayout = new javax.swing.GroupLayout(ViewNhanVien);
        ViewNhanVien.setLayout(ViewNhanVienLayout);
        ViewNhanVienLayout.setHorizontalGroup(
            ViewNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewNhanVienLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ViewNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewNhanVienLayout.createSequentialGroup()
                        .addGroup(ViewNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(ViewNhanVienLayout.createSequentialGroup()
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(ViewNhanVienLayout.createSequentialGroup()
                        .addGroup(ViewNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        ViewNhanVienLayout.setVerticalGroup(
            ViewNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewNhanVienLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel28)
                .addGap(5, 5, 5)
                .addGroup(ViewNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        ViewChucNang.add(ViewNhanVien, "ViewNhanVien");

        ViewPhieuMuon.setPreferredSize(new java.awt.Dimension(966, 728));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 51));
        jLabel34.setText("Phiếu Mượn");

        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel35.setText("Tìm Kiếm");

        btnTimKiemPhieuMuon.setBackground(new java.awt.Color(255, 255, 102));
        btnTimKiemPhieuMuon.setText("Search");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnTimKiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtTimKiemMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemPhieuMuon))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Phiếu Mượn"));

        tbListTTChiTietPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tbListTTChiTietPM);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Phiếu Mượn"));

        lbListTTPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã PM", "Tên Đọc Giả", "Địa Chỉ Đọc Giả", "Ngày Mượn", "Ngày Hẹn Trả", "Ngày Trả", "Ghi Chú", "Tiền Cọc"
            }
        ));
        jScrollPane6.setViewportView(lbListTTPhieuMuon);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewPhieuMuonLayout = new javax.swing.GroupLayout(ViewPhieuMuon);
        ViewPhieuMuon.setLayout(ViewPhieuMuonLayout);
        ViewPhieuMuonLayout.setHorizontalGroup(
            ViewPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPhieuMuonLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ViewPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(752, Short.MAX_VALUE))
        );
        ViewPhieuMuonLayout.setVerticalGroup(
            ViewPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPhieuMuonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ViewChucNang.add(ViewPhieuMuon, "ViewPhieuMuon");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 51));
        jLabel40.setText("Đọc Giả");

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Độc Giả"));

        tblDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Độc Giả", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocGiaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDocGia);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Họ Tên:");

        txtHoTenDG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtNgaySinhDG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Ngày Sinh:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Giới Tính:");

        buttonGroup6.add(rdoGioiTinhNamDG);
        rdoGioiTinhNamDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoGioiTinhNamDG.setText("Nam");

        buttonGroup6.add(rdoGioiTinhNuDG);
        rdoGioiTinhNuDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoGioiTinhNuDG.setText("Nữ");
        rdoGioiTinhNuDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoGioiTinhNuDGActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Địa Chỉ:");

        txtDiaChiDG.setColumns(20);
        txtDiaChiDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDiaChiDG.setRows(5);
        jScrollPane13.setViewportView(txtDiaChiDG);

        txtSDTDG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Số Điện Thoại:");

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Controller"));

        jButton5.setText("Thêm Độc Giả");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Sửa Độc Giả");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(14, 14, 14))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(28, 28, 28)
                .addComponent(jButton6)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSearchDocGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearchDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDocGiaKeyReleased(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Tìm Kiếm Độc Giả Bằng Mã:");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel41)
                .addGap(38, 38, 38)
                .addComponent(txtSearchDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel39))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTenDG)
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addComponent(rdoGioiTinhNamDG)
                                        .addGap(145, 145, 145)
                                        .addComponent(rdoGioiTinhNuDG)
                                        .addGap(0, 235, Short.MAX_VALUE))
                                    .addComponent(txtSDTDG))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel38))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinhDG))
                                .addGap(74, 74, 74))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtHoTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(txtNgaySinhDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel37)
                                    .addComponent(rdoGioiTinhNamDG)
                                    .addComponent(rdoGioiTinhNuDG)
                                    .addComponent(jLabel38))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Độc Giả", jPanel24);

        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Thẻ Thư Viện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblTheThuVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblTheThuVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Thẻ Thư Viện", "Mã Độc Giả", "Tên Độc Giả", "Ngày Cấp ", "Ngày Hết Hạn", "Ghi Chú", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTheThuVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheThuVienMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblTheThuVien);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        btnTaoTheThuVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoTheThuVien.setText("Tạo Thẻ Thư Viện");
        btnTaoTheThuVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTheThuVienActionPerformed(evt);
            }
        });

        cbbMaDocGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("Mã Độc Giả:");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setText("Ghi Chú:");

        txtGhiChuTheThuVien.setColumns(20);
        txtGhiChuTheThuVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGhiChuTheThuVien.setRows(5);
        txtGhiChuTheThuVien.setText("Trống!");
        jScrollPane15.setViewportView(txtGhiChuTheThuVien);

        btnVoHieuHoaTheThuVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoHieuHoaTheThuVien.setText("Vô Hiệu Hóa");
        btnVoHieuHoaTheThuVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoHieuHoaTheThuVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane15)
                    .addComponent(cbbMaDocGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 740, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoTheThuVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoHieuHoaTheThuVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(186, 186, 186))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoTheThuVien)
                    .addComponent(cbbMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(26, 26, 26)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoHieuHoaTheThuVien)
                    .addComponent(jLabel43)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Thẻ Thư Viện", jPanel25);

        javax.swing.GroupLayout ViewDocGiaLayout = new javax.swing.GroupLayout(ViewDocGia);
        ViewDocGia.setLayout(ViewDocGiaLayout);
        ViewDocGiaLayout.setHorizontalGroup(
            ViewDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewDocGiaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(ViewDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewDocGiaLayout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        ViewDocGiaLayout.setVerticalGroup(
            ViewDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewDocGiaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        ViewChucNang.add(ViewDocGia, "ViewTheThuVien");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Sách");

        btnThemSach.setBackground(new java.awt.Color(255, 255, 102));
        btnThemSach.setText("Thêm");
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnCapNhatSach.setBackground(new java.awt.Color(255, 255, 51));
        btnCapNhatSach.setText("Cập Nhật");
        btnCapNhatSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSachActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(255, 255, 51));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        panelAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelAnhMouseReleased(evt);
            }
        });

        lbAnhSach.setIconTextGap(1);

        javax.swing.GroupLayout panelAnhLayout = new javax.swing.GroupLayout(panelAnh);
        panelAnh.setLayout(panelAnhLayout);
        panelAnhLayout.setHorizontalGroup(
            panelAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAnhLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbAnhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelAnhLayout.setVerticalGroup(
            panelAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAnhLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbAnhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Tìm Kiếm");

        btnTimKiemSach.setBackground(new java.awt.Color(255, 255, 51));
        btnTimKiemSach.setText("Search");
        btnTimKiemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtTimKiem))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(btnTimKiemSach)
                .addGap(112, 112, 112))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemSach)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sách"));

        jLabel4.setText("Tác Giả");

        jLabel5.setText("Năm Xuất Bản");

        jLabel6.setText("Thể Loại");

        jLabel7.setText("Nhà Xuất Bản");

        jLabel10.setText("Giá");

        cbbNXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbNXBMouseReleased(evt);
            }
        });

        jLabel1.setText("Số trang / Quyển");

        jLabel11.setText("Tên Sách");

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Mã Sách");

        txtMaSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSach.setForeground(new java.awt.Color(204, 51, 255));
        txtMaSach.setText("S0001");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSoTrang)
                            .addComponent(txtGiaCa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbNXB, javax.swing.GroupLayout.Alignment.LEADING, 0, 550, Short.MAX_VALUE)
                            .addComponent(cbbTheLoai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaSach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tbListQLSACH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Tên Tác Giả", "Tên Thể Loại", "Tên NXB", "NamXB", "Giá", "Số Trang", "Số Lượng"
            }
        ));
        tbListQLSACH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListQLSACHMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbListQLSACHMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbListQLSACH);

        javax.swing.GroupLayout ViewSachLayout = new javax.swing.GroupLayout(ViewSach);
        ViewSach.setLayout(ViewSachLayout);
        ViewSachLayout.setHorizontalGroup(
            ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSachLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewSachLayout.createSequentialGroup()
                        .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(ViewSachLayout.createSequentialGroup()
                                    .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCapNhatSach))
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ViewSachLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(btnRefresh))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        ViewSachLayout.setVerticalGroup(
            ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSachLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewSachLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ViewSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemSach)
                            .addComponent(btnCapNhatSach))
                        .addGap(34, 34, 34)
                        .addComponent(btnRefresh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ViewSachLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        ViewChucNang.add(ViewSach, "ViewSach");

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 0, 51));
        jLabel61.setText("Trả Sách");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Phiếu Trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblPhieuTraTraSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblPhieuTraTraSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Trả", "Mã Phiếu Mượn", "Tên Độc Giả", "Địa Chỉ Độc Giả", "Ngày Mượn", "Ngày Hẹn Trả", "Ngày Trả", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuTraTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuTraTraSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuTraTraSach);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Sách Trong Phiếu Trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblPhieuTraChiTietTraSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblPhieuTraChiTietTraSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Trả", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuTraChiTietTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuTraChiTietTraSachMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhieuTraChiTietTraSach);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCreatePhieuTra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreatePhieuTra.setText("Tạo Phiếu Trả");
        btnCreatePhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePhieuTraActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("ADD Sách Vào Phiếu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCapNhatDoHuHao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhatDoHuHao.setText("Cập Nhật Độ Hư Hao");
        btnCapNhatDoHuHao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDoHuHaoActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("In Phiếu Trả Và Trả Sách");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreatePhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCapNhatDoHuHao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addGap(69, 69, 69))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhatDoHuHao, btnCreatePhieuTra, jButton1, jButton2});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreatePhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatDoHuHao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(28, 28, 28))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCapNhatDoHuHao, btnCreatePhieuTra, jButton1, jButton2});

        txtGhiChuTraSach.setColumns(20);
        txtGhiChuTraSach.setRows(5);
        jScrollPane2.setViewportView(txtGhiChuTraSach);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Độ Hư Hao: ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Ghi Chú: ");

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Kết Quả Phiếu Mượn Tìm Được"));

        tblDanhSachPhieuMuonInTraSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblDanhSachPhieuMuonInTraSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Mượn", "Mã TTV", "Tên Người Mượn", "Ngày Mượn", "Ngày Hẹn Trả", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachPhieuMuonInTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhieuMuonInTraSachMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tblDanhSachPhieuMuonInTraSach);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Quyển Sách Trong Phiếu Mượn"));

        tblPhieuMuonChiTietInTraSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblPhieuMuonChiTietInTraSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Phiếu Mượn", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuMuonChiTietInTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuonChiTietInTraSachMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tblPhieuMuonChiTietInTraSach);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("Tìm Sách Bằng Mã Thẻ Thư Viện: ");

        txtMaTheThuVienSearchInTraSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaTheThuVienSearchInTraSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaTheThuVienSearchInTraSachKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDoHuHaoTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaTheThuVienSearchInTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(txtDoHuHaoTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtMaTheThuVienSearchInTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ViewTraSachLayout = new javax.swing.GroupLayout(ViewTraSach);
        ViewTraSach.setLayout(ViewTraSachLayout);
        ViewTraSachLayout.setHorizontalGroup(
            ViewTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewTraSachLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ViewTraSachLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ViewTraSachLayout.setVerticalGroup(
            ViewTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewTraSachLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ViewChucNang.add(ViewTraSach, "ViewTraSach");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Phiếu Đền");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Mã Thẻ Thư Viện:");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Kết Quả Những Quyển Sách Tìm Được"));

        tblPhieuDenResultSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Quyển Sách", "Tên Sách", "Ngày Mượn", "Ngày Hẹn Trả", "Tên Người Mượn", "Tình Trạng Sách", "Độ Hư Hao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuDenResultSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuDenResultSearchMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblPhieuDenResultSearch);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Phiếu Đền"));

        tblPhieuDen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Đền", "Mã Phiếu Mượn", "Mã Nhân Viên", "Mã Thẻ Thư Viện", "Tên Độc Giả", "Số Tiền Phạt", "Ngày Phạt", "Lý Do Phạt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuDen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuDenMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblPhieuDen);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Phiếu Đền"));

        tblPhieuDenChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Đền", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuDenChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuDenChiTietMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblPhieuDenChiTiet);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Controller"));

        btnTaoPhieuDen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoPhieuDen.setText("Tạo Phiếu Đền");
        btnTaoPhieuDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuDenActionPerformed(evt);
            }
        });

        btnThemVaoPhieuDen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemVaoPhieuDen.setText("Thêm Vào Phiếu Đền");
        btnThemVaoPhieuDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoPhieuDenActionPerformed(evt);
            }
        });

        btn_capnhatttphieuden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_capnhatttphieuden.setText("Cập Nhật Thông Tin Phiếu Đền");
        btn_capnhatttphieuden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatttphieudenActionPerformed(evt);
            }
        });

        btn_in.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_in.setText("In Phiếu Đền");
        btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inActionPerformed(evt);
            }
        });

        btnCapNhatDoHuHaoInPhieuDenChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhatDoHuHaoInPhieuDenChiTiet.setText("Cập Nhật Độ Hư Hao");
        btnCapNhatDoHuHaoInPhieuDenChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDoHuHaoInPhieuDenChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemVaoPhieuDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoPhieuDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_in, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhatDoHuHaoInPhieuDenChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_capnhatttphieuden, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(btnTaoPhieuDen)
                .addGap(18, 18, 18)
                .addComponent(btnThemVaoPhieuDen)
                .addGap(18, 18, 18)
                .addComponent(btn_capnhatttphieuden)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhatDoHuHaoInPhieuDenChiTiet)
                .addGap(18, 18, 18)
                .addComponent(btn_in)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Số Tiền Phạt:");

        txtSoTienPhatInPhieuDen.setText("0");

        txtDoHuHaoInPhieuDen.setText("0");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Độ Hư Hao:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Lý Do Phạt:");

        txtLyDoPhatInPhieuDen.setColumns(20);
        txtLyDoPhatInPhieuDen.setRows(5);
        txtLyDoPhatInPhieuDen.setText("Trống!");
        jScrollPane12.setViewportView(txtLyDoPhatInPhieuDen);

        btnTimSachhhhhh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimSachhhhhh.setText("Tìm Sách Bằng Mã Thẻ Thư Viện");
        btnTimSachhhhhh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSachhhhhhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewPhieuDenLayout = new javax.swing.GroupLayout(ViewPhieuDen);
        ViewPhieuDen.setLayout(ViewPhieuDenLayout);
        ViewPhieuDenLayout.setHorizontalGroup(
            ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPhieuDenLayout.createSequentialGroup()
                .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewPhieuDenLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewPhieuDenLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ViewPhieuDenLayout.createSequentialGroup()
                                .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewPhieuDenLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaTTVPhieuDen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimSachhhhhh)
                                        .addGap(35, 35, 35)
                                        .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoTienPhatInPhieuDen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDoHuHaoInPhieuDen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel20)
                                        .addGap(27, 27, 27)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))))
                .addContainerGap())
        );
        ViewPhieuDenLayout.setVerticalGroup(
            ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPhieuDenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16)
                .addGap(66, 66, 66)
                .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ViewPhieuDenLayout.createSequentialGroup()
                        .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtMaTTVPhieuDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoTienPhatInPhieuDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel18)
                                .addComponent(btnTimSachhhhhh)))
                        .addGap(29, 29, 29)
                        .addGroup(ViewPhieuDenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDoHuHaoInPhieuDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ViewChucNang.add(ViewPhieuDen, "ViewPhieuDen");

        txtLyDoPhat.setColumns(20);
        txtLyDoPhat.setRows(5);
        jScrollPane16.setViewportView(txtLyDoPhat);

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu đền", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14))); // NOI18N

        tblPhieuPhat1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Đền", "Mã phiếu mượn", "tên nhân viên", "mã thẻ thư viện", "ngày phạt", "số tiền phạt", "lý do phạt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuPhat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuPhat1MouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tblPhieuPhat1);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel44.setText("Quản Lý Phiếu Đền");

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu đèn chi tiết"));

        tblPhieuDenCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Đền", "mã sách", "tên sách", "Tên đọc giả", "Độ hư hao", "số tiền phạt", "ngày phạt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuDenCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuDenCTMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tblPhieuDenCT);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_tao.setText("Tạo Phiếu");
        btn_tao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoActionPerformed(evt);
            }
        });

        jLabel45.setText("Mã Thẻ Thư Viện:");

        jLabel46.setText("Độ hư hao");

        jButton10.setText("in phiếu");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel47.setText("Lý Do Phạt:");

        jButton11.setText("thêm Phiếu đền CT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("cập nhật thông tin");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel48.setText("Số Tiền Phạt:");

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "kết quả những cuốn sách tìm được", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Source Sans Pro Black", 0, 14))); // NOI18N

        tblPhieuPhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu mượn", "Mã quyển sách", "Tên Sách", "Ngày mượn", "ngày hẹn trả", "tên người mượn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuPhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuPhatMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tblPhieuPhat);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewPhieuDenAnhDatLayout = new javax.swing.GroupLayout(ViewPhieuDenAnhDat);
        ViewPhieuDenAnhDat.setLayout(ViewPhieuDenAnhDatLayout);
        ViewPhieuDenAnhDatLayout.setHorizontalGroup(
            ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSoTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_maTTV, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(118, 118, 118)
                                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel47))
                                .addGap(34, 34, 34)
                                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDoHuHao, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_tao, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12)
                                    .addComponent(jButton11)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(481, Short.MAX_VALUE))
        );
        ViewPhieuDenAnhDatLayout.setVerticalGroup(
            ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(txt_maTTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46)
                        .addComponent(txtDoHuHao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                                .addGroup(ViewPhieuDenAnhDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48)
                                    .addComponent(txtSoTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel47)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(ViewPhieuDenAnhDatLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_tao)
                        .addGap(24, 24, 24)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        ViewChucNang.add(ViewPhieuDenAnhDat, "ViewPhieuDenAnhDat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ViewChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, 1509, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                    .addComponent(chucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChonAnhActionPerformed
        lbAnhSach.setText("");
        JFileChooser chon = new JFileChooser();
        chon.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnvalue = chon.showOpenDialog(this);
        if (returnvalue == JFileChooser.APPROVE_OPTION) {
            File file = chon.getSelectedFile();
            String partfile = file.getAbsolutePath();
            partfile1 = file.getAbsolutePath().replace("/", ":");
            BufferedImage b;
            try {
                b = ImageIO.read(file);
                lbAnhSach.setIcon(new ImageIcon(b));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_menuChonAnhActionPerformed

    private void menuChonNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChonNXBActionPerformed
        ViewNXB view = new ViewNXB();
        view.setVisible(true);
    }//GEN-LAST:event_menuChonNXBActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
        webcam.close();
        ViewDangNhap dangNhap = new ViewDangNhap();
        dangNhap.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnTimKiemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSachActionPerformed

    }//GEN-LAST:event_btnTimKiemSachActionPerformed

    private void panelAnhMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAnhMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(panelAnh, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_panelAnhMouseReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtTenSach.setText("");
        txtMaSach.setText("");
        txtMatKhau.setText("*******");
        txtTacGia.setText("");
        cbbTheLoai.setSelectedIndex(0);
        cbbNXB.setSelectedItem(0);
        rdbTrangThai.setSelected(false);
        loadDataToTableSach();
        loadCbbNXB();
        loadCbbTheLoai();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCapNhatSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSachActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không", "Choose", JOptionPane.YES_NO_CANCEL_OPTION);
        String ten = txtTenSach.getText();
        String tenTG = txtTacGia.getText();
        String tenNXB = (String) cbbNXB.getSelectedItem();
        NXB nxb = nXBSevice.getOne((String) cbbNXB.getSelectedItem());
        String tenTL = (String) cbbTheLoai.getSelectedItem();
        TheLoai tl = theLoaiSevice.getOne((String) cbbTheLoai.getSelectedItem());
        String namXB = txtNamXuatBan.getText();
        String giaStr = txtGiaCa.getText();
        String soTrang = txtSoTrang.getText();
        String anh = partfile1;
        NXB nxbs = new NXB(nxb.getId(), nxb.getMaNXB(), tenNXB, nxb.getDiaChi(), nxb.getSdt(), nxb.getEmail(), nxb.getWebsite());
        TheLoai tkl = new TheLoai(tl.getId(), tl.getMaTL(), tenTL);

        Integer giaDouble = -1;

        try {
            giaDouble = Integer.parseInt(giaStr);
            if (giaDouble < 0) {
                JOptionPane.showMessageDialog(this, "Giá Phải Là Số Dương!");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá Phải Là Số!");
            return;
        }
        Integer gia = giaDouble;
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên rồi thử lại!");
        } else if (tenTG.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tác giả rồi thử lại!");
        } else if (namXB.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập năm xuất bản rồi thử lại!");
        } else if (Integer.parseInt(txtNamXuatBan.getText()) < 1 || Integer.parseInt(txtNamXuatBan.getText()) > 2023) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng năm xuất bản rồi thử lại!");
        } else if (String.valueOf(gia).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá của sách rồi thử lại!");
        } else if (String.valueOf(soTrang).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số trang của sách rồi thử lại!");
        } else {
            if (choose == JOptionPane.YES_OPTION) {
                Sach s = new Sach(ten, tenTG, nxbs, tkl, Integer.valueOf(namXB), Integer.valueOf(gia), Integer.valueOf(soTrang), anh);
                String ma = tbListQLSACH.getValueAt(tbListQLSACH.getSelectedRow(), 0).toString();
                JOptionPane.showMessageDialog(this, this.sachSevice.update(s, ma));
                loadDataToTableSach();
            }
        }
    }//GEN-LAST:event_btnCapNhatSachActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không", "Choose", JOptionPane.YES_NO_CANCEL_OPTION);
        String ten = txtTenSach.getText();
        String tenTG = txtTacGia.getText();
        String tenNXB = (String) cbbNXB.getSelectedItem();
        NXB nxb = nXBSevice.getOne((String) cbbNXB.getSelectedItem());
        String tenTL = (String) cbbTheLoai.getSelectedItem();
        TheLoai tl = theLoaiSevice.getOne((String) cbbTheLoai.getSelectedItem());
        String namXB = txtNamXuatBan.getText();
        String giaStr = txtGiaCa.getText();
        String soTrang = txtSoTrang.getText();
        String anh = partfile1;
        NXB nxbs = new NXB(nxb.getId(), nxb.getMaNXB(), tenNXB, nxb.getDiaChi(), nxb.getSdt(), nxb.getEmail(), nxb.getWebsite());
        TheLoai tkl = new TheLoai(tl.getId(), tl.getMaTL(), tenTL);
        int giaDouble = -1;

        try {
            giaDouble = Integer.parseInt(giaStr);
            if (giaDouble < 0) {
                JOptionPane.showMessageDialog(this, "Giá Phải Là Số Dương!");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá Phải Là Số!");
            return;
        }
        String gia = giaDouble + "";
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên rồi thử lại!");
        } else if (tenTG.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tác giả rồi thử lại!");
        } else if (namXB.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập năm xuất bản rồi thử lại!");
        } else if (Integer.parseInt(txtNamXuatBan.getText()) < 1 || Integer.parseInt(txtNamXuatBan.getText()) > 2023) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng năm xuất bản rồi thử lại!");
        } else if (String.valueOf(gia).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá của sách rồi thử lại!");
        } else if (String.valueOf(soTrang).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số trang của sách rồi thử lại!");
        } else {
            if (choose == JOptionPane.YES_OPTION) {
                Sach s = new Sach(ten, tenTG, nxbs, tkl, Integer.valueOf(namXB), Integer.valueOf(gia), Integer.valueOf(soTrang), anh);
                JOptionPane.showMessageDialog(this, this.sachSevice.add(s));
                loadDataToTableSach();
            }
        }
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNVActionPerformed
        String ma = txtTimKiemNV.getText();
        NhanVien nv = nhanVienSevice.getOne(ma);
        loadOnedNV(nv);
    }//GEN-LAST:event_btnTimKiemNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        if (tbListQLNV.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Mời chọn nhân viên cần sửa");
        } else {
            String ma = txtMaNV.getText();
            nhanVienSevice.delete(ma);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTableNV();
            refresh();
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void btnCapNhatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatNVActionPerformed
        if (tbListQLNV.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Mời chọn nhân viên cần sửa");
        } else {
            String ma = txtMaNV.getText();
            QLNhanVienModel nv = this.getData();
            nv.setMa(ma);
            nhanVienSevice.update(nv);
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            imageSeleted = "";
            lbAnhNV.setIcon(new ImageIcon(""));
            loadTableNV();
            refresh();
        }
    }//GEN-LAST:event_btnCapNhatNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        String sdt = "^0[9835]{1}\\d{8}$";
        String sdtnv = txtSDTNV.getText();
        Pattern pa = Pattern.compile(sdt);
        Matcher ma = pa.matcher(sdtnv);
        if (txtHoTenNV.getText().isBlank() && txtSDTNV.getText().isBlank() && txtTenTaiKhoan.getText().isBlank() && txtMatKhau.getText().isBlank() && txtNgaySinh.getText().isBlank() && txtDiaChi.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Mời bạn nhập đầy đủ thông tin");
        } else if (!ma.find()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số đt hoặc số đt sai định dạng");
        } else if (txtHoTenNV.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
        } else if (txtTenTaiKhoan.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản không được để trống");
        } else if (txtMatKhau.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
        } else if (txtNgaySinh.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống");
        } else if (txtDiaChi.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Đại chỉ không được để trống");
        } else {
            QLNhanVienModel nv;
            nv = getData();
            nhanVienSevice.insert(nv);
            JOptionPane.showMessageDialog(this, "Thêm Nhân Viên Thành Công");
            imageSeleted = "";
            lbAnhNV.setIcon(new ImageIcon(""));
            loadTableNV();
            refresh();
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonSachActionPerformed
        cardLayout.show(ViewChucNang, "ViewMuonSach");
    }//GEN-LAST:event_btnMuonSachActionPerformed

    private void btnQLPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLPhieuMuonActionPerformed
        cardLayout.show(ViewChucNang, "ViewPhieuMuon");

    }//GEN-LAST:event_btnQLPhieuMuonActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        NhanVien nve = nhanVienSevice.getOne(manv);
        if (nve.getChucVu().equals("Admin")) {
            cardLayout.show(ViewChucNang, "ViewNhanVien");
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Không Có Quyền Truy Cập Chức Năng Này");
            return;
        }

    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnQuanLySachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLySachActionPerformed

        NhanVien nve = nhanVienSevice.getOne(manv);
        if (nve.getChucVu().equals("Admin")) {
            cardLayout.show(ViewChucNang, "ViewSach");
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Không Có Quyền Truy Cập Chức Năng Này");
            return;
        }
    }//GEN-LAST:event_btnQuanLySachActionPerformed

    private void btnTheThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheThanhVienActionPerformed
        cardLayout.show(ViewChucNang, "ViewTheThuVien");
    }//GEN-LAST:event_btnTheThanhVienActionPerformed

    private void btnTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSachActionPerformed
        cardLayout.show(ViewChucNang, "ViewTraSach");
    }//GEN-LAST:event_btnTraSachActionPerformed

    private void tblPhieuMuonChoMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuonChoMuonMouseClicked
        int row = this.tblPhieuMuonChoMuon.getSelectedRow();
        maPhieuMuonChoMuon = this.tblPhieuMuonChoMuon.getValueAt(row, 0).toString();
        loadTablePhieuMuonChiTietchoMuon();
        System.out.println(maPhieuMuonChoMuon);
        String maTTV = this.tblPhieuMuonChoMuon.getValueAt(row, 1).toString();
        String tenDocGia = this.tblPhieuMuonChoMuon.getValueAt(row, 2).toString();
        String diaChi = this.tblPhieuMuonChoMuon.getValueAt(row, 3).toString();
        ngayMuon = this.tblPhieuMuonChoMuon.getValueAt(row, 4).toString();
        String ngayHenTra = this.tblPhieuMuonChoMuon.getValueAt(row, 5).toString();
        String ghiChu = this.tblPhieuMuonChoMuon.getValueAt(row, 6).toString();
        String tienCoc = this.tblPhieuMuonChoMuon.getValueAt(row, 7).toString();
        this.txtMaTTVChoMuon.setText(maTTV);
        this.lblTenDocGiaChoMuon.setText(tenDocGia);
        this.lblDiaChiChoMuon.setText(diaChi);
        this.txtNgayHenTraChoMuon.setText(ngayHenTra);
        this.txtTienCocChoMuon.setText(tienCoc);
        this.txtGhiChuChoMuon.setText(ghiChu);
        System.out.println("Mã NV:" + manv);
    }//GEN-LAST:event_tblPhieuMuonChoMuonMouseClicked

    private void btnTaoPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuMuonActionPerformed
        phieuMuonChoMuon pm = getFormPhieuMuonChoMuon();
        String maTTV = pmChoMuonService.checkMaTTV(pm.getMaTTV());
        if (maTTV == null) {
            JOptionPane.showMessageDialog(this, "Mã TTV Không Tồn Tại!");
        } else {
            String checkConHieuLuc = this.pmChoMuonService.checkMaTTVConHieuLuc(maTTV);
            if (checkConHieuLuc.equalsIgnoreCase("0")) {
                JOptionPane.showMessageDialog(this, "Thẻ Thư Viện Này Đã Hết Hiệu Lực!");
                return;
            } else {
                System.out.println(pm.getMaTTV() + " " + pm.getNgayMuon() + " " + pm.getNgayHenTra() + " " + pm.getGhiChu() + " " + pm.getTienCoc());
                if (pm.getMaTTV() == null || pm.getNgayHenTra() == null || pm.getGhiChu() == null || pm.getTienCoc() + "" == null) {
                    JOptionPane.showMessageDialog(this, "Bạn nhập đủ Mã TTV, ngày hẹn trả, tiền cọc và ghi chú đi nhé!");
                    return;
                } else {
                    int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?");
                    if (choice == JOptionPane.YES_OPTION) {
                        pmChoMuonService.insertPhieuMuonChoMuon(pm);
                        loadTablePhieuMuonChoMuon();
                        pm = null;
                        JOptionPane.showMessageDialog(this, "Tạo Phiếu Mượn Thành Công!");
                        return;
                    }
                }
            }
        }
        return;
    }//GEN-LAST:event_btnTaoPhieuMuonActionPerformed

    private void btnAddSachVaoPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSachVaoPMActionPerformed
        phieuMuonChiTietChoMuon pmct = getFormPhieuMuonChiTietChoMuon();
        if (maPhieuMuonChoMuon.length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn 1 Phiếu Để Thêm Sách Vào!");
            return;
        } else {
            if (pmct == null || pmct.getMaISBN() == null) {
                return;
            } else {
                String checkISBN = pmctChoMuonService.checkMaISBN(pmct.getMaISBN());
                if (checkISBN == null) {
                    JOptionPane.showMessageDialog(this, "Mã ISBN không tồn tại!");
                    return;
                } else {
                    String check = pmctChoMuonService.checkTrungSach(pmct.getMaISBN());
                    if (check.equalsIgnoreCase("0")) {
                        System.out.println("Result: " + check);
                        System.out.println("Mã Phiếu Mượn: " + pmct.getMaPhieuMuon() + "\nMã ISBN: " + pmct.getMaISBN());
                        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thêm Sách Vào Phiếu Mượn Không?");
                        if (chon == JOptionPane.YES_OPTION) {
                            System.out.println(pmct.getMaISBN());
                            pmctChoMuonService.insertPhieuMuonChiTietChoMuonChoMuon(pmct);
                            loadTablePhieuMuonChiTietchoMuon();
                            String maISBN = pmct.getMaISBN().toString();
                            pmctChoMuonService.updateSoLuongDaChoMuon(maISBN);
                            pmctChoMuonService.updateDaMuonPhieuMuonChiTietChoMuonChoMuon(maISBN);
                            maQuyenSachTrongQSCTChoMuon = pmctChoMuonService.checkMaISBNGetMaQuyenSach(pmct.getMaISBN());
                            System.out.println("\n\nMã Quyển Sách: " + maQuyenSachTrongQSCTChoMuon + "\n\nMã Phiếu Mượn: " + maPhieuMuonChoMuon + "\n\n");
                            quyenSachChoMuon qs = new quyenSachChoMuon(maQuyenSachTrongQSCTChoMuon, maPhieuMuonChoMuon);
                            qsService.insertQuyenSachChiTietChoMuonChoMuon(qs);
                            JOptionPane.showMessageDialog(this, "Thêm Sách Vào Phiếu Thành Công!");
                        }
                        check = "";
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Quyển sách này đã được mượn rồi!");
                        check = "";
                        return;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAddSachVaoPMActionPerformed

    private void btnReloadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTableActionPerformed
        loadTablePhieuMuonChoMuon();
        maPhieuMuonChoMuon = "";
        loadTablePhieuMuonChiTietchoMuon();
    }//GEN-LAST:event_btnReloadTableActionPerformed

    private void tblPhieuMuonChiTietChoMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuonChiTietChoMuonMouseClicked
        int row = this.tblPhieuMuonChiTietChoMuon.getSelectedRow();
        maQuyenSachTrongPMCTChoMuon = this.tblPhieuMuonChiTietChoMuon.getValueAt(row, 2).toString();
        System.out.println("Ma Quyen Sach Selected: " + maQuyenSachTrongPMCTChoMuon);
        String maISBN = pmctChoMuonService.getMaISBNByMaQuyenSach(maQuyenSachTrongPMCTChoMuon);
        this.txtMaISBNChoMuon.setText(maISBN);
    }//GEN-LAST:event_tblPhieuMuonChiTietChoMuonMouseClicked

    private void btnAddSachVaoPM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSachVaoPM1ActionPerformed
        phieuMuonChiTietChoMuon pmct = getFormPhieuMuonChiTietChoMuon();
        System.out.println("Mã ISBN" + pmct.getMaISBN());
        System.out.println(pmct.getMaISBN());
        if (maPhieuMuonChoMuon.length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn 1 Phiếu Mượn Để Thực Hiện Thao Tác!");
            return;
        } else {
            if (pmct == null || pmct.getMaISBN() == null) {
                return;
            } else {
                String checkISBN = pmctChoMuonService.checkMaISBN(pmct.getMaISBN());
                if (checkISBN == null) {
                    JOptionPane.showMessageDialog(this, "Mã ISBN không tồn tại!");
                    return;
                } else {
                    int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Quyển Sách Này Khỏi Phiếu Mượn Không?");
                    if (chon == JOptionPane.YES_OPTION) {
                        pmctChoMuonService.deletePhieuMuonChiTietChoMuonChoMuon(pmct.getMaISBN());
                        String maISBN = pmct.getMaISBN().toString();
                        loadTablePhieuMuonChiTietchoMuon();
                        pmctChoMuonService.updateSoLuongChuaChoMuon(maISBN);
                        pmctChoMuonService.updateChuaMuonPhieuMuonChiTietChoMuonChoMuon(maISBN);
                        qsService.deleteQuyenSachChiTietChoMuonChoMuon(maISBN);
                        JOptionPane.showMessageDialog(this, "Xóa Sách Khỏi Phiếu Mượn Thành Công!");
                        return;
                    }
                }
            }
        }
        this.txtMaISBNChoMuon.setText("");
    }//GEN-LAST:event_btnAddSachVaoPM1ActionPerformed

    private void btnInPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuMuonActionPerformed
        ArrayList<phieuMuonChiTietViewModel> listPhieuMuon = pmctChoMuonService.getAllListPhieuMuonChiTiet(maPhieuMuonChoMuon);
        int i = 1;
        System.out.println(String.format("%3s%20s%20s%15s%22s%15s", "STT", "Mã Phiếu Mượn", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao"));
        for (phieuMuonChiTietViewModel p : listPhieuMuon) {
            System.out.println(String.format("%2s%16s%21s%19s%19s%16s", i, p.getMaPhieuMuon(), p.getMaQuyenSach(), p.getTenSach(), p.getTinhTrangSachString(), p.getDoHuHao()));
            i++;
        }
        String maNV, maPM, maTTV, tenDG, ngayMuon, ngayHenTra, ghiChu;
        double tienCoc;
        maNV = manv;
        maPM = maPhieuMuonChoMuon;
        maTTV = this.txtMaTTVChoMuon.getText();
        tenDG = this.lblTenDocGiaChoMuon.getText();
        tenDG = this.lblTenDocGiaChoMuon.getText();
        ngayMuon = this.ngayMuon;
        ngayHenTra = txtNgayHenTraChoMuon.getText();
        ghiChu = txtGhiChuChoMuon.getText();
        tienCoc = Double.parseDouble(txtTienCocChoMuon.getText());
        XuatPhieuMuon xuatPM = new XuatPhieuMuon(maNV, maPM, maTTV, tenDG, ngayMuon, ngayHenTra, ghiChu, tienCoc);
        xuatPM.setVisible(true);
    }//GEN-LAST:event_btnInPhieuMuonActionPerformed

    private void btnLuuThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuThongTinActionPerformed
        if (maPhieuMuonChoMuon.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn 1 phiếu mượn rồi thử lại nhé!");
            return;
        } else {
            System.out.println("mapm: " + maPhieuMuonChoMuon);

            phieuMuonChoMuon pm = getFormPhieuMuonChoMuon();
            String maTTV = pmChoMuonService.checkMaTTV(pm.getMaTTV());
            if (maTTV == null) {
                JOptionPane.showMessageDialog(this, "Mã TTV Không Tồn Tại!");
            } else {
                System.out.println(pm.getMaTTV() + " " + pm.getNgayHenTra() + " " + pm.getGhiChu() + " " + pm.getTienCoc());
                if (pm.getMaTTV() == null || pm.getNgayHenTra() == null || pm.getGhiChu() == null || pm.getTienCoc() + "" == null) {
                    JOptionPane.showMessageDialog(this, "Bạn nhập đủ Mã TTV, ngày hẹn trả, tiền cọc và ghi chú đi nhé!");
                    return;
                } else {
                    int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật thông tin của phiếu mượn có mã là " + "\"" + maPhieuMuonChoMuon + "\"" + " không?");
                    if (choice == JOptionPane.YES_OPTION) {
                        pmChoMuonService.updatePhieuMuonChoMuon(pm, maPhieuMuonChoMuon);
                        loadTablePhieuMuonChoMuon();
                        pm = null;
                        JOptionPane.showMessageDialog(this, "Tạo Phiếu Mượn Thành Công!");
                        return;
                    }
                }
            }
        }
        return;
    }//GEN-LAST:event_btnLuuThongTinActionPerformed

    private void btnTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraSachMouseClicked
        cardLayout.show(ViewChucNang, "ViewTraSach");
    }//GEN-LAST:event_btnTraSachMouseClicked

    private void btnCreatePhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePhieuTraActionPerformed

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String ngayTra = dtf.format(now);
        String ghiChu = "Trống!";
        if (maPhieuMuonInTraSach == null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Cọn Phiếu Mượn!");
            return;
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Tạo Phiếu Trả Không?");
            if (chon == JOptionPane.YES_OPTION) {
                System.out.println(maPhieuMuonInTraSach + "\n" + ngayTra);
                ptService.insertPhieuTraTraSach(maPhieuMuonInTraSach, ngayTra, ghiChu);
                loadTablePhieuTraTraSach();

                return;
            }
        }
//0-9814-4962-X
    }//GEN-LAST:event_btnCreatePhieuTraActionPerformed

    private void tblPhieuTraTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuTraTraSachMouseClicked
        int row = this.tblPhieuTraTraSach.getSelectedRow();
        maPhieuTraXXX = this.tblPhieuTraTraSach.getValueAt(row, 0).toString();
        maPhieuMuonXXX = this.tblPhieuTraTraSach.getValueAt(row, 1).toString();
        tenDocGiaXXX = this.tblPhieuTraTraSach.getValueAt(row, 2).toString();
        ngayMuonXXX = this.tblPhieuTraTraSach.getValueAt(row, 4).toString();
        ngayHenTraXXX = this.tblPhieuTraTraSach.getValueAt(row, 5).toString();
        ngayTraXXX = this.tblPhieuTraTraSach.getValueAt(row, 6).toString();
        GhiChuXXX = this.tblPhieuTraTraSach.getValueAt(row, 7).toString();

        System.out.println("\nMã Nhân Viên: " + manv);
        System.out.println("\nMã Phiếu Trả: " + maPhieuTraXXX);
        maTTVXXX = this.ptService.getMaTTV(maPhieuMuonXXX);
        System.out.println("\nMã TTV: " + maTTVXXX);
        System.out.println("\nTên Độc Giả: " + tenDocGiaXXX);
        System.out.println("\nMã Phiếu Mượn: " + maPhieuMuonXXX);
        System.out.println("\nNgày Mượn: " + ngayMuonXXX);
        System.out.println("\nNgày Hẹn Trả: " + ngayHenTraXXX);
        System.out.println("\nNgày  Trả: " + ngayTraXXX);
        loadTablePhieuTraChiTietTraSach();

    }//GEN-LAST:event_tblPhieuTraTraSachMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (maPhieuTraXXX == null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Phiếu Trả!");
            return;
        } else {
            if (maQuyenSachInTraSach == null) {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Quyển Sách Để Thêm Vào Phiếu Trả!");
                return;
            } else {
                String checkk = ptService.checkTrungSachh(maQuyenSachInTraSach, maPhieuTraXXX);
                if (checkk != null) {
                    JOptionPane.showMessageDialog(this, "Bạn Đã Thêm Quyển Sách Này Vào Phiếu Rồi!");
                    return;
                } else {
                    int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thêm Sách Vào Phiếu Trả Không?");
                    if (chon == JOptionPane.YES_OPTION) {
                        ptctService.insertPhieuTraChiTiet(maPhieuTraXXX, maQuyenSachInTraSach, tenSachInTraSach, tinhTrangSachInTraSach, doHuHaoSachInTraSach + "");
                        loadTablePhieuTraChiTietTraSach();
                        return;
                    }
                }
            }
        }

        return;


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblPhieuTraChiTietTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuTraChiTietTraSachMouseClicked
        int row = this.tblPhieuTraChiTietTraSach.getSelectedRow();
        maQuyenSachXXX = this.tblPhieuTraChiTietTraSach.getValueAt(row, 1).toString();
        System.out.println("\nMã Quyển Sách: " + maQuyenSachXXX);
        maISBNXXX = ptctService.getMaISBN(maQuyenSachXXX);

    }//GEN-LAST:event_tblPhieuTraChiTietTraSachMouseClicked

    private void btnCapNhatDoHuHaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDoHuHaoActionPerformed
        double doHuHao = -1;
        String doHuHaoStr = this.txtDoHuHaoTraSach.getText().toString();

        if (doHuHaoStr.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn Vui Lòng Nhập Độ Hư Hao Rồi Thử Lại Nhé!");
            return;
        } else {
            try {
                doHuHao = Double.parseDouble(doHuHaoStr);
                if (doHuHao < 0) {
                    JOptionPane.showMessageDialog(this, "Độ hư hao phải là số dương!");
                    return;
                }

                if (maPhieuTraXXX == null) {
                    JOptionPane.showMessageDialog(this, "Bạn Vui Lòng Chọn 1 Phiếu Trả Rồi Thử Lại Nhé!");
                    return;
                } else {
                    if (maQuyenSachXXX == null) {
                        JOptionPane.showMessageDialog(this, "Bạn Vui Lòng Chọn 1 Quyển Sách Rồi Thử Lại Nhé!");
                        return;
                    } else {
                        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Cập Nhật Độ Hư Hao Không?");
                        if (chon == JOptionPane.YES_OPTION) {
                            System.out.println("\nĐộ Hư Hao: " + doHuHao);
                            System.out.println("\nMã Phiếu Trả: " + maPhieuTraXXX);
                            System.out.println("\nMã Quyển Sách: " + maQuyenSachXXX);
                            this.ptctService.updatePhieuTraChiTiet(doHuHao, maPhieuTraXXX, maQuyenSachXXX);
                            this.ptctService.updateQuyenSachByPhieuTraChiTiet(doHuHao, maQuyenSachXXX);
                            loadTablePhieuTraChiTietTraSach();
                            JOptionPane.showMessageDialog(this, "Cập Nhật Độ Hư Hao Thành Công!");
                        }
                    }
                }
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Độ hư hao phải là số!");
                return;
            }
        }

    }//GEN-LAST:event_btnCapNhatDoHuHaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(String.format("%20s%20s%15s%22s%15s", "Mã Phiếu Trả", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao"));
        for (phieuTraChiTietTraSachViewModel ptct : ptctService.getAllListPhieuTraChiTiet(maPhieuTraXXX)) {
            System.out.println(String.format("%16s%21s%19s%19s%16s", ptct.getMaPhieuTra(), ptct.getMaQuyenSach(), ptct.getTenSach(), ptct.getTinhTrangSach(), ptct.getDoHuHao()));
        }

        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn trả sách không?");
        if (chon == JOptionPane.YES_OPTION) {
            ArrayList<phieuTraChiTietTraSachViewModel> listObject = new ArrayList<>();
            for (phieuTraChiTietTraSachViewModel ptct : ptctService.getAllListPhieuTraChiTiet(maPhieuTraXXX)) {
                pmctChoMuonService.updateSoLuongChuaChoMuon(ptct.getMaQuyenSach());
                pmctChoMuonService.updateChuaMuonPhieuMuonChiTietChoMuonChoMuon(ptct.getMaQuyenSach());
                qsService.deleteQuyenSachChiTietChoMuonChoMuon(ptct.getMaQuyenSach());
            }
            JOptionPane.showMessageDialog(this, "Trả Sách Thành Công!");
            int chon2 = JOptionPane.showConfirmDialog(this, "Bạn có muốn in phiếu trả sách không?");
            if (chon2 == JOptionPane.YES_OPTION) {
                XuatPhieuTra xpt = new XuatPhieuTra(manv, maPhieuTraXXX, maTTVXXX, tenDocGiaXXX, ngayMuonXXX, ngayHenTraXXX, ngayTraXXX, GhiChuXXX);
                xpt.setVisible(true);
            }

        }

//        pmctChoMuonService.updateSoLuongChuaChoMuon(maISBNXXX);
//        pmctChoMuonService.updateChuaMuonPhieuMuonChiTietChoMuonChoMuon(maISBNXXX);
//        qsService.deleteQuyenSachChiTietChoMuonChoMuon(maISBNXXX);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTimSachhhhhhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSachhhhhhActionPerformed
        String maTTV = this.txtMaTTVPhieuDen.getText().trim();
        if (maTTV.length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhập Mã thẻ thư viện để tìm");
            return;
        } else {
            loadTableSachInPhieuDen(maTTV);
        }
        
    }//GEN-LAST:event_btnTimSachhhhhhActionPerformed

    private void tblPhieuDenResultSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuDenResultSearchMouseClicked
        int row = this.tblPhieuDenResultSearch.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Tìm Sách Sau Đó Chọn 1 Dòng Rồi Thử Lại Nhé");
            return;
        } else {
            maPhieuMuonInPhieuDen = this.tblPhieuDenResultSearch.getValueAt(row, 0).toString();
            maQuyenSachInPhieuDen = this.tblPhieuDenResultSearch.getValueAt(row, 1).toString();
            tenSachInPhieuDen = this.tblPhieuDenResultSearch.getValueAt(row, 2).toString();
            System.out.println(maQuyenSachInPhieuDen);
            maTTVInPhieuDen = this.txtMaTTVPhieuDen.getText().trim();
            if (maTTVInPhieuDen.length() == 0) {
                JOptionPane.showMessageDialog(this, "Nhập Mã TTV Đê");
                return;
            } else {
                System.out.println("");
                System.out.println(maPhieuMuonInPhieuDen);
                System.out.println(manv);
                System.out.println(maTTVInPhieuDen);
                System.out.println(ngayPhatInPhieuDen);
            }

        }
    }//GEN-LAST:event_tblPhieuDenResultSearchMouseClicked

    private void tblPhieuDenChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuDenChiTietMouseClicked
        int row = this.tblPhieuDenChiTiet.getSelectedRow();
        maQuyenSachInPhieuDenChiTiet = this.tblPhieuDenChiTiet.getValueAt(row, 1).toString();
    }//GEN-LAST:event_tblPhieuDenChiTietMouseClicked

    private void tblPhieuDenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuDenMouseClicked
        int row = this.tblPhieuDen.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn 1 Dòng Trong Bảng Danh Sách Phiếu Đền Rồi Thử Lại Nhé");
            return;
        } else {
            maPhieuDenInPhieuDen = this.tblPhieuDen.getValueAt(row, 0).toString();
            System.out.println("MaPD: " + maPhieuDenInPhieuDen);
            loadTablePhieuDenChiTiet(maPhieuDenInPhieuDen);
        }

    }//GEN-LAST:event_tblPhieuDenMouseClicked

    private void btnThemVaoPhieuDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoPhieuDenActionPerformed
        if (maQuyenSachInPhieuDen == null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Sách Để Thêm!");
            return;
        } else {
            if (tenSachInPhieuDen == null) {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Sách Để Thêm!");
                return;
            } else {
                if (maPhieuDenInPhieuDen == null) {
                    JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Phiếu Đền!");
                    return;
                } else {
                    System.out.println("Mã Phiếu Đền: " + maPhieuDenInPhieuDen);
                    System.out.println("Mã Quyển Sách: " + maQuyenSachInPhieuDen);
                    System.out.println("Tên Sách: " + tenSachInPhieuDen);
                    String checkk = pdctService.checkTrungSach(maPhieuDenInPhieuDen, maQuyenSachInPhieuDen);
                    if (checkk != null) {
                        JOptionPane.showMessageDialog(this, "Bạn Đã Thêm Quyển Sách Này Vào Phiếu Đền Chi Tiết Rồi!");
                        return;
                    } else {
                        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thêm Sách vào Phiếu Không?");
                        if (chon == JOptionPane.YES_OPTION) {
                            this.pdctService.insertPhieuDenChiTiet(maPhieuDenInPhieuDen, maQuyenSachInPhieuDen, tenSachInPhieuDen);
                            loadTablePhieuDenChiTiet(maPhieuDenInPhieuDen);
                            JOptionPane.showMessageDialog(this, "Thêm Sách Vào Phiếu Đền Thành Công!");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnThemVaoPhieuDenActionPerformed

    private void btnTaoPhieuDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuDenActionPerformed
        String soTienPhat = this.txtSoTienPhatInPhieuDen.getText().toString();
        String lyDoPhat = this.txtLyDoPhatInPhieuDen.getText().toString();
        if (maPhieuMuonInPhieuDen == null) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Tìm Sách Sau Đó Chọn 1 Dòng Để Lấy Mã Phiếu Mượn!");
            return;
        } else {
            if (maPhieuMuonInPhieuDen == null) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Tìm Sách Sau Đó Chọn 1 Dòng Để Lấy Mã Phiếu Mượn!");
                return;
            } else {
                if (maTTVInPhieuDen.length() == 0) {
                    JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Mã TTV Rồi Thử Lại Nhé!");
                    return;
                } else {
                    if (soTienPhat == null) {
                        JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Tiền Phạt Rồi Thử Lại Nhé!");
                        return;
                    } else {
                        if (lyDoPhat == null) {
                            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Lý Do Phạt Rồi Thử Lại Nhé!");
                            return;
                        } else {
                            int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Chắn Muốn Tạo Phiếu Đền Không?");
                            if (chon == JOptionPane.YES_OPTION) {
                                pdService.insertPhieuDen(maPhieuMuonInPhieuDen, manv, maTTVInPhieuDen, soTienPhat, ngayPhatInPhieuDen, lyDoPhat);
                                loadTablePhieuDen();
                            }
                        }
                    }
                }
            }
        }
        return;
    }//GEN-LAST:event_btnTaoPhieuDenActionPerformed

    private void btnCapNhatDoHuHaoInPhieuDenChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDoHuHaoInPhieuDenChiTietActionPerformed

        String doHuHaoString = this.txtDoHuHaoInPhieuDen.getText().trim();

        double doHuHaoDouble = -1;

        try {
            doHuHaoDouble = Double.parseDouble(doHuHaoString);
            if (doHuHaoDouble < 0) {
                JOptionPane.showMessageDialog(this, "Độ hư hao phải là số dương!");
                return;
            } else {
                if (maPhieuDenInPhieuDen == null) {
                    JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Phiếu Đền!");
                    return;
                } else {
                    if (maQuyenSachInPhieuDenChiTiet == null) {
                        JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Một Quyển Sách Trong Phiếu Đền Chi Tiết Rồi Thử Lại!");
                        return;
                    } else {
                        String doHuHao = doHuHaoDouble + "";
                        System.out.println("\n\n\ndhh = " + doHuHao);
                        System.out.println("mqs = " + maQuyenSachInPhieuDenChiTiet);
                        System.out.println("mapd = " + maPhieuDenInPhieuDen);
                        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Cập Nhật Độ Hư Hao Không?");
                        if (chon == JOptionPane.YES_OPTION) {
                            pdctService.updatePhieuDenChiTiet(doHuHao, maQuyenSachInPhieuDenChiTiet, maPhieuDenInPhieuDen);
                            loadTablePhieuDenChiTiet(maPhieuDenInPhieuDen);
                            JOptionPane.showMessageDialog(this, "Cập Nhật Thông Tin Thành Công!");
                            return;
                        }
                    }
                }

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Độ hư hao phải là số!");
            return;
        }

    }//GEN-LAST:event_btnCapNhatDoHuHaoInPhieuDenChiTietActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        docGiaModel dg = getFormDataDocGia();
        if (dg == null || dg.getSdt() == null) {
            return;
        } else {
            System.out.println("Họ Tên: " + dg.getHoTen());
            System.out.println("Ngày Sinh: " + dg.getNgaySinh());
            System.out.println("Giới Tính: " + dg.getGioiTinh());
            System.out.println("Địa Chỉ: " + dg.getDiaChi());
            System.out.println("Số Điện Thoại: " + dg.getSdt());
            int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thêm Độc Giả Không?");
            if (chon == JOptionPane.YES_OPTION) {
                dgService.insertDocGia(dg);
                loadTableDocGia();
                loadCBBMaDocGia();
                JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
            } else {
                return;
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        docGiaModel dg = getFormDataDocGia();
        if (dg == null || dg.getSdt() == null) {
            return;
        } else {
            if (maDocGiaIntableDocGia == null) {
                JOptionPane.showMessageDialog(this, "Bạn Chọn Một Độc Giả Rồi Thử Lại Nhé!");
                return;
            } else {
                System.out.println("Họ Tên: " + dg.getHoTen());
                System.out.println("Ngày Sinh: " + dg.getNgaySinh());
                System.out.println("Giới Tính: " + dg.getGioiTinh());
                System.out.println("Địa Chỉ: " + dg.getDiaChi());
                System.out.println("Số Điện Thoại: " + dg.getSdt());
                System.out.println("Mã Độc Giả: " + maDocGiaIntableDocGia);

                int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Sửa Thông Tin Độc Giả Không?");
                if (chon == JOptionPane.YES_OPTION) {
                    dgService.updateDocGia(dg, maDocGiaIntableDocGia);
                    loadTableDocGia();
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công!");
                } else {
                    return;
                }
            }
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocGiaMouseClicked
        int row = this.tblDocGia.getSelectedRow();
        maDocGiaIntableDocGia = this.tblDocGia.getValueAt(row, 0).toString();
        System.out.println("Mã Độc Giả: " + maDocGiaIntableDocGia);
        hotenDocGiaIntableDocGia = this.tblDocGia.getValueAt(row, 1).toString();
        ngaysinhDocGiaIntableDocGia = this.tblDocGia.getValueAt(row, 2).toString();
        gioitinhDocGiaIntableDocGia = this.tblDocGia.getValueAt(row, 3).toString();
        diaChiDocGiaIntableDocGia = this.tblDocGia.getValueAt(row, 4).toString();
        sdtDocGiaIntableDocGia = this.tblDocGia.getValueAt(row, 5).toString();

        this.txtHoTenDG.setText(hotenDocGiaIntableDocGia);
        this.txtNgaySinhDG.setText(ngaysinhDocGiaIntableDocGia);
        if (gioitinhDocGiaIntableDocGia.equals("Nam")) {
            rdoGioiTinhNamDG.setSelected(true);
        } else if (gioitinhDocGiaIntableDocGia.equals("Nữ")) {
            rdoGioiTinhNuDG.setSelected(true);
        }
        this.txtDiaChiDG.setText(diaChiDocGiaIntableDocGia);
        this.txtSDTDG.setText(sdtDocGiaIntableDocGia);
    }//GEN-LAST:event_tblDocGiaMouseClicked

    private void txtSearchDocGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDocGiaKeyReleased
        String maDG = this.txtSearchDocGia.getText().trim();
        String Search = "%" + maDG + "%";
        System.out.println(Search);
        loadTableSearchDocGia(Search);
    }//GEN-LAST:event_txtSearchDocGiaKeyReleased

    private void btnTaoTheThuVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoTheThuVienActionPerformed
        maDocGiaInComboboxMaDocGia = this.cbbMaDocGia.getSelectedItem().toString();
        ghiChuInTheThuVien = this.txtGhiChuTheThuVien.getText().trim();
        if (ghiChuInTheThuVien.length() == 0) {
            ghiChuInTheThuVien = "Trống!";
        }
        int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Tạo Thẻ Thư Viện Mới Không?");
        if (choice == JOptionPane.YES_OPTION) {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate now = LocalDate.now();
                String noww = now + "";
                String dt = noww;  // Start date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(dt));
                c.add(Calendar.DATE, 365 * 2);  // number of days to add
                dt = sdf.format(c.getTime());
                System.out.println("Mã Độc Giả: " + maDocGiaInComboboxMaDocGia);
                System.out.println("Ngày Cấp: " + now);
                System.out.println("Ngày Hết Hạn: " + dt);
                System.out.println("Ghi Chú: " + ghiChuInTheThuVien);
                ttvService.insertTheThuVien(maDocGiaInComboboxMaDocGia, now + "", dt, ghiChuInTheThuVien);
                loadTableTheThuVien();
                JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnTaoTheThuVienActionPerformed

    private void tblTheThuVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheThuVienMouseClicked
        int row = this.tblTheThuVien.getSelectedRow();
        maTheThuVienInTheThuVien = this.tblTheThuVien.getValueAt(row, 0).toString();
        System.out.println("\nMã Thẻ Thư Viện: " + maTheThuVienInTheThuVien);
    }//GEN-LAST:event_tblTheThuVienMouseClicked

    private void btnVoHieuHoaTheThuVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoHieuHoaTheThuVienActionPerformed
        if (maTheThuVienInTheThuVien == null) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Một Thẻ Thư Viện Rồi Thử Lại Nhé!");
            return;
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Vô Hiệu Hóa Thẻ Thư Viện Có Mã Là: " + maTheThuVienInTheThuVien + " Không?");
            if (choice == JOptionPane.YES_OPTION) {
                ttvService.upadateTheThuVien(maTheThuVienInTheThuVien);
                loadTableTheThuVien();
                JOptionPane.showMessageDialog(this, "Vô Hiệu Hóa Thành Công!");
                maTheThuVienInTheThuVien = null;
            }
        }
    }//GEN-LAST:event_btnVoHieuHoaTheThuVienActionPerformed

    private void rdoGioiTinhNuDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGioiTinhNuDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoGioiTinhNuDGActionPerformed

    private void tbListQLSACHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListQLSACHMouseClicked
        int i = tbListQLSACH.getSelectedRow();
        loadSach(i);
    }//GEN-LAST:event_tbListQLSACHMouseClicked

    private void tbListQLSACHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListQLSACHMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu3.show(tbListQLSACH, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbListQLSACHMouseReleased

    private void menuChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChiTietSPActionPerformed
        int i = tbListQLSACH.getSelectedRow();

        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách rồi thử lại nhé!");
            return;
        } else {
            String ma = tbListQLSACH.getValueAt(i, 0).toString();
            Sach sc = sachSevice.getOne(ma);
            NhanVien nvc = nhanVienSevice.getOne(manv);
            ViewChiTietSach view = new ViewChiTietSach(sc.getId(), nvc.getMa(), nvc.getHinhAnh(), sc.getTenSach(), sc.getMaSach());
            view.setVisible(true);
        }

    }//GEN-LAST:event_menuChiTietSPActionPerformed

    private void cbbNXBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNXBMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(cbbNXB, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_cbbNXBMouseReleased

    private void tbListQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListQLNVMouseClicked
        int row = tbListQLNV.getSelectedRow();
        NhanVien nv = nhanVienSevice.getOne((String) tbListQLNV.getValueAt(row, 0));
        txtMaNV.setText(tbListQLNV.getValueAt(row, 0).toString());
        txtHoTenNV.setText(tbListQLNV.getValueAt(row, 1).toString());
        if (tbListQLNV.getValueAt(row, 2).toString().equalsIgnoreCase("Admin")) {
            cbbChucVu.setSelectedItem("Admin");
        } else {
            cbbChucVu.setSelectedItem("Thủ thư");
        }
        if (tbListQLNV.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
            rdbNam.setSelected(true);
        } else {
            rdbNu.setSelected(true);
        }
        txtNgaySinh.setText(tbListQLNV.getValueAt(row, 4).toString());
        txtSDTNV.setText(tbListQLNV.getValueAt(row, 5).toString());
        if (tbListQLNV.getValueAt(row, 6).toString().equalsIgnoreCase("Ðang làm")) {
            rdbTrangThai.setSelected(true);
        } else {
            rdbTrangThai.setSelected(false);
        }
        txtDiaChi.setText(tbListQLNV.getValueAt(row, 7).toString());
        txtTenTaiKhoan.setText(tbListQLNV.getValueAt(row, 8).toString());
        txtMatKhau.setText(nv.getMatKhau());
        String im = tbListQLNV.getValueAt(row, 10).toString();
        lbAnhNV.setIcon(sizeanh(String.valueOf(im)));
    }//GEN-LAST:event_tbListQLNVMouseClicked

    private void tbListQLNVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListQLNVMouseReleased

    }//GEN-LAST:event_tbListQLNVMouseReleased

    private void lbAnhNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnhNVMouseClicked
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileSeleted = jFileChooser.getSelectedFile();
            lbAnhNV.setIcon((new ImageIcon(fileSeleted.getAbsolutePath())));
            imageSeleted = fileSeleted.getAbsolutePath();
            lbAnhNV.setIcon(sizeanh(String.valueOf(imageSeleted)));
        }
    }//GEN-LAST:event_lbAnhNVMouseClicked

    private void tbListQLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListQLNVMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbListQLNVMouseEntered

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cardLayout.show(ViewChucNang, "ViewPhieuDen");      // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tblPhieuPhat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuPhat1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPhieuPhat1MouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        mattv = txt_maTTV.getText();
        if (mattv.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã thẻ thư viện");
            return;
        }

        List<quanlysachthethuvien> listsach = PhieuDen_Repository.getSachBymaTTV(mattv);
        if (listsach.size() == 0) {
            JOptionPane.showMessageDialog(this, "Mã thư viện ko tồn tại");
            return;
        }
        System.out.println(listsach.size());
        loadSach(listsach);
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblPhieuDenCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuDenCTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPhieuDenCTMouseClicked

    private void btn_taoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoActionPerformed
        int row = tblPhieuPhat.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu mượn");
            return;
        }
        String idpm = PhieuDen_Repository.getidpmbyma(tblPhieuPhat.getValueAt(row, 0).toString());
        String idnv = "36D96BA6-E33A-4C41-BE7E-13E13EC1B733";
        String idttv = PhieuDen_Repository.getidttvbyma(mattv);
        //        String stp = txtSoTienPhat.getText();
        String date = "2023-04-18";
        PhieuDen_Repository.insertPhieuDen(idpm, idnv, idttv, 0, date);

        List<PhieuDen_model> lisst = PhieuDen_Repository.getALL(idttv, idnv, idpm);
        loadPhieuDen(lisst);

        //        String ngayTra =
    }//GEN-LAST:event_btn_taoActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int row = tblPhieuDenCT.getSelectedRow();
        String ma = tblPhieuDenCT.getValueAt(row, 0).toString();
        String tenkh = tblPhieuDenCT.getValueAt(row, 3).toString();
        Inphieu inphieu = new Inphieu(ma, tenkh);
        inphieu.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        int row = tblPhieuPhat1.getSelectedRow();
        int row1 = tblPhieuPhat.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 phiếu đền");
            return;
        }

        if (row1 < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách muốn đền");
            return;
        }

        if (txtSoTienPhat.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền phạt");
        } else if (txtLyDoPhat.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Lý do phạt");
        } else if (txtDoHuHao.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập độ hư hao");
        } else {
            double sotienphat = 0;

            try {
                sotienphat = Double.parseDouble(txtSoTienPhat.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Tiền phải là số ");
                return;
            }
            if (sotienphat < 0) {
                JOptionPane.showMessageDialog(this, "Tiền phải là số dương ");
                return;
            }
            String mapd = tblPhieuPhat1.getValueAt(row, 0).toString();
            String idpd = PhieuDen_Repository.getidpdbyma(mapd);
            String masach = tblPhieuPhat.getValueAt(row1, 1).toString();
            int sotrang = PhieuDen_Repository.getsotrangbymasach(masach);
            String tensach = tblPhieuPhat.getValueAt(row1, 2).toString();
            String tinhtrang = txtLyDoPhat.getText();

            double dohuhao = Double.parseDouble(txtDoHuHao.getText());
            PhieuDenCT pdct = new PhieuDenCT(idpd, masach, tensach, tinhtrang, dohuhao);
            PhieuDen_Repository.insertPhieuDenCT(pdct);
//            PhieuDen_Repository.updatePhieuDen(Double.parseDouble(txtSoTienPhat.getText()),txtLyDoPhat.getT, mapd);

            List<PhieuDenCT> list = PhieuDen_Repository.getALLPDCT(idpd);

            loadPhieuDenChiTiet(list);

        }

        //        int row = tblPhieuPhat1.getSelectedRow();
        //        String mapm = tblPhieuPhat1.getValueAt(row, 0).toString();
        //        String idpm = PhieuDen_Repository.getidpmbyma(mapm);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int row = tblPhieuDenCT.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật");
            return;
        }

        if (txtSoTienPhat.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền phạt");
        } else if (txtLyDoPhat.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Lý do phạt");
        } else if (txtDoHuHao.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập độ hư hao");
        } else {

            String idpd = PhieuDen_Repository.getidpdbyma(tblPhieuDenCT.getValueAt(row, 0).toString());
            PhieuDen_Repository.updatePhieuDenChiTiet(idpd, txtDoHuHao.getText(), txtLyDoPhat.getText());
//            PhieuDen_Repository.updatePhieuDen(Double.parseDouble(txtSoTienPhat.getText()), tblPhieuDenCT.getValueAt(row, 0).toString());

            String idpm = PhieuDen_Repository.getidpmbyidpd(idpd);
            String idnv = "41FBBD44-B047-401F-B68A-BAE14960C946";
            String idttv = PhieuDen_Repository.getidttvbyma(mattv);
            List<PhieuDenCT> list = PhieuDen_Repository.getALLPDCT(idpd);
            loadPhieuDenChiTiet(list);
            JOptionPane.showMessageDialog(this, "Thành công");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tblPhieuPhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuPhatMouseClicked
        //
    }//GEN-LAST:event_tblPhieuPhatMouseClicked

    private void btn_capnhatttphieudenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatttphieudenActionPerformed
        // TODO add your handling code here:
        if (maPhieuDenInPhieuDen == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phiếu đền");
            return;
        }
        if (txtSoTienPhatInPhieuDen.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền phạt");
            return;
        } else if (txtLyDoPhatInPhieuDen.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lý do phạt");
            return;
        }

        PhieuDen_Repository.updatePhieuDen(Double.parseDouble(txtSoTienPhatInPhieuDen.getText()), txtLyDoPhatInPhieuDen.getText(), maPhieuDenInPhieuDen);
        loadTablePhieuDen();
        JOptionPane.showMessageDialog(this, "Thành công");

//        int row = tblPhieuDenCT.getSelectedRow();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật");
//            return;
//        }
//
//        if (txtSoTienPhat.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền phạt");
//        } else if (txtLyDoPhat.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập Lý do phạt");
//        } else if (txtDoHuHao.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập độ hư hao");
//        } else {
//
//            String idpd = PhieuDen_Repository.getidpdbyma(tblPhieuDenCT.getValueAt(row, 0).toString());
//            PhieuDen_Repository.updatePhieuDenChiTiet(idpd, txtDoHuHao.getText(), txtLyDoPhat.getText());
//            PhieuDen_Repository.updatePhieuDen(Double.parseDouble(txtSoTienPhat.getText()), tblPhieuDenCT.getValueAt(row, 0).toString());
//
//            String idpm = PhieuDen_Repository.getidpmbyidpd(idpd);
//            String idnv = "41FBBD44-B047-401F-B68A-BAE14960C946";
//            String idttv = PhieuDen_Repository.getidttvbyma(mattv);
//            List<PhieuDenCT> list = PhieuDen_Repository.getALLPDCT(idpd);
//            loadPhieuDenChiTiet(list);
//            JOptionPane.showMessageDialog(this, "Thành công");
//        }
    }//GEN-LAST:event_btn_capnhatttphieudenActionPerformed

    private void btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int row = tblPhieuDenChiTiet.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu đền bạn muốn in");
            return;
        }

        String ma = tblPhieuDenChiTiet.getValueAt(row, 0).toString();
        String tenkh = tblPhieuDenChiTiet.getValueAt(row, 3).toString();
        Inphieu inphieu = new Inphieu(ma, tenkh);
        inphieu.setVisible(true);
    }//GEN-LAST:event_btn_inActionPerformed

    private void txtMaTheThuVienSearchInTraSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaTheThuVienSearchInTraSachKeyReleased
        String maTTV = txtMaTheThuVienSearchInTraSach.getText().trim();
        loadTablePhieuMuonInTraSach(maTTV);
    }//GEN-LAST:event_txtMaTheThuVienSearchInTraSachKeyReleased

    private void tblDanhSachPhieuMuonInTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuMuonInTraSachMouseClicked
        int row = this.tblDanhSachPhieuMuonInTraSach.getSelectedRow();
        maPhieuMuonInTraSach = this.tblDanhSachPhieuMuonInTraSach.getValueAt(row, 0).toString();
        System.out.println("MaPM: " + maPhieuMuonInTraSach);
        loadTablePhieuMuonChiTietTraSach(maPhieuMuonInTraSach);
    }//GEN-LAST:event_tblDanhSachPhieuMuonInTraSachMouseClicked

    private void tblPhieuMuonChiTietInTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuonChiTietInTraSachMouseClicked
        int row = this.tblPhieuMuonChiTietInTraSach.getSelectedRow();
        maQuyenSachInTraSach = this.tblPhieuMuonChiTietInTraSach.getValueAt(row, 2).toString();
        tenSachInTraSach = this.tblPhieuMuonChiTietInTraSach.getValueAt(row, 3).toString();
        tinhTrangSachInTraSach = this.tblPhieuMuonChiTietInTraSach.getValueAt(row, 4).toString();
        doHuHaoSachInTraSach = Double.parseDouble(this.tblPhieuMuonChiTietInTraSach.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tblPhieuMuonChiTietInTraSachMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewThuVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewThuVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewThuVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewThuVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewThuVien().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViewChucNang;
    private javax.swing.JPanel ViewDocGia;
    private javax.swing.JPanel ViewMuonSach;
    private javax.swing.JPanel ViewNhanVien;
    private javax.swing.JPanel ViewPhieuDen;
    private javax.swing.JPanel ViewPhieuDenAnhDat;
    private javax.swing.JPanel ViewPhieuMuon;
    private javax.swing.JPanel ViewSach;
    private javax.swing.JPanel ViewTraSach;
    private javax.swing.JButton btnAddSachVaoPM;
    private javax.swing.JButton btnAddSachVaoPM1;
    private javax.swing.JButton btnCapNhatDoHuHao;
    private javax.swing.JButton btnCapNhatDoHuHaoInPhieuDenChiTiet;
    private javax.swing.JButton btnCapNhatNV;
    private javax.swing.JButton btnCapNhatSach;
    private javax.swing.JButton btnCreatePhieuTra;
    private javax.swing.JButton btnInPhieuMuon;
    private javax.swing.JButton btnLuuThongTin;
    private javax.swing.JButton btnMuonSach;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLPhieuMuon;
    private javax.swing.JButton btnQuanLySach;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnReloadTable;
    private javax.swing.JButton btnTaoPhieuDen;
    private javax.swing.JButton btnTaoPhieuMuon;
    private javax.swing.JButton btnTaoTheThuVien;
    private javax.swing.JButton btnTheThanhVien;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnThemVaoPhieuDen;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTimKiemNV;
    private javax.swing.JButton btnTimKiemPhieuMuon;
    private javax.swing.JButton btnTimKiemSach;
    private javax.swing.JButton btnTimSachhhhhh;
    private javax.swing.JButton btnTraSach;
    private javax.swing.JButton btnVoHieuHoaTheThuVien;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btn_capnhatttphieuden;
    private javax.swing.JButton btn_in;
    private javax.swing.JButton btn_tao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbMaDocGia;
    private javax.swing.JComboBox<String> cbbNXB;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JPanel chucNang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbAnhNV;
    private javax.swing.JLabel lbAnhNVA;
    private javax.swing.JLabel lbAnhSach;
    private javax.swing.JTable lbListTTPhieuMuon;
    private javax.swing.JLabel lbTenNVA;
    private javax.swing.JLabel lblDiaChiChoMuon;
    private javax.swing.JLabel lblTenDocGiaChoMuon;
    private javax.swing.JMenuItem menuChiTietSP;
    private javax.swing.JMenuItem menuChonAnh;
    private javax.swing.JMenuItem menuChonNXB;
    private javax.swing.JPanel panelAnh;
    private javax.swing.JPanel panelWebCam;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JCheckBox rdbTrangThai;
    private javax.swing.JRadioButton rdoGioiTinhNamDG;
    private javax.swing.JRadioButton rdoGioiTinhNuDG;
    private javax.swing.JTable tbListQLNV;
    private javax.swing.JTable tbListQLSACH;
    private javax.swing.JTable tbListTTChiTietPM;
    private javax.swing.JTable tblDanhSachPhieuMuonInTraSach;
    private javax.swing.JTable tblDocGia;
    private javax.swing.JTable tblPhieuDen;
    private javax.swing.JTable tblPhieuDenCT;
    private javax.swing.JTable tblPhieuDenChiTiet;
    private javax.swing.JTable tblPhieuDenResultSearch;
    private javax.swing.JTable tblPhieuMuonChiTietChoMuon;
    private javax.swing.JTable tblPhieuMuonChiTietInTraSach;
    private javax.swing.JTable tblPhieuMuonChoMuon;
    private javax.swing.JTable tblPhieuPhat;
    private javax.swing.JTable tblPhieuPhat1;
    private javax.swing.JTable tblPhieuTraChiTietTraSach;
    private javax.swing.JTable tblPhieuTraTraSach;
    private javax.swing.JTable tblTheThuVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtDiaChiDG;
    private javax.swing.JTextField txtDoHuHao;
    private javax.swing.JTextField txtDoHuHaoInPhieuDen;
    private javax.swing.JTextField txtDoHuHaoTraSach;
    private javax.swing.JTextArea txtGhiChuChoMuon;
    private javax.swing.JTextArea txtGhiChuTheThuVien;
    private javax.swing.JTextArea txtGhiChuTraSach;
    private javax.swing.JTextField txtGiaCa;
    private javax.swing.JTextField txtHoTenDG;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextArea txtLyDoPhat;
    private javax.swing.JTextArea txtLyDoPhatInPhieuDen;
    private javax.swing.JTextField txtMaISBNChoMuon;
    private javax.swing.JLabel txtMaNV;
    private javax.swing.JLabel txtMaSach;
    private javax.swing.JTextField txtMaTTVChoMuon;
    private javax.swing.JTextField txtMaTTVPhieuDen;
    private javax.swing.JTextField txtMaTheThuVienSearchInTraSach;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNgayHenTraChoMuon;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgaySinhDG;
    private javax.swing.JTextField txtSDTDG;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSearchDocGia;
    private javax.swing.JTextField txtSoTienPhat;
    private javax.swing.JTextField txtSoTienPhatInPhieuDen;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JTextField txtTienCocChoMuon;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemMaPhieuMuon;
    private javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txt_maTTV;
    // End of variables declaration//GEN-END:variables

    private void loadTablePhieuMuonChoMuon() {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuMuonChoMuon.getModel();
        model.setRowCount(0);
        for (phieuMuonViewModel pm : pmChoMuonService.getAllListPhieuMuon()) {
            Object rowData[] = {
                pm.getMaPhieuMuon(),
                pm.getMaTTV(),
                pm.getTenDocGia(),
                pm.getDiaChi(),
                pm.getNgayMuon(),
                pm.getNgayHenTra(),
                pm.getGhiChu(),
                pm.getTienCoc()
            };
            model.addRow(rowData);
        }
    }

    private void loadTablePhieuMuonChiTietchoMuon() {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuMuonChiTietChoMuon.getModel();
        model.setRowCount(0);
        int i = 1;
        for (phieuMuonChiTietViewModel pmct : pmctChoMuonService.getAllListPhieuMuonChiTiet(maPhieuMuonChoMuon)) {
            Object rowData[] = {
                i,
                pmct.getMaPhieuMuon(),
                pmct.getMaQuyenSach(),
                pmct.getTenSach(),
                pmct.getTinhTrangSachString(),
                pmct.getDoHuHao()
            };
            model.addRow(rowData);
            i++;
        }
    }

    private void loadTablePhieuMuonChiTietTraSach(String maPM) {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuMuonChiTietInTraSach.getModel();
        model.setRowCount(0);
        int i = 1;
        for (phieuMuonChiTietViewModel pmct : pmctChoMuonService.getAllListPhieuMuonChiTiet(maPM)) {
            Object rowData[] = {
                i,
                pmct.getMaPhieuMuon(),
                pmct.getMaQuyenSach(),
                pmct.getTenSach(),
                pmct.getTinhTrangSachString(),
                pmct.getDoHuHao()
            };
            model.addRow(rowData);
            i++;
        }
    }

    public phieuMuonChoMuon getFormPhieuMuonChoMuon() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        String maTTV = this.txtMaTTVChoMuon.getText().trim();
        String ngayMuon = dtf.format(now);
        String ngayHenTra = this.txtNgayHenTraChoMuon.getText().trim();
        String ghiChu = this.txtGhiChuChoMuon.getText().trim();
        String tienCocStr = this.txtTienCocChoMuon.getText().trim();

        if (maTTV.length() == 0
                || ngayHenTra.length() == 0
                || ghiChu.length() == 0
                || tienCocStr.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn nhập đủ Mã TTV, ngày hẹn trả, tiền cọc và ghi chú đi nhé!");
            return null;
        }

        double tienCoc = -1;

        try {
            tienCoc = Double.parseDouble(tienCocStr);
            if (tienCoc < 0) {
                JOptionPane.showMessageDialog(this, "Tiền cọc phải là số dương!");
                return null;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá phải là số!");
            return null;
        }

        phieuMuonChoMuon pm = new phieuMuonChoMuon(maTTV, ngayMuon, ngayHenTra, ghiChu, tienCoc);
        return pm;
    }

    public phieuMuonChiTietChoMuon getFormPhieuMuonChiTietChoMuon() {
        String maISBN = this.txtMaISBNChoMuon.getText().trim().toString();
        if (maISBN.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập mã ISBN rồi thử lại nhé!");
            return null;
        }
        phieuMuonChiTietChoMuon pmct = new phieuMuonChiTietChoMuon();
        pmct.setMaISBN(maISBN);
        pmct.setMaPhieuMuon(maPhieuMuonChoMuon);
        return pmct;
    }

    public void loadTablePhieuTraTraSach() {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuTraTraSach.getModel();
        model.setRowCount(0);
        for (phieuTraViewModel pt : ptService.getAllListPhieuTra()) {
            Object rowData[] = {
                pt.getMaPhieuTra(),
                pt.getMaPhieuMuon(),
                pt.getTenDocGia(),
                pt.getDiaChiDocGia(),
                pt.getNgayMuon(),
                pt.getNgayHenTra(),
                pt.getNgayTra(),
                pt.getGhiChu(),};
            model.addRow(rowData);
        }
    }

    public void loadTablePhieuTraChiTietTraSach() {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuTraChiTietTraSach.getModel();
        model.setRowCount(0);
        for (phieuTraChiTietTraSachViewModel ptct : ptctService.getAllListPhieuTraChiTiet(maPhieuTraXXX)) {
            Object rowData[] = {
                ptct.getMaPhieuTra(),
                ptct.getMaQuyenSach(),
                ptct.getTenSach(),
                ptct.getTinhTrangSachString(),
                ptct.getDoHuHao()
            };
            model.addRow(rowData);
        }
    }

    public void loadTableSachInPhieuDen(String maTTV) {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuDenResultSearch.getModel();
        model.setRowCount(0);
        for (phieuDenSearchByMaTTVViewModel pd : pdService.getAllSachByMaTTV(maTTV)) {
            Object rowData[] = {
                pd.getMaPhieuMuon(),
                pd.getMaQuyenSach(),
                pd.getTenSach(),
                pd.getNgayMuon(),
                pd.getNgayHenTra(),
                pd.getTenNguoiMuon(),
                pd.getTinhTrangSachSTR(),
                pd.getDoHuHao()
            };
            model.addRow(rowData);
        }
    }

    public void loadTablePhieuDen() {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuDen.getModel();
        model.setRowCount(0);
        for (phieuDenViewModel pd : pdService.getAllListPhieuDen()) {
            Object rowData[] = {
                pd.getMaPhieuDen(),
                pd.getMaPhieuMuon(),
                pd.getMaNV(),
                pd.getMaTTV(),
                pd.getTenDocGia(),
                pd.getSoTienPhat(),
                pd.getNgayPhat(),
                pd.getLyDoPhat()
            };
            model.addRow(rowData);
        }
    }

    public void loadTablePhieuDenChiTiet(String maPhieuDen) {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuDenChiTiet.getModel();
        model.setRowCount(0);
        for (phieuDenChiTietViewModel pdct : pdctService.getAllListPhieuDenChiTietByMaPhieuDen(maPhieuDen)) {
            Object rowData[] = {
                pdct.getMaPhieuDen(),
                pdct.getMaQuyenSach(),
                pdct.getTenSach(),
                pdct.getTinhTrangSachSTR(),
                pdct.getDoHuHao()
            };
            model.addRow(rowData);
        }
    }

    public void loadTableDocGia() {
        DefaultTableModel model = (DefaultTableModel) this.tblDocGia.getModel();
        model.setRowCount(0);
        for (docGiaModel dg : dgService.getAllListDocGia()) {
            Object rowData[] = {
                dg.getMaDocGia(),
                dg.getHoTen(),
                dg.getNgaySinh(),
                dg.getGioiTinh(),
                dg.getDiaChi(),
                dg.getSdt()
            };
            model.addRow(rowData);
        }
    }

    public void loadTableSearchDocGia(String maDocGia) {
        DefaultTableModel model = (DefaultTableModel) this.tblDocGia.getModel();
        model.setRowCount(0);
        for (docGiaModel dg : dgService.searchDocGia(maDocGia)) {
            Object rowData[] = {
                dg.getMaDocGia(),
                dg.getHoTen(),
                dg.getNgaySinh(),
                dg.getGioiTinh(),
                dg.getDiaChi(),
                dg.getSdt()
            };
            model.addRow(rowData);
        }
    }

    public docGiaModel getFormDataDocGia() {
        String sdt = "";
        String hoTen = this.txtHoTenDG.getText().trim();
        String ngaySinh = this.txtNgaySinhDG.getText().trim();
        String gioiTinh = "";
        if (rdoGioiTinhNamDG.isSelected()) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        String diaChi = this.txtDiaChiDG.getText().trim();
        String sdtSTR = this.txtSDTDG.getText().trim();

        if (hoTen.length() == 0 || ngaySinh.length() == 0 || gioiTinh.length() == 0 || diaChi.length() == 0 || sdtSTR.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn Điền Đủ Thông Tin Vào Form Rồi Thử Lại Nhé");
            return null;
        }

        int sdtINT = -1;

        try {
            sdtINT = Integer.parseInt(sdtSTR);
            if (sdtINT < 0) {
                JOptionPane.showMessageDialog(this, "Số Điện Thoại Phải Là Số Dương!");
                sdt = null;
                return null;
            } else {
                sdt = sdtINT + "";
            }
        } catch (Exception e) {
            sdt = null;
            JOptionPane.showMessageDialog(this, "Số Điện Thoại Phải Là Số!");
            e.printStackTrace();
            return null;
        }
        docGiaModel dg = new docGiaModel(hoTen, ngaySinh, gioiTinh, diaChi, sdt);
        return dg;
    }

    public void loadTableTheThuVien() {
        DefaultTableModel model = (DefaultTableModel) this.tblTheThuVien.getModel();
        model.setRowCount(0);
        for (theThuVienViewModel ttv : ttvService.getAllListTTV()) {
            Object rowData[] = {
                ttv.getMaTTV(),
                ttv.getMaDocGia(),
                ttv.getHoTen(),
                ttv.getNgayCap(),
                ttv.getNgayHetHan(),
                ttv.getGhiChu(),
                ttv.getTrangThai() == 1 ? "Còn Hiệu Lực" : "Hết Hiệu Lực",};
            model.addRow(rowData);
        }
    }

    public void loadCBBMaDocGia() {
        for (cbbMaDocGia dg : dgService.getAllMaDocGia()) {
            this.cbbMaDocGia.addItem(dg.getMaDocGia());
        }
    }

    public void loadTablePhieuMuonInTraSach(String maTTV) {
        DefaultTableModel modelX = (DefaultTableModel) this.tblDanhSachPhieuMuonInTraSach.getModel();
        modelX.setRowCount(0);
        for (phieuMuonInTraSach pm : ptService.searchPhieuMuonByMaTTV(maTTV)) {
            Object rowData[] = {
                pm.getMaPM(),
                pm.getMaTTV(),
                pm.getTenNguoiMuon(),
                pm.getNgayMuon(),
                pm.getNgayHenTra(),
                pm.getGhiChu()
            };
            modelX.addRow(rowData);
        }
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        panelWebCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
        BasicConfigurator.configure();
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource s = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(s));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                //  Logger.getLogger(QuanLyCuaHangSach.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result != null) {
                txtMaISBNChoMuon.setText(result.getText());
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
