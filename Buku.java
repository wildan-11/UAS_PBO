/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenpenjualanbuku;

/**
 *
 * @author OJIL-11
 */
// Kelas Parent Buku
class Buku {
    String judul;
    int hargaBeli;
    int hargaJual;
    int jumlahStok;

    public Buku(String judul, int hargaBeli, int hargaJual, int jumlahStok) {
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.jumlahStok = jumlahStok;
    }

    public void tambahStok(int jumlah) {
        jumlahStok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        jumlahStok -= jumlah;
        if (jumlahStok == 0) {
            System.out.println("Stok " + judul + " telah mencapai 0.");
        }
    }
}