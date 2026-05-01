package pertemuan7;

import java.sql.*;

public class DatabaseHelper {

    // Sesuaikan path ini dengan lokasi folder project pertemuan7 kamu
    private static final String DB_PATH = "database/datamhs.db";
    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    // Membuka koneksi ke database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Membuat tabel dan mengisi data dummy jika belum ada
    public static void initDatabase() {
        String createTable = """
                CREATE TABLE IF NOT EXISTS mahasiswa (
                    id      INTEGER PRIMARY KEY AUTOINCREMENT,
                    nim     TEXT NOT NULL,
                    nama    TEXT NOT NULL,
                    jurusan TEXT NOT NULL,
                    ipk     REAL NOT NULL
                );
                """;

        String[] dummyData = {
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021001', 'Ucup Trondol',    'Teknik Informatika', 2.75)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021002', 'Asep Bobok',    'Sistem Informasi',   3.59)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021003', 'Leha Leho',      'Teknik Informatika', 1.90)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021004', 'Dudung Kecap',     'Manajemen Informatika', 2.20)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021005', 'Eko Es Bayem',     'Sistem Informasi',   3.65)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021006', 'Siti Nur Udin',  'Teknik Informatika', 3.80)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021007', 'Udin Bubut',  'Manajemen Informatika', 2.85)",
            "INSERT OR IGNORE INTO mahasiswa (nim, nama, jurusan, ipk) VALUES ('2021008', 'Bakri Bubut',   'Sistem Informasi',   3.40)",
        };

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTable);

            for (String sql : dummyData) {
                stmt.execute(sql);
            }

            System.out.println("Database siap.");

        } catch (SQLException e) {
            System.err.println("Error inisialisasi database: " + e.getMessage());
        }
    }

    // Mengambil semua data mahasiswa
    public static ResultSet getAllMahasiswa(Connection conn) throws SQLException {
        String sql = "SELECT id, nim, nama, jurusan, ipk FROM mahasiswa ORDER BY id";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}