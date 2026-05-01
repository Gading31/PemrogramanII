package pertemuan6;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame {

    JTextField nimTF, namaTF, nil1TF, nil2TF, rataTF;
    DefaultTableModel tableModel;
    JTable table;

    public Main() {
        // Inisialisasi database dari Helper
        DatabaseHelper.initDB();

        setTitle("Data Nilai Mahasiswa - Tugas Pemrograman II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // 1. Panel Form Input (NORTH dari topPanel)
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        formPanel.add(new JLabel("NIM:"));       nimTF  = new JTextField(); formPanel.add(nimTF);
        formPanel.add(new JLabel("Nama:"));      namaTF = new JTextField(); formPanel.add(namaTF);
        formPanel.add(new JLabel("Nilai 1:"));   nil1TF = new JTextField(); formPanel.add(nil1TF);
        formPanel.add(new JLabel("Nilai 2:"));   nil2TF = new JTextField(); formPanel.add(nil2TF);
        formPanel.add(new JLabel("Rata-rata:")); rataTF = new JTextField(); rataTF.setEditable(false); formPanel.add(rataTF);

        // 2. Panel Tombol (CENTER dari topPanel)
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton tambahBtn = new JButton("Tambah");
        JButton cariBtn   = new JButton("Cari");
        JButton updateBtn = new JButton("Update");
        JButton hapusBtn  = new JButton("Hapus");
        JButton tampilBtn = new JButton("Tampil Semua");
        
        btnPanel.add(tambahBtn);
        btnPanel.add(cariBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(hapusBtn);
        btnPanel.add(tampilBtn);

        // Menggabungkan Form dan Tombol ke dalam satu panel atas
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.NORTH);
        topPanel.add(btnPanel, BorderLayout.CENTER);

        // 3. Tabel Hasil (CENTER dari Frame utama agar fleksibel)
        String[] kolom = {"NIM", "Nama", "Nilai 1", "Nilai 2", "Rata-rata"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Daftar Nilai Mahasiswa"));

        // Klik baris tabel -> isi form otomatis
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    nimTF.setText(tableModel.getValueAt(row, 0).toString());
                    namaTF.setText(tableModel.getValueAt(row, 1).toString());
                    nil1TF.setText(tableModel.getValueAt(row, 2).toString());
                    nil2TF.setText(tableModel.getValueAt(row, 3).toString());
                    rataTF.setText(tableModel.getValueAt(row, 4).toString());
                }
            }
        });

        // Menyusun komponen ke Frame Utama
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // --- AKSI TOMBOL ---

        tambahBtn.addActionListener(e -> {
            try {
                DatabaseHelper.tambahData(
                    nimTF.getText(), namaTF.getText(),
                    Double.parseDouble(nil1TF.getText()),
                    Double.parseDouble(nil2TF.getText())
                );
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
                clearFields();
                loadSemuaData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid atau NIM sudah ada!");
            }
        });

        cariBtn.addActionListener(e -> {
            tableModel.setRowCount(0);
            try (Connection conn = DatabaseHelper.connect();
                 ResultSet rs = DatabaseHelper.cariData(conn, namaTF.getText())) {
                boolean ada = false;
                while (rs.next()) {
                    ada = true;
                    tableModel.addRow(new Object[]{
                        rs.getString("nim"), rs.getString("nama"),
                        rs.getString("nil1"), rs.getString("nil2"), rs.getString("rata")
                    });
                }
                if (!ada) {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan!");
                }
            } catch (SQLException ex) {
                System.out.println("Cari data gagal: " + ex.getMessage());
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                DatabaseHelper.updateData(
                    nimTF.getText(), namaTF.getText(),
                    Double.parseDouble(nil1TF.getText()),
                    Double.parseDouble(nil2TF.getText())
                );
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                loadSemuaData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gagal update! Pastikan input benar.");
            }
        });

        hapusBtn.addActionListener(e -> {
            if (nimTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data di tabel untuk dihapus!");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Hapus NIM: " + nimTF.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DatabaseHelper.hapusData(nimTF.getText());
                clearFields();
                loadSemuaData();
            }
        });

        tampilBtn.addActionListener(e -> loadSemuaData());

        // Pengaturan Akhir Tampilan
        loadSemuaData();
        pack(); // Menyesuaikan ukuran otomatis agar tidak ada tombol terpotong
        setSize(900, 600); // Memberikan ruang lebih lega seperti pada gambar sddd.png
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadSemuaData() {
        tableModel.setRowCount(0);
        try (Connection conn = DatabaseHelper.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM datanilai")) {
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("nim"), rs.getString("nama"),
                    rs.getString("nil1"), rs.getString("nil2"), rs.getString("rata")
                });
            }
        } catch (SQLException e) {
            System.out.println("Load data gagal: " + e.getMessage());
        }
    }

    void clearFields() {
        nimTF.setText(""); namaTF.setText("");
        nil1TF.setText(""); nil2TF.setText(""); rataTF.setText("");
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi di Event Dispatch Thread (Saran UI Java)
        SwingUtilities.invokeLater(() -> new Main());
    }
}