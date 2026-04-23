/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemrograman2;

/**
 *
 * @author mgadi
 */
public class Mahasiswa2 {
    public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    
    Mahasiswa2 mhs = new Mahasiswa2();
    
    System.out.print("Masukkan NIM : ");
    mhs.setNim(input.nextLine());
    
    System.out.print("Masukkan Nama : ");
    mhs.setNama(input.nextLine());
    
    System.out.print("Masukkan Nilai UTS : ");
    mhs.setUts(input.nextFloat());
    
    System.out.print("Masukkan Nilai UAS : ");
    mhs.setUas(input.nextFloat());
    
    System.out.println("\n=== DATA MAHASISWA ===");
    System.out.println("NIM : " + mhs.getNim());
    System.out.println("Nama : " + mhs.getNama());
    System.out.println("UTS : " + mhs.getUts());
    System.out.println("UAS : " + mhs.getUas());
    System.out.println("Nilai Akhir : " + mhs.getNilaiAkhir());
    System.out.println("Grade : " + mhs.getGrade());
}
    
    public String nim, nama;
    private float uts, uas;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getUts() {
        return uts;
    }

    public void setUts(float uts) {
        this.uts = uts;
    }

    public float getUas() {
        return uas;
    }

    public void setUas(float uas) {
        this.uas = uas;
    }
    
    public double getNilaiAkhir(){
        float nilaiakhir = (uts + uas)/2;
        return nilaiakhir;
    }
    
    public String getGrade(){
        int nilaiakhir = 0;
        String grade;
        if(nilaiakhir<50)
                grade = "E";
            else if(nilaiakhir < 60)
                grade = "D";
            else if (nilaiakhir < 70)
                grade = "C";
            else if (nilaiakhir < 80)
                grade = "B";
            else
                grade = "A";
        return grade;
    }
    
}
