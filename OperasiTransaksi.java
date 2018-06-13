package sppPayment;

public class OperasiTransaksi {
    NodeTransaksi head;
    int size;
    int perbulan = 150000;

    public OperasiTransaksi() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(NodeSiswa siswa, int jumlahBayar, int jumlahBulan) {
        if (isEmpty()) {
            head = new NodeTransaksi(null, siswa, jumlahBayar, jumlahBulan, null);
        } 
        else {
            NodeTransaksi newNode = new NodeTransaksi(null, siswa, jumlahBayar, jumlahBulan, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    
    public void addLast(NodeSiswa siswa, int jumlahBayar, int jumlahBulan) {
        if (perbulan * jumlahBulan > jumlahBayar) {
            System.out.println("Uang yang dibayarkan tidak mencukupi untuk membayar SPP");
        }
        else {
            if (isEmpty()) {
                addFirst(siswa, jumlahBayar, jumlahBulan);
            } 
            else {
                NodeTransaksi current = head;
                while (current.next != null) {
                    current = current.next;
                }
                NodeTransaksi newNode = new NodeTransaksi(current, siswa, jumlahBayar, jumlahBulan, null);
                current.next = newNode;
                size++;
            }
            System.out.println("Kembalian\t: Rp." + hitungKembalian(jumlahBayar, jumlahBulan));
        }
    }

    public int hitungKembalian(int jumlahBayar, int jumlahBulan) {
        int kembalian = jumlahBayar - (perbulan * jumlahBulan);
        return kembalian;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        int jumlah = 0;
        if (!isEmpty()) {
            NodeTransaksi tmp = head;
            while (tmp != null) {
                System.out.println("NIS\t\t: " + tmp.siswa.nis);
                System.out.println("Nama\t\t: " + tmp.siswa.nama);
                System.out.println("Kelas\t\t: " + tmp.siswa.kelas);
                System.out.println("Jumlah Bayar\t: " + tmp.jumlahBayar);
                System.out.println("Jumlah Bulan\t: " + tmp.jumlahBulan);
                System.out.println("Kembalian\t: Rp." + hitungKembalian(tmp.jumlahBayar, tmp.jumlahBulan));
                System.out.println("-----------------------------");
                tmp = tmp.next;
                jumlah++;
            }
            System.out.println("Total: " + jumlah + " transaksi");
        } else
            System.out.println("Linked list kosong");
    }

    public void printByKelas(String kelas) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar transaksi masih kosong");
        boolean ditemukan = false;
        NodeTransaksi tmp = head;
        int jumlah = 0;
        for (int i = 0; i < size; i++) {
            if (tmp.siswa.kelas.equalsIgnoreCase(kelas)) {
                ditemukan = true;
                System.out.println("NIS\t\t: " + tmp.siswa.nis);
                System.out.println("Nama\t\t: " + tmp.siswa.nama);
                System.out.println("Kelas\t\t: " + tmp.siswa.kelas);
                System.out.println("Jumlah Bayar\t: " + tmp.jumlahBayar);
                System.out.println("Jumlah Bulan\t: " + tmp.jumlahBulan);
                System.out.println("Kembalian\t: Rp." + hitungKembalian(tmp.jumlahBayar, tmp.jumlahBulan));
                System.out.println("-----------------------------");
                jumlah++;
            }
            tmp = tmp.next;
        }
        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan");
        } else {
            System.out.println("-> " + jumlah + " Transaksi ditemukan");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty())
            throw new Exception("Linked list masih kosong, tidak dapat dihapus");
        else if (size == 1)
            removeLast();
        else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty())
            throw new Exception("Linked list masih kosong, tidak dapat dihapus");
        if (head.next == null) {
            head = null;
            size--;
        }
        else {
            NodeTransaksi current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
        }
    }

    /* public void search(int nis) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar siswa masih kosong");
        boolean ditemukan = false;
        NodeTransaksi tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.nis != nis) {
                tmp = tmp.next;
            } else {
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan)
            throw new Exception("Nilai tidak ditemukan");
        else {
            System.out.println("Data ditemukan");
            System.out.println("- NIS\t: " + tmp.nis);
            System.out.println("- Nama\t: " + tmp.nama);
            System.out.println("- Kelas\t: " + tmp.kelas);
        }
    } */

    /* public NodeTransaksi getSiswa(int nis) {
        if (isEmpty())
            throw new Exception("Daftar siswa masih kosong");
        boolean ditemukan = false;
        NodeTransaksi tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.nis != nis) {
                tmp = tmp.next;
            } else {
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan)
            throw new Exception("Nilai tidak ditemukan");
        else {
            return tmp;
        }
    } */

    public void removeNis(int nis) throws Exception {
        if (isEmpty())
            throw new Exception("Linked list kosong");
        if (head.siswa.nis == nis)
            removeFirst();
        else {
            NodeTransaksi current = head;
            while (current.next != null) {
                current = current.next;
                if (current.siswa.nis == nis) {
                    break;
                }
            }
            if (current.next == null)
                current.prev.next = null;
            else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
}
