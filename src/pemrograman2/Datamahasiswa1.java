/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pemrograman2;

import java.util.Scanner;

/**
 *
 * @author mgadi
 */
public class Datamahasiswa1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String nim = null, nama = null, grade;
        double uts = 0, uas = 0, rata;
        
        System.out.println("data: ");
        System.out.print("nim: "); input.next();
        System.out.print("nama: "); input.next();
        System.out.print("nilai UTS: "); input.nextDouble();
        System.out.print("nilai UAS: "); input.nextDouble();
        
        rata = (uts+uas)/2;
        
            if(rata<50)
                grade = "E";
            else if(rata < 60)
                grade = "D";
            else if (rata < 70)
                grade = "C";
            else if (rata < 80)
                grade = "B";
            else
                grade = "A";
            
            System.out.println("==================================================");
            System.out.println("Nim\tNama\tUAS\tRata2\tGrade");
            System.out.println("==================================================");
            System.out.println(nim+"\t" +nama+ "\t" +uts+ "\t" +uas+ "\t" +rata+ "\t" +grade);
            
            System.out.println("");
            System.out.println("");

    }
    
}
