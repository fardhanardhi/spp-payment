package sppPayment;

public class NodeTransaksi {
    NodeSiswa siswa;
    int jumlahBayar;
    int jumlahBulan;
    NodeTransaksi prev;
    NodeTransaksi next;

    NodeTransaksi(NodeTransaksi prev, NodeSiswa siswa, int jumlahBayar, int jumlahBulan, NodeTransaksi next) {
        this.prev = prev;
        this.siswa = siswa;
        this.jumlahBayar = jumlahBayar;
        this.jumlahBulan = jumlahBulan;
        this.next = next;
    }
}
