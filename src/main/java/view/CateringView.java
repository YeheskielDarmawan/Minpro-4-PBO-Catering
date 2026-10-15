package view;

import controller.CateringController;
import model.MenuMakanan;
import model.MenuMinuman;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CateringView {
    private CateringController controller = new CateringController();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN CATERING (MVC) ===");
            System.out.println("1. Lihat Semua Menu");
            System.out.println("2. Tambah Makanan");
            System.out.println("3. Tambah Minuman");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Update Menu");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = ambilInputAngka();

            switch (pilihan) {
                case 1:
                    controller.tampilkanSemuaMenu();
                    break;
                case 2:
                    tambahMakanan();
                    break;
                case 3:
                    tambahMinuman();
                    break;
                case 4:
                    hapusMenu();
                    break;
                case 5:
                    updateMenu();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-6.");
            }
        }
    }

    private int ambilInputAngka() {
        while (true) {
            try {
                int angka = scanner.nextInt();
                scanner.nextLine();
                return angka;
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka! Masukkan ulang: ");
                scanner.nextLine();
            }
        }
    }

    private double ambilInputDouble() {
        while (true) {
            try {
                double angka = scanner.nextDouble();
                scanner.nextLine();
                return angka;
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka/desimal! Masukkan ulang: ");
                scanner.nextLine();
            }
        }
    }

    private void tambahMakanan() {
        System.out.print("ID: ");
        int id = ambilInputAngka();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = ambilInputDouble();
        System.out.print("Tingkat Pedas: ");
        String pedas = scanner.nextLine();

        controller.tambahData(new MenuMakanan(id, nama, harga, pedas));
        System.out.println("Makanan berhasil ditambahkan!");
    }

    private void tambahMinuman() {
        System.out.print("ID: ");
        int id = ambilInputAngka();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = ambilInputDouble();
        System.out.print("Ukuran: ");
        String ukuran = scanner.nextLine();

        controller.tambahData(new MenuMinuman(id, nama, harga, ukuran));
        System.out.println("Minuman berhasil ditambahkan!");
    }

    private void hapusMenu() {
        System.out.print("Masukkan ID yang dihapus: ");
        int id = ambilInputAngka();
        controller.hapusData(id);
    }

    private void updateMenu() {
        System.out.print("Masukkan ID yang diupdate: ");
        int id = ambilInputAngka();
        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();
        System.out.print("Harga Baru: ");
        double harga = ambilInputDouble();

        controller.updateData(id, nama, harga);
    }
}