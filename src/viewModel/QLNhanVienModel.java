
package viewModel;

import java.util.Date;

/**
 *
 * @author pqd15
 */
public class QLNhanVienModel {
    private String ma;
    private String hoten;
    private String sdt;
    private String tenTaiKhoan;
    private String matKhau;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String chucVu;
    private int trangThai;
    private String hinhAnh;

    public QLNhanVienModel() {
    }

    public QLNhanVienModel(String ma, String hoten, String sdt, String tenTaiKhoan, String matKhau, String ngaySinh, String gioiTinh, String diaChi, String chucVu, int trangThai) {
        this.ma = ma;
        this.hoten = hoten;
        this.sdt = sdt;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public QLNhanVienModel(String ma, String hoten, String sdt, String tenTaiKhoan, String matKhau, String ngaySinh, String gioiTinh, String diaChi, String chucVu, int trangThai, String hinhAnh) {
        this.ma = ma;
        this.hoten = hoten;
        this.sdt = sdt;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }


    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String tt(){
        if (trangThai == 1) {
            return "Ðang làm";
        }else
            return "Nghi làm";
    }

    @Override
    public String toString() {
        return "QLNhanVienModel{" + "ma=" + ma + ", hoten=" + hoten + ", sdt=" + sdt + ", tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", chucVu=" + chucVu + ", trangThai=" + trangThai + ", hinhAnh=" + hinhAnh + '}';
    }

    
    
    
    
}
