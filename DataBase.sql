
DROP DATABASE DuAn1_QuanLyThuVien

USE MASTER
CREATE DATABASE DuAn1_QuanLyThuVien

USE DuAn1_QuanLyThuVien

CREATE TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaNV VARCHAR(10) NOT NULL,
TaiKhoan VARCHAR(Max) NOT NULL,
MatKhau VARCHAR(Max) NOT NULL,
HoTen NVARCHAR(50) NOT NULL,
NgaySinh DATE NOT NULL,
GioiTinh  NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
SDT NVARCHAR(50) NOT NULL,
TrangThai INT NOT NULL,
ChucVu NVARCHAR(50) NOT NULL,
Avatar NVARCHAR(50) NOT NULL
)

CREATE TABLE DocGia(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaDocGia VARCHAR(10) NOT NULL,
HoTen NVARCHAR(50) NOT NULL,
NgaySinh DATE NOT NULL,
GioiTinh  NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
SDT NVARCHAR(50) NOT NULL,
)


CREATE TABLE TheLoai(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaTheLoai VARCHAR(10) NOT NULL,
TenTheLoai NVARCHAR(50) NOT NULL,
)

CREATE TABLE NhaXuatBan(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaNhaXuatBan VARCHAR(10) NOT NULL,
TenNhaXuatBan NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
SDT NVARCHAR(50) NOT NULL,
EMAIL NVARCHAR(50) NOT NULL,
WEBSITE NVARCHAR(50) NOT NULL,
)

CREATE TABLE DauSach(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
TenSach NVARCHAR(50) NOT NULL,
MaSach VARCHAR(10) NOT NULL,
TacGia  NVARCHAR(50) NOT NULL,
IDTheLoai UNIQUEIDENTIFIER NOT NULL,
IDNhaXuatBan UNIQUEIDENTIFIER NOT NULL,
NamXuatBan INT NOT NULL,
HinhAnh VARCHAR(200) NOT NULL,
Gia MONEY NOT NULL,
SoTrang INT NOT NULL,
SoLuong INT NOT NULL,
FOREIGN KEY (IDTheLoai) REFERENCES TheLoai(ID),
FOREIGN KEY (IDNhaXuatBan) REFERENCES NhaXuatBan(ID),
)

CREATE TABLE QuyenSach(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdDauSach UNIQUEIDENTIFIER Not null,
MaQuyenSach VARCHAR(10) NOT NULL,
MaISBN NVARCHAR(50) NOT NULL,
TinhTrangSach BIT NOT NULL,
DoHuHao float not null,
TrangThai INT NOT NULL,
FOREIGN KEY (IdDauSach) REFERENCES DauSach(ID),
)


CREATE TABLE PhieuYeuCauTTV(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
HoTen NVARCHAR(50) NOT NULL,
NgaySinh Date NOT NULL,
QueQuan NVARCHAR(50) NOT NULL,
GioiTinh  NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
SDT NVARCHAR(50) NOT NULL,
)

CREATE TABLE TheThuVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdDocGia UNIQUEIDENTIFIER NOT NULL,
MaTTV VARCHAR(10) NOT NULL,
NgayCap Date NOT NULL,
NgayHetHan Date,
GhiChu NVARCHAR(50) NOT NULL,
TrangThai INT NOT NULL,
FOREIGN KEY (IdDocGia) REFERENCES DocGia(ID),
)


CREATE TABLE PhieuMuon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdTTV UNIQUEIDENTIFIER NOT NULL,
MaPhieuMuon VARCHAR(10) NOT NULL,
NgayMuon DATE NOT NULL,
NgayHenTra DATE NOT NULL,
GhiChu NVARCHAR(Max),
TienCoc MONEY,
FOREIGN KEY (IdTTV) REFERENCES TheThuVien(ID)
)

CREATE TABLE PhieuMuonChiTiet(
IdPhieuMuon UNIQUEIDENTIFIER NOT NULL,
IdQuyenSach UNIQUEIDENTIFIER NOT NULL,
MaPhieuMuon VARCHAR(10) NOT NULL,
MaSach VARCHAR(10) NOT NULL,
TenSach NVARCHAR(50) NOT NULL,
TinhTrangSach NVARCHAR(50)NOT NULL,
DoHuHao float not null,
PRIMARY KEY(IdPhieuMuon,IdQuyenSach),
FOREIGN KEY (IdPhieuMuon) REFERENCES PhieuMuon(ID),
FOREIGN KEY (IdQuyenSach) REFERENCES QuyenSach(ID),
)


