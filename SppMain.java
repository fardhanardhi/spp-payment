package sppPayment;

import java.util.*;

public class SppMain {
    public static void main(String[] args) {
        OperasiSiswa os = new OperasiSiswa();
        OperasiTransaksi ot = new OperasiTransaksi();
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        boolean ulang = true;
        int pilihan, nis, jumlahBulan, jumlahBayar;
        String nama, kelas;
        NodeSiswa siswa;

        os.addLast(111, "Rika Belinda Safitri", "VII");
        os.addLast(112, "Gilda Anita Lailasari", "VII");
        os.addLast(113, "Rahmi Hastuti", "VII");
        os.addLast(114, "Dagel Oman Halim", "VII");
        os.addLast(115, "Mahdi Sirait", "VII");
        os.addLast(116, "Prakosa Kusumo", "VIII");
        os.addLast(117, "Cakrawala Narpati", "VIII");
        os.addLast(118, "Zamira Suartini", "VIII");
        os.addLast(119, "Mahfud Mahendra", "VIII");
        os.addLast(120, "Jarwa Abyasa Rajasa", "VIII");
        os.addLast(121, "Warsita Tarihoran", "IX");
        os.addLast(122, "Pardi Harjo Waluyo", "IX");
        os.addLast(123, "Caket Rahmat Prabowo", "IX");
        os.addLast(124, "Ida Hastuti", "IX");
        os.addLast(125, "Vanesa Siska Yulianti", "IX");

        ot.addLast(os.head, 150000, 1);
        ot.addLast(os.head.next, 500000, 2);
        ot.addLast(os.head.next.next, 150000, 1);
        ot.addLast(os.head.next.next.next.next, 150000, 1);
        ot.addLast(os.head.next.next.next, 150000, 1);
        ot.addLast(os.head.next, 750000, 2);
        ot.addLast(os.head.next.next.next.next.next.next.next, 150000, 1);
        ot.addLast(os.head.next.next.next.next, 550000, 3);
        ot.addLast(os.head.next, 150000, 1);
        ot.addLast(os.head.next.next.next.next, 150000, 1);

        try {
            while (ulang) {
                System.out.println();
                System.out.println("+---------------------------+");
                System.out.println("|    - SMPN 1 POLINEMA -    |");
                System.out.println("|   SISTEM PEMBAYARAN SPP   |");
                System.out.println("+---------------------------+");
                System.out.println("| -> [1] Pembayaran SPP     |");
                System.out.println("| -> [2] Kelola Siswa       |");
                System.out.println("| -> [3] Kelola Transaksi   |");
                System.out.println("| -> [0] Keluar             |");
                System.out.println("+---------------------------+");
                System.out.print("-> Masukan Pilihan: ");
                pilihan = sci.nextInt();
                switch (pilihan) {
                    case 1:
                        System.out.println();
                        do {
                            System.out.print("Masukan Kelas Siswa: ");
                            kelas = scs.nextLine();
                        } while (!os.isKelas(kelas));
                        System.out.println();
                        os.printByKelas(kelas);
                        System.out.println();
                        do {
                            System.out.print("Pilih NIS\t: ");
                            nis = sci.nextInt();
                        } while (!os.isNis(nis));
                        siswa = os.getSiswa(nis);
                        System.out.print("Jumlah bulan\t: ");
                        jumlahBulan = sci.nextInt();
                        System.out.print("Jumlah uang (Rp): ");
                        jumlahBayar = sci.nextInt();
                        ot.addLast(siswa, jumlahBayar, jumlahBulan);
                        break;
                    case 2:
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

                                    do {
                                        System.out.print("Masukan kelas: ");
                                        kelas = scs.nextLine();
                                    } while (!os.isKelas(kelas));

                                    os.addLast(nis, nama, kelas);
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
                                            do {
                                                System.out.print("Masukan kelas: ");
                                                kelas = scs.nextLine();
                                            } while (!os.isKelas(kelas));
                                            System.out.println();
                                            os.printByKelas(kelas);
                                            System.out.println();
                                            do {
                                                System.out.print("Masukan NIS: ");
                                                nis = sci.nextInt();
                                            } while (!os.isNis(nis));
                                            os.removeNis(nis);
                                            break;
                                        case 2:
                                            os.clear();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.print("Input salah! ");
                                            break;
                                    }
                                    break;
                                case 3:
                                    do {
                                        System.out.print("Masukan kelas: ");
                                        kelas = scs.nextLine();
                                    } while (!os.isKelas(kelas));
                                    System.out.println();
                                    os.printByKelas(kelas);
                                    System.out.println();
                                    do {
                                        System.out.print("Masukan NIS: ");
                                        nis = sci.nextInt();
                                    } while (!os.isNis(nis));
                                    System.out.println();
                                    os.search(nis);
                                    System.out.println();
                                    System.out.print("Tekan [ENTER]");
                                    scs.nextLine();

                                    break;
                                case 4:
                                    os.print();
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
                    case 3:
                        do {
                            System.out.println();
                            System.out.println("+----------------------------+");
                            System.out.println("|    - SMPN 1 POLINEMA -     |");
                            System.out.println("|    MANAJEMEN TRANSAKSI     |");
                            System.out.println("+----------------------------+");
                            System.out.println("| -> [1] Hapus Transaksi     |");
                            System.out.println("| -> [2] Cari Transaksi      |");
                            System.out.println("| -> [3] Tampilkan Transaksi |");
                            System.out.println("| -> [0] Batal               |");
                            System.out.println("+----------------------------+");
                            System.out.print("-> Masukan Pilihan: ");
                            pilihan = sci.nextInt();
                            System.out.println();
                            switch (pilihan) {
                                case 1:
                                    System.out.println("-> [1] Hapus Transaksi");
                                    System.out.println("-> [2] Hapus semua Transaksi");
                                    System.out.println("-> [0] Batal");
                                    System.out.println("-----------------------------");
                                    System.out.print("-> Masukan Pilihan: ");
                                    pilihan = sci.nextInt();
                                    System.out.println();
                                    switch (pilihan) {
                                    case 1:
                                        do {
                                            System.out.print("Masukan kelas: ");
                                            kelas = scs.nextLine();
                                        } while (!os.isKelas(kelas));
                                        System.out.println();
                                        ot.printByKelas(kelas);
                                        System.out.println();
                                        do {
                                            System.out.print("Masukan NIS: ");
                                            nis = sci.nextInt();
                                        } while (!os.isNis(nis));
                                        ot.removeNis(nis);
                                        System.out.println();
                                        System.out.print("Transaksi berhasil dihapus [ENTER]");
                                        scs.nextLine();

                                        break;
                                    case 2:
                                        ot.clear();
                                        System.out.println();
                                        System.out.print("Semua transaksi berhasil dihapus [ENTER]");
                                        scs.nextLine();
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.print("Input salah! ");
                                        break;
                                    }
                                    break;
                                case 2:
                                    do {
                                        System.out.print("Masukan kelas: ");
                                        kelas = scs.nextLine();
                                    } while (!os.isKelas(kelas));
                                    System.out.println();
                                    ot.printByKelas(kelas);
                                    System.out.println();

                                    System.out.print("Tekan [ENTER]");
                                    scs.nextLine();
                                    break;
                                case 3:
                                    ot.print();
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
