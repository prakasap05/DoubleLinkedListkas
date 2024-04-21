package doublelinkedlistkas;

/**
 *
 * @author prakasa putra
 * GitHub Code: https://github.com/prakasa05
 */
public class DoubleLinkedList {
    private Node head; // pointer ke node pertama
    private Node tail; // pointer ke node terakhir
    private int length; // pointer dari linked list
    
    DoubleLinkedList() {
        head = null; // menginisilisasi head dengan null
        tail = null; // menginisilisasi tail dengan null
        length = 0; // menginisilisasi panjang dengan 0
    }

    class Node {
        int value; // nilai dari node
        Node next; // pointer ke node selanjutnya
        Node prev; // pointer ke node sebelumnya
        
        Node(int value) {
            this.value = value; // menginisilisasi nilai
        }
    }

    public DoubleLinkedList(int value) { // membuat node baru dengan nilai yang diberikan
        Node newNode = new Node(value); // menetepkan newNode sebagai head
        head = newNode; // menetapkan newNode sebagai tail
        tail = newNode; // panjang list menjadi 1
        length = 1;
    }
    
    public void append(int value) { // menambahkan node baru diakhir
        Node newNode = new Node(value); // membuat node baru dengan nilai yang diberikan
        if (length == 0) { // jika list kosong
            head = newNode; // head menujuk ke newNode
            tail = newNode; // tail menujuk ke NewNode
        } else { // jika list tidak kosong
            tail.next = newNode; // mengaitkan newNode di belakang tail
            newNode.prev = tail; //mengatikan tail di depan newNode
            tail = newNode; // mengubah tail menjadi newNode
        }
        length++; // menamabah panjang list
    }

    public void removeLast() { // menghapus node terakhir
        if (length == 0) { // jika list kosong
            System.out.println("List is empty, cannot remove."); // tampilkan pesan error
            return;
        } else if (length == 1) { // jika hanya satu node
            head = null; // set head menjadil null
            tail = null; // set tail menjadi null
        } else { // jika lebih dari satu node
            tail = tail.prev; // menghapus tail menjadi node sebelumnya
            tail.next = null; // menghapus kaitan ke node terakhir
        }
        length--; // mengurangi panjang list
    }

    public void prepend(int value) { // menambahkan node baru diawal
        Node newNode = new Node(value); // membuat node baru dengan nilai yang diberikan
        if (length == 0) { // jika list kosong
            head = newNode; // head menunjuk ke newNode
            tail = newNode; // tail menunjuk ke newNode
        } else { // jika list tidak kosomng
            newNode.next = head; // mengaitkan head di depan newNode
            head.prev = newNode; // mengaitkan newNode dibelakang head
            head = newNode; // mengubah head menjadi newNode
        }
        length++; // menambah panjang list
    }

    public void removeFirst() { // menghapus node pertama
        if (length == 0) { // jika list kosong
            System.out.println("List is empty, cannot remove."); // tampilkan pesan error
            return;
        } else if (length == 1) { // jika hanya satu node
            head = null; // set head menjadi null
            tail = null; // set tail menjad null
        } else { // jika lebih dar satu node
            head = head.next; // mengubah head menjadi node selanjutnya
            head.prev = null; // menghapus kaitan ke node pertama
        }
        length--; //mengurangi panjang list
    }

    public int get(int index) { // mendapatkan nilai node pada indeks tertentu
        if (index < 0 || index >= length) { // jika indeks di luar rentang
            throw new IndexOutOfBoundsException("Index out of bounds."); // lempar exception
        }
        Node current = head; // mulai dari head
        int count = 0;
        while (count != index) { // iterasi hingga indeks yang diinginkan
            current = current.next; // pindah ke node selanjutnya
            count++;
        }
        return current.value; // mengembalikan nilai dari node pada indeks tertentu
    }

    public void set(int index, int value) { // mengubah nilai node pada indeks tertentu
        if (index < 0 || index >= length) { // jika indeks di luar rentang
            throw new IndexOutOfBoundsException("Index out of bounds."); // lempar exception
        }
        Node current = head; // mulai dari head
        int count = 0;
        while (count != index) { // iterasi hingga indeks yang diinginkan
            current = current.next; // pindah ke node selanjutnya
            count++;
        }
        current.value = value; // mengubah nilai dari node pada indeks tertentu
    }

    public void insert(int index, int value) { // menyisipkan node baru pada indeks tertentu
        if (index < 0 || index > length) { // jika indeks di luar rentang
            throw new IndexOutOfBoundsException("Index out of bounds."); //lempar exception
        }
        if (index == 0) { // jika menyisipkan di awal
            prepend(value); // gunakan metode prepend
            return;
        }
        if (index == length) { // jika menyisipkan di akhir
            append(value); // gunakan metode append
            return;
        }
        Node newNode = new Node(value); // membuat node baru dengan nilai yang diberikan
        Node leader = traverseToIndex(index - 1); // node sebelum indeks yang diinginkan
        Node follower = leader.next; //node setelah indkes yang diinginkan
        leader.next = newNode; // mengaitkan newNode di bekalang leader
        newNode.prev = leader; // mengaitkan leader di depan newNode
        newNode.next = follower; //mengaitkan follower di depan newNode
        follower.prev = newNode; // mengaitkan newNode dibelakang follower
        length++; // menambah panjang list
    }

    public void remove(int index) { // menghapus node pada indeks tertentu
        if (index < 0 || index >= length) { // jika indeks di luar rentang
            throw new IndexOutOfBoundsException("Index out of bounds."); // lempar exception
        }
        if (index == 0) { // jika menghapus node pertama
            removeFirst(); // gunakan metode removeFirst
            return;
        }
        if (index == length - 1) { // jika menghapus node terakhir
            removeLast(); // gunakan metode removeLast
            return;
        }
        Node leader = traverseToIndex(index - 1); // node sebelum indeks yang diinginkan
        Node unwantedNode = leader.next; // node yang akan dihapus
        Node follower = unwantedNode.next; // node setelah node yang akan dihapus
        leader.next = follower; // mengaitkan follower di belakang leader
        follower.prev = leader; // mengaitkan leader di depan follower
        length--; // mengurangi panjang list
    }

    private Node traverseToIndex(int index) { // melakukan traversal hingga indeks yang diinginkan
        Node current = head; // mulai dari head
        int count = 0;
        while (count != index) { // iterasi hingga indeks yang diinginkan
            current = current.next; // pindah ke node selanjutnya
            count++;
        }
        return current; // mengembalikan node pada indeks tertentu
    }

    public void printList() { // mencetak seluruh isi dari list
        Node current = head; // mulai dari head
        while (current != null) { // iterasi hingga akhir list
            System.out.print(current.value + " "); // cetak nilai node
            current = current.next; // pindah ke node selanjutnya
        }
        System.out.println(); // pindah ke baris baru setelah mencetak seluruh list
    }
    
    public Node getHead() { // mendapatkan head dari linked list
        return head; // mengembalikan head
    }

    public void setHead(Node head) { // mengubah head dari linked list
        this.head = head; // menetapkan head baru
    }

    public Node getTail() { // mendapatkan tail dari linked list
        return tail; // mengembalikan tail
    }

    public void setTail(Node tail) { // mengubah tail dari linked list
        this.tail = tail; // menetapkan tail baru
    }
}
