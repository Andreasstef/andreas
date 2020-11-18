/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Mahasiswa {
    private String nim;
    private String nama;
    private int angkatan;
    private String kode_jurusan;

    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", angkatan=" + angkatan + ", kode_jurusan=" + kode_jurusan + '}';
    }

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, int angkatan, String kode_jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
        this.kode_jurusan = kode_jurusan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }
}
