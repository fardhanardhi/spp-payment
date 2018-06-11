package sppPayment;

import java.util.*;

public class SppMain {
    public static void main(String[] args) {
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        BinarySearchTree b = new BinarySearchTree();
        int pilihan, id;
        boolean ulang = true;
        
        while (ulang) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("\n                   SMPN 1 POLINEMA                  ");
            System.out.println("\n            LANGKAH - LANGKAH MEMBAYAR SPP          ");
            System.out.println("\n            **INFORMASI PEMBAYARAN SISWA**          ");
            System.out.println("\n----------------------------------------------------");
            System.out.println(" 1. Data Transkip SPP");
            System.out.println(" 2. Hasil Transaksi");
            System.out.println(" 3. Keluar");
            System.out.println("SILAHKAN MASUKKAN SESUAI URUTAN NOMER !");
            System.out.print("Masukan pilihan: ");
            
            System.out.println("DOUBLE LINKEDLIST DENGAN MENU");
            System.out.println("=============================");
            System.out.println("[1] Insert ");
            System.out.println("[2] Delete");
            System.out.println("[3] Find");
            System.out.println("[4] Display");
            System.out.println("[0] Keluar");
            System.out.println("=============================");
            System.out.print(">> ");
            pilihan = sci.nextInt();
            System.out.println("=============================");
            System.out.println();
            switch (pilihan) {
            case 1:
                System.out.print("masukan data baru: ");
                id = sci.nextInt();
                b.insert(id);
                break;
            case 2:
                System.out.print("hapus data: ");
                id = sci.nextInt();
                b.delete(id);
                break;
            case 3:
                System.out.print("cari data: ");
                id = sci.nextInt();
                System.out.println(b.find(id));
                System.out.println(b.findNode(id).data);
                break;
            case 4:
                b.display(b.root);
                break;
            case 0:
                System.out.print("Keluar ");
                ulang = false;
                break;
            default:
                System.out.print("Input salah, ulangi! ");
                break;
            }
            System.out.print("[ENTER]");
            scs.nextLine();
            System.out.println();
        }

    }
}
