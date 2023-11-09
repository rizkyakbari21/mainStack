/*
Made by 20230040002
Name : Rizky Akbari
Class : TI23C
*/

import java.util.Scanner;
import java.util.Stack;

public class mainStack {
    static int HitungBukuTeknik = 0;
    static int HitungBukuManajemen = 0;
    static int HitungBukuFiksi = 0;
    static int HitungBukuLainnya = 0;

    public static void main(String[] args) {
        Stack<String> dataBuku = new Stack<String>();
        Stack<String> dataBukupengarang = new Stack<String>();
        Stack<String> dataBukupenerbit = new Stack<String>();
        Stack<Integer> dataBukukategori = new Stack<Integer>();
        Stack<Integer> dataBukutahun = new Stack<Integer>();
        Scanner inputan = new Scanner(System.in);
        int menu;
        int HitungBukuLawas = 0;
        int HitungBukuBaru = 0;
        do {
            showMenu();
            System.out.print("Masukkan menu: ");
            menu = inputan.nextInt();

            if (menu == 1) {
                System.out.print("Masukkan judul: ");
                String Judul = inputan.next();

                System.out.print("Masukkan pengarang: ");
                String pengarang = inputan.next();

                System.out.print("Masukkan penerbit: ");
                String penerbit = inputan.next();

                Kategori();
                System.out.print("Masukkan kategori: ");
                int kategori = inputan.nextInt();
                HitungKategori(kategori);

                System.out.print("Masukkan tahun: ");
                int tahun = inputan.nextInt();

                dataBuku.push(Judul);
                dataBukupengarang.push(pengarang);
                dataBukupenerbit.push(penerbit);

                dataBukukategori.push(kategori);
                dataBukutahun.push(tahun);

                if (tahun <= 2000) {
                    HitungBukuLawas++;
                } else {
                    HitungBukuBaru++;
                }
            } else if (menu == 2) {
                int No = 0;
                int BukuKe = 0;
                System.out.println("====================================================================");
                System.out.println("No\t\tJudul\t\tPengarang\t\tPenerbit\t\tTahun\t\tKategori");
                System.out.println("====================================================================");
                for (int indeks : dataBukukategori) {
                    String index = KategoriBuku(indeks);
                    System.out.println(++No + "\t\t" + dataBuku.get(BukuKe) + "\t\t" + dataBukupengarang.get(BukuKe)
                            + "\t\t" + dataBukupenerbit.get(BukuKe) + "\t\t" + dataBukutahun.get(BukuKe) + "\t\t"
                            + index);
                    BukuKe++;
                }
                System.out.println("====================================================================");
                System.out.println("Jumlah buku: " + No);
                System.out.println("Buku Teknik: " + HitungBukuTeknik);
                System.out.println("Buku Manajemen: " + HitungBukuManajemen);
                System.out.println("Buku Fiksi: " + HitungBukuFiksi);
                System.out.println("Buku Lainnya: " + HitungBukuLainnya);
                System.out.println("Buku baru: " + HitungBukuBaru);
                System.out.println("Buku lawas: " + HitungBukuLawas);
            }
        } while (menu != 3);

        inputan.close();

    }

    public static void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Tambah Data Buku");
        System.out.println("2. Tampilkan Data Buku");
        System.out.println("3. Exit");
    }

    public static void Kategori() {
        System.out.println("=== Pilih Kategori ===");
        System.out.println("1. Teknik");
        System.out.println("2. Manajemen");
        System.out.println("3. Fiksi");
        System.out.println("4. Lainnya");
    }

    public static String KategoriBuku(int Kategori) {
        String index;
        if (Kategori == 1) {
            index = "Teknik";
        } else if (Kategori == 2) {
            index = "Manajemen";
        } else if (Kategori == 3) {
            index = "Fiksi";
        } else {
            index = "Lainnya";
        }
        return index;
    }

    public static void HitungKategori(int kategori) {
        if (kategori == 1) {
            HitungBukuTeknik++;
        } else if (kategori == 2) {
            HitungBukuManajemen++;
        } else if (kategori == 3) {
            HitungBukuFiksi++;
        } else {
            HitungBukuLainnya++;
        }
    }
}