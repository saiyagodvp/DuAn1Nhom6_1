/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author FPT
 */
public class InPhieuDen {
    private String masach;
    private String ngaytra;
    private String tensach;
    private String lido;
    private int dohuhao;
    private double sotienphat;

    public InPhieuDen() {
    }

    public InPhieuDen(String masach, String ngaytra, String tensach, int dohuhao, double sotienphat, String lido) {
        this.masach = masach;
        this.ngaytra = ngaytra;
        this.tensach = tensach;
        this.lido = lido;
        this.dohuhao = dohuhao;
        this.sotienphat = sotienphat;
    }

    public String getLido() {
        return lido;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

  

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getDohuhao() {
        return dohuhao;
    }

    public void setDohuhao(int dohuhao) {
        this.dohuhao = dohuhao;
    }

    public double getSotienphat() {
        return sotienphat;
    }

    public void setSotienphat(double sotienphat) {
        this.sotienphat = sotienphat;
    }
    
    
}
