package sppPayment;

import java.util.*;

public class SppMain {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        boolean ulang = true;
        int pilihan, nis, kelas;
        String nama;

        dll.addLast(111, "Rika Belinda Safitri", 1);
        dll.addLast(112, "Gilda Anita Lailasari", 1);
        dll.addLast(113, "Rahmi Hastuti", 1);
        dll.addLast(114, "Dagel Oman Halim", 1);
        dll.addLast(115, "Mahdi Sirait", 1);
        dll.addLast(116, "Prakosa Kusumo", 2);
        dll.addLast(117, "Cakrawala Narpati", 2);
        dll.addLast(118, "Zamira Suartini", 2);
        dll.addLast(119, "Mahfud Mahendra", 2);
        dll.addLast(120, "Jarwa Abyasa Rajasa", 2);
        dll.addLast(120, "Warsita Tarihoran", 3);
        dll.addLast(120, "Pardi Harjo Waluyo", 3);
        dll.addLast(120, "Caket Rahmat Prabowo", 3);
        dll.addLast(120, "Ida Hastuti", 3);
        dll.addLast(120, "Vanesa Siska Yulianti", 3);

        try {
            while (ulang) {
                System.out.println();
                System.out.println("+---------------------------+");
                System.out.println("|    - SMPN 1 POLINEMA -    |");
                System.out.println("|   SISTEM PEMBAYARAN SPP   |");
                System.out.println("+---------------------------+");
                System.out.println("| -> [1] Kelola Siswa       |");
                System.out.println("| -> [2] Pembayaran SPP     |");
                System.out.println("| -> [3] Hasil Transaksi    |");
                System.out.println("| -> [0] Keluar             |");
                System.out.println("+---------------------------+");
                System.out.print("-> Masukan Pilihan: ");
                pilihan = sci.nextInt();
                switch (pilihan) {
                    case 1:
                        do {
                            System.out.println();
                            System.out.println("+---------------------------+");
                            System.out.println("|    - SMPN 1 POLINEMA -    |");
                            System.out.println("|      MANAJEMEN SISWA      |");
                            System.out.println("+---------------------------+");
                            System.out.println("| -> [1] Tambah Siswa       |");
                            System.out.println("| -> [2] Hapus Siswa        |");
                            System.out.println("| -> [3] Cari Siswa         |");
                            System.out.println("| -> [4] Tampilkan Siswa    |");
                            System.out.println("| -> [0] Batal              |");
                            System.out.println("+---------------------------+");
                            System.out.print("-> Masukan Pilihan: ");
                            pilihan = sci.nextInt();
                            System.out.println();
                            switch (pilihan) {
                                case 1:
                                    System.out.print("Masukan NIS: ");
                                    nis = sci.nextInt();
    
                                    System.out.print("Masukan nama: ");
                                    nama = scs.nextLine();
    
                                    System.out.print("Masukan kelas: ");
                                    kelas = sci.nextInt();
    
                                    dll.addLast(nis, nama, kelas);
                                    break;
                                case 2:
                                    System.out.println("-> [1] Hapus siswa");
                                    System.out.println("-> [2] Hapus semua siswa");
                                    System.out.println("-> [0] Batal");
                                    System.out.println("-----------------------------");
                                    System.out.print("-> Masukan Pilihan: ");
                                    pilihan = sci.nextInt();
                                    System.out.println();
                                    switch (pilihan) {
                                        case 1:
                                            System.out.print("Masukan kelas: ");
                                            kelas = sci.nextInt();
                                            System.out.println();
                                            dll.printByKelas(kelas);
                                            System.out.println();
                                            System.out.print("Masukan NIS: ");
                                            nis = sci.nextInt();
                                            dll.removeNis(nis);
                                            break;
                                        case 2:
                                            dll.clear();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.print("Input salah! ");
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.print("Masukan kelas: ");
                                    kelas = sci.nextInt();
                                    System.out.println();
                                    dll.printByKelas(kelas);
                                    System.out.println();
                                    System.out.print("Masukan NIS: ");
                                    nis = sci.nextInt();
                                    System.out.println();
                                    dll.search(nis);
                                    System.out.println();
                                    System.out.print("Tekan [ENTER]");
                                    scs.nextLine();

                                    break;
                                case 4:
                                    dll.print();
                                    System.out.println();
                                    System.out.print("Tekan [ENTER]");
                                    scs.nextLine();

                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.print("Input salah! ");
                                    break;
                            }
                            
                        } while (pilihan != 0);
                        break;
                    case 2:
                        System.out.print("hapus data: ");
                        break;
                    case 3:
                        System.out.print("cari data: ");
                        break;
                    case 4:
                        break;
                    case 0:
                        System.out.print("Keluar ");
                        ulang = false;
                        break;
                    default:
                        System.out.print("Input salah, ulangi! ");
                        break;
                }
                System.out.println();
                System.out.print("Tekan [ENTER]");
                scs.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
