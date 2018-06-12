package sppPayment;

public class NodeSiswa {
    String nama;
    int kelas, nis;
    NodeSiswa prev;
    NodeSiswa next;

    NodeSiswa(NodeSiswa prev, int nis, String nama, int kelas, NodeSiswa next) {
        this.prev = prev;
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.next = next;
    }
}