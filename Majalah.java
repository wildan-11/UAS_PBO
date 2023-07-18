/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenpenjualanbuku;
// Kelas Majalah
class Majalah extends Buku {
    int nomorEdisi;

    public Majalah(String judul, int nomorEdisi, int hargaBeli, int hargaJual, int jumlahStok) {
        super(judul, hargaBeli, hargaJual, jumlahStok);
        this.nomorEdisi = nomorEdisi;
    }
}
