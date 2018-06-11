package sppPayment;

public class Node {
    String nama;
    int kelas, nis;
    Node prev, next;

    Node(Node prev, int nis, String nama, int kelas, Node next) {
        this.prev = prev;
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.next = next;
    }
}