package doublelinkedlistkas;

/**
 *
 * @author prakasa putra
 * GitHub Code: https://github.com/prakasa05
 */
public class DoubleLinkedListkas {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.printList(); // memanggil printList dari objek dll

        // menambahkan beberapa node
        dll.append(2); // menambahkan node dengan nilai 2
        System.out.println("Tambah beberapa node"); // cuma teks hehehe
        dll.prepend(3); // menambahkan node dengan nilai 3 di awal
        dll.append(4); // menambahkan node dengan nilai 4 di akhir
        dll.insert(2, 5); // menyisipkan node dengan nilai 5 di indeks 2
        dll.insert(3, 6); // menyisipkan node dengan nilai 6 di indeks 3
        dll.prepend(7); // menambahkan node dengan nilai 7 di awal
        dll.remove(4); //menghapus node di indeks 4
        dll.append(8); // menambahkan node dengan nilai 8 di akhir
        dll.removeFirst(); // menghapus node pertama
        dll.removeLast(); // menghapus node terakhir
        dll.prepend(9); // menambahkan node dengan nilai 9 di awal
        dll.append(6); // menambahkan node dengan nilai 6 di akhir
        
        // Memanggil printList setelah modifikasi
        dll.printList();
    }
}
