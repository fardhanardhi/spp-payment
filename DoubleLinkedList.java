package sppPayment;

public class DoubleLinkedList {
    Node head;
    int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int nis, String nama, int kelas) {
        if (isEmpty()) {
            head = new Node(null, nis, nama, kelas, null);
        } else {
            Node newNode = new Node(null, nis, nama, kelas, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int nis, String nama, int kelas) {
        if (isEmpty()) {
            addFirst(nis, nama, kelas);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(current, nis, nama, kelas, null);
            current.next = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            System.out.println("Kelas\tNIS\tNama");
            System.out.println("----------------------");
            while (tmp != null) {
                System.out.println(tmp.kelas + "\t" + tmp.nis + "\t" + tmp.nama);
                tmp = tmp.next;
            }
        } 
        else
            System.out.println("Linked list kosong");
    }

    public void printByKelas(int kelas) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar siswa masih kosong");
        boolean ditemukan = false;
        Node tmp = head;
        int jumlah = 0;
        System.out.println("Kelas\t NIS\tNama");
        System.out.println("----------------------");
        for (int i = 0; i < size; i++) {
            if (tmp.kelas == kelas) {
                ditemukan = true;
                System.out.println(tmp.kelas + "\t[" + tmp.nis + "]\t" + tmp.nama);
                jumlah++;
            } 
            tmp = tmp.next;
        }
        if (!ditemukan) {
            System.out.println("----------------------");
            throw new Exception("Nilai tidak ditemukan");
        }
        else {
            System.out.println("----------------------");
            System.out.println("-> " + jumlah + " Data ditemukan");
        }
    }
    
    // public void printByKelas(int kelas) {
    //     if (!isEmpty()) {
    //         Node tmp = head;
    //         System.out.println("Data siswa kelas " + kelas);
    //         System.out.println("----------------");
    //         while (tmp != null) {
    //             if (tmp.kelas == kelas) {
    //                 System.out.println("[" + tmp.nis + "] \t" + tmp.nama + "\t" + tmp.kelas);
    //                 tmp = tmp.next;
    //             }
    //         }
    //     } 
    //     else
    //         System.out.println("Linked list kosong");
    // }

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
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    // public void remove(int index) throws Exception {
    //     if (isEmpty() || index >= size)
    //         throw new Exception("Nilai indeks diluar batas");
    //     if (index == 0)
    //         removeFirst();
    //     else {
    //         Node current = head;
    //         int i = 0;
    //         while (i < index) {
    //             current = current.next;
    //             i++;
    //         }
    //         if (current.next == null)
    //             current.prev.next = null;
    //         else if (current.prev == null) {
    //             current = current.next;
    //             current.prev = null;
    //             head = current;
    //         } else {
    //             current.prev.next = current.next;
    //             current.next.prev = current.prev;
    //         }
    //         size--;
    //     }
    // }

    public void search(int nis) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar siswa masih kosong");
        boolean ditemukan = false;
        Node tmp = head;
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
    }
    
    public void removeNis(int nis) throws Exception {
        if (isEmpty())
            throw new Exception("Linked list kosong");
        if (head.nis == nis)
            removeFirst();
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
                if (current.nis == nis) {
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

    // public int getFirst() throws Exception {
    //     if (isEmpty())
    //         throw new Exception("Linked list kosong");
    //     return head.data;
    // }

    // public int getLast() throws Exception {
    //     if (isEmpty())
    //         throw new Exception("Linked list kosong");
    //     Node tmp = head;
    //     while (tmp.next != null) {
    //         tmp = tmp.next;
    //     }
    //     return tmp.data;
    // }

    // public int get(int index) throws Exception {
    //     if (isEmpty() || index >= size)
    //         throw new Exception("nilai indeks diluar batas");
    //     Node tmp = head;
    //     for (int i = 0; i < index; i++) {
    //         tmp = tmp.next;
    //     }
    //     return tmp.data;
    // }
}