CREATE TABLE PhieuTra(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDPhieuMuon UNIQUEIDENTIFIER NOT NULL,
MaPhieuTra VARCHAR(10) NOT NULL,
TenDocGia NVARCHAR(50) NOT NULL,
DiaChiDocGia NVARCHAR(50) NOT NULL,
NgayMuon DATE NOT NULL,
NgayHenTra DATE NOT NULL,
NgayTra DATE NOT NULL,
GhiChu NVARCHAR(Max),
FOREIGN KEY (IdPhieuMuon) REFERENCES PhieuMuon(ID),
)

CREATE TABLE PhieuTraChiTiet(
IdPhieuTra UNIQUEIDENTIFIER NOT NULL,
IdQuyenSach UNIQUEIDENTIFIER NOT NULL,
MaSach VARCHAR(10) NOT NULL,
TenSach NVARCHAR(50) NOT NULL,
TinhTrangSach NVARCHAR(50)NOT NULL,
DoHuHao float not null,
PRIMARY KEY(IdPhieuTra,IdQuyenSach),
FOREIGN KEY (IdPhieuTra) REFERENCES PhieuTra(ID),
FOREIGN KEY (IdQuyenSach) REFERENCES QuyenSach(ID),
)


CREATE TABLE PhieuDen(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaPhieuDen VARCHAR(10) NOT NULL,
IDPhieuMuon UNIQUEIDENTIFIER NOT NULL,
IDNhanVien UNIQUEIDENTIFIER NOT NULL,
IDTTV UNIQUEIDENTIFIER NOT NULL,
SoTienPhat MONEY,
NgayTra DATE,
LyDoPhat NVARCHAR(50),
FOREIGN KEY (IDPhieuMuon) REFERENCES PhieuMuon(ID),
FOREIGN KEY (IDNhanVien) REFERENCES NhanVien(ID),
FOREIGN KEY (IDTTV) REFERENCES TheThuVien(ID)
)

CREATE TABLE PhieuDenChiTiet(
IdPhieuDen UNIQUEIDENTIFIER NOT NULL,
MaQuyenSach VARCHAR(10) NOT NULL,
TenSach NVARCHAR(50) NOT NULL,
TinhTrangSach NVARCHAR(50) NOT NULL,
DoHuHao float not null,
FOREIGN KEY (IdPhieuDen) REFERENCES PhieuDen(ID)
)

CREATE TABLE PhieuNopMuon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaPhieuNopMuon VARCHAR(10) NOT NULL,
IDPhieuMuon UNIQUEIDENTIFIER NOT NULL,
IDNhanVien UNIQUEIDENTIFIER NOT NULL,
IDTTV UNIQUEIDENTIFIER NOT NULL,
SoTienPhat MONEY,
NgayTra DATE,
FOREIGN KEY (IDPhieuMuon) REFERENCES PhieuMuon(ID),
FOREIGN KEY (IDNhanVien) REFERENCES NhanVien(ID),
FOREIGN KEY (IDTTV) REFERENCES TheThuVien(ID)
)

CREATE TABLE PhieuNopMuonChiTiet(
IdPhieuNopMuon UNIQUEIDENTIFIER NOT NULL,
MaSach VARCHAR(10) NOT NULL,
TenSach NVARCHAR(50) NOT NULL,
SoTrang INT NOT NULL,
TinhTrangSach NVARCHAR(50) NOT NULL,
DoHuHao float not null,
FOREIGN KEY (IdPhieuNopMuon) REFERENCES PhieuNopMuon(ID)
)


CREATE TABLE QuyenSachChiTiet(
IdQuyenSach UNIQUEIDENTIFIER NOT NULL,
MaPhieuMuon VARCHAR(50) NOT NULL,
FOREIGN KEY (IdQuyenSach) REFERENCES PhieuMuon(ID)
)
