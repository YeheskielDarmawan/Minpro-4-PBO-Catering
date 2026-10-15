package model;

public interface OperasiData {
    void tambahData(MenuCatering menu);
    void hapusData(int id);
    void updateData(int id, String namaBaru, double hargaBaru);
}