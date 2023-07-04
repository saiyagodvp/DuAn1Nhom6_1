package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import service.phieuMuonChiTietService;
import service.phieuTraChiTietService;
import viewModel.phieuMuonChiTietViewModel;
import viewModel.phieuTraChiTietTraSachViewModel;
import viewModel.phieuTraViewModel;

public class XuatPhieuTra extends javax.swing.JFrame {

    private phieuTraChiTietService ptctService;

    public XuatPhieuTra(String maNV, String maPhieuTra, String maTTV, String tenDocGia, String ngayMuon, String ngayHenTra, String ngayTra, String ghiChu) {
        initComponents();
        setLocationRelativeTo(null);
        ptctService = new phieuTraChiTietService();
        txtFromPhieuMuon.setText("\nThư Viện Poly");
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n                                                         Phiếu Trả");
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\n\nMã Nhân Viên: " + maNV);
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nMã Phiếu Trả: " + maPhieuTra);
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nMã Thẻ Thư Viện: " + maTTV);
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nTên Người Mượn: " + tenDocGia + "\n\n");
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + String.format("%20s%20s%15s%21s%14s", "Mã Phiếu Trả", "Mã Quyển Sách", "Tên Sách", "Tình Trạng Sách", "Độ Hư Hao\n"));

        int i = 1;
        for (phieuTraChiTietTraSachViewModel ptct : ptctService.getAllListPhieuTraChiTiet(maPhieuTra)) {
            txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + String.format("%16s%22s%28s%24s%20s", ptct.getMaPhieuTra(), ptct.getMaQuyenSach(), ptct.getTenSach(), ptct.getTinhTrangSachString(), ptct.getDoHuHao()) + "\n");
        }

        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nNgày Mượn: " + ngayMuon);
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nNgày Hẹn Trả: " + ngayHenTra);
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nNgày Trả: " + ngayTra);
        txtFromPhieuMuon.setText(txtFromPhieuMuon.getText() + "\n\nGhi Chú: " + ghiChu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtFromPhieuMuon = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFromPhieuMuon.setColumns(20);
        txtFromPhieuMuon.setRows(5);
        jScrollPane1.setViewportView(txtFromPhieuMuon);

        jButton1.setText("Xuất Phiếu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            txtFromPhieuMuon.print();
        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "Xuất Phiếu Trả Thành Công!");
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new XuatPhieuMuon().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtFromPhieuMuon;
    // End of variables declaration//GEN-END:variables
}
