package model;

public class MenuMinuman extends MenuCatering {
    private String ukuran;

    public MenuMinuman(int id, String nama, double harga, String ukuran) {
        super(id, nama, harga);
        this.ukuran = ukuran;
    }

    public String getUkuran() { return ukuran; }

    // Overriding Method (Polymorphism - Method Overriding)
    @Override
    public void tampilDetail() {
        System.out.println("[Minuman] ID: " + getId() + " | Nama: " + getNama() + 
                           " | Harga: Rp" + getHarga() + " | Ukuran: " + ukuran);
    }
}