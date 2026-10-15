package model;

public class MenuMakanan extends MenuCatering {
    private String tingkatPedas;

    public MenuMakanan(int id, String nama, double harga, String tingkatPedas) {
        super(id, nama, harga);
        this.tingkatPedas = tingkatPedas;
    }

    public String getTingkatPedas() { return tingkatPedas; }

    // Overriding Method (Polymorphism - Method Overriding)
    @Override
    public void tampilDetail() {
        System.out.println("[Makanan] ID: " + getId() + " | Nama: " + getNama() + 
                           " | Harga: Rp" + getHarga() + " | Pedas: " + tingkatPedas);
    }
}