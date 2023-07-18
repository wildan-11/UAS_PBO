/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenpenjualanbuku;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OJIL-11
 */
// Kelas ManajemenPenjualanBuku
public class ManajemenPenjualanBuku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int modalAwal = 1000000; // Modal Awal
        int modalBerjalan = modalAwal;

        // Inisialisasi daftar buku
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        daftarBuku.add(new BukuFiksi("Buku Fiksi 1", 20000, 30000, 10));
        daftarBuku.add(new BukuFiksi("Buku Fiksi 2", 25000, 35000, 15));
        daftarBuku.add(new BukuNonFiksi("Buku Non Fiksi 1", 22000, 32000, 8));
        daftarBuku.add(new BukuNonFiksi("Buku Non Fiksi 2", 18000, 28000, 12));
        daftarBuku.add(new Majalah("Majalah 1", 1, 10000, 20000, 20));
        daftarBuku.add(new Majalah("Majalah 2", 2, 12000, 22000, 18));

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Manajemen Penjualan Buku ===");
            System.out.println("Modal Awal: " + modalAwal);
            System.out.println("Modal Berjalan: " + modalBerjalan);
            System.out.println("1. Lihat Laporan");
            System.out.println("2. Lihat Stok Buku");
            System.out.println("3. Penjualan Buku");
            System.out.println("4. Pembelian Stok Buku");
            System.out.println("0. Exit");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    System.out.println("\n=== Laporan ===");
                    System.out.println("Modal Awal: " + modalAwal);
                    System.out.println("Modal Berjalan: " + modalBerjalan);
                    break;
                case 2:
                    System.out.println("\n=== Stok Buku ===");
                    for (Buku buku : daftarBuku) {
                        if (buku instanceof Majalah) {
                            Majalah majalah = (Majalah) buku;
                            System.out.println("Judul: " + majalah.judul + ", Nomor Edisi: " + majalah.nomorEdisi + ", Stok: " + majalah.jumlahStok);
                        } else {
                            System.out.println("Judul: " + buku.judul + ", Stok: " + buku.jumlahStok);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang dijual: ");
                    String judulBukuDijual = scanner.next();
                    System.out.print("Masukkan jumlah buku yang dijual: ");
                    int jumlahBukuDijual = scanner.nextInt();
                    for (Buku buku : daftarBuku) {
                        if (buku.judul.equalsIgnoreCase(judulBukuDijual)) {
                            if (buku.jumlahStok >= jumlahBukuDijual) {
                                modalBerjalan += (buku.hargaJual * jumlahBukuDijual);
                                buku.kurangiStok(jumlahBukuDijual);
                                System.out.println("Penjualan berhasil.");
                            } else {
                                System.out.println("Stok tidak mencukupi untuk melakukan penjualan.");
                            }
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Masukkan judul buku yang dibeli: ");
                    String judulBukuDibeli = scanner.next();
                    System.out.print("Masukkan jumlah buku yang dibeli: ");
                    int jumlahBukuDibeli = scanner.nextInt();
                    for (Buku buku : daftarBuku) {
                        if (buku.judul.equalsIgnoreCase(judulBukuDibeli)) {
                            if (modalBerjalan >= (buku.hargaBeli * jumlahBukuDibeli)) {
                                modalBerjalan -= (buku.hargaBeli * jumlahBukuDibeli);
                                buku.tambahStok(jumlahBukuDibeli);
                                System.out.println("Pembelian berhasil.");
                            } else {
                                System.out.println("Modal berjalan tidak mencukupi untuk melakukan pembelian.");
                            }
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        System.out.println("Program Selesai");
        scanner.close();
    }
}