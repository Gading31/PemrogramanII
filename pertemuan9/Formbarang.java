/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author dingg
 */
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import koneksi.Koneksi;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Formbarang extends javax.swing.JFrame {

    /**
     * Creates new form Formbarang
     */
    public Formbarang() {
        initComponents();
        tampilData();
    }
    
    private void hapusBarang(){

    try{

        String sql =
        "DELETE FROM barang WHERE id_barang=?";

        PreparedStatement pst =
        Koneksi.getKoneksi().prepareStatement(sql);

        pst.setInt(
                1,
                Integer.parseInt(txtId.getText())
        );

        pst.executeUpdate();

        tampilData();

        JOptionPane.showMessageDialog(
                null,
                "Data berhasil dihapus"
        );

    }catch(Exception e){

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );

    }

}
    
    private void editBarang(){

    try{

        String sql =
        "UPDATE barang SET nama_barang=?, harga=?, stok=? WHERE id_barang=?";

        PreparedStatement pst =
        Koneksi.getKoneksi().prepareStatement(sql);

        pst.setString(1, txtNama.getText());

        pst.setDouble(
                2,
                Double.parseDouble(txtHarga.getText())
        );

        pst.setInt(
                3,
                Integer.parseInt(txtStok.getText())
        );

        pst.setInt(
                4,
                Integer.parseInt(txtId.getText())
        );

        pst.executeUpdate();

        tampilData();

        JOptionPane.showMessageDialog(
                null,
                "Data berhasil diubah"
        );

    }catch(Exception e){

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );

    }

}
    
    private void simpanBarang(){

    try{

        String sql =
        "INSERT INTO barang(nama_barang,harga,stok) VALUES(?,?,?)";

        PreparedStatement pst =
        Koneksi.getKoneksi().prepareStatement(sql);

        pst.setString(
                1,
                txtNama.getText()
        );

        pst.setDouble(
                2,
                Double.parseDouble(txtHarga.getText())
        );

        pst.setInt(
                3,
                Integer.parseInt(txtStok.getText())
        );

        pst.executeUpdate();
        
        tampilData();

        JOptionPane.showMessageDialog(
                null,
                "Data berhasil disimpan"
        );

        txtNama.setText("");
        txtHarga.setText("");
        txtStok.setText("");

        txtNama.requestFocus();

    }catch(Exception e){

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );

    }

}
    
    private void tampilData(){

    DefaultTableModel model =
            new DefaultTableModel();

    model.addColumn("ID Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga");
    model.addColumn("Stok");

    try{

        String sql =
        "SELECT * FROM barang";

        PreparedStatement pst =
        Koneksi.getKoneksi().prepareStatement(sql);

        ResultSet rs =
        pst.executeQuery();

        while(rs.next()){

            model.addRow(
                new Object[]{

                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("harga"),
                    rs.getString("stok")

                }
            );

        }

        tblBarang.setModel(model);

    }catch(Exception e){

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );

    }

}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setText("ID");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNama.setText("Nama");

        txtHarga.setText("Harga");

        txtStok.setText("Stok");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Harga", "Stok"
            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpanBarang();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editBarang();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusBarang();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        int baris = tblBarang.getSelectedRow();

    txtId.setText(
            tblBarang.getValueAt(baris,0).toString()
    );

    txtNama.setText(
            tblBarang.getValueAt(baris,1).toString()
    );

    txtHarga.setText(
            tblBarang.getValueAt(baris,2).toString()
    );

    txtStok.setText(
            tblBarang.getValueAt(baris,3).toString()
    );
    }//GEN-LAST:event_tblBarangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
