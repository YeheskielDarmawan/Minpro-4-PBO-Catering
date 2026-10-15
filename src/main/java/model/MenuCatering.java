package model;

public abstract class MenuCatering {
    private int id;
    private String nama;
    private double harga;

    public MenuCatering(int id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    // Abstract Method (Abstraction)
    public abstract void tampilDetail();

    // Overloading Method (Polymorphism - Method Overloading)
    public void updateHarga(double hargaBaru) {
        this.harga = hargaBaru;
    }
    public void updateHarga(double hargaBaru, double diskon) {
        this.harga = hargaBaru - (hargaBaru * (diskon / 100));
    }
}