package dao;

import config.DatabaseConfig;
import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<MenuCatering> getAll() {
        List<MenuCatering> list = new ArrayList<>();
        String sql = "SELECT * FROM menu";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                double harga = rs.getDouble("harga");
                String kat = rs.getString("kategori");
                String detail = rs.getString("detail_khusus");

                if (kat.equalsIgnoreCase("Makanan")) {
                    list.add(new MenuMakanan(id, nama, harga, detail));
                } else {
                    list.add(new MenuMinuman(id, nama, harga, detail));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Read Database: " + e.getMessage());
        }
        return list;
    }

    public void insert(MenuCatering menu) {
        String sql = "INSERT INTO menu (nama, harga, kategori, detail_khusus) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, menu.getNama());
            ps.setDouble(2, menu.getHarga());
            if (menu instanceof MenuMakanan) {
                ps.setString(3, "Makanan");
                ps.setString(4, ((MenuMakanan) menu).getTingkatPedas());
            } else if (menu instanceof MenuMinuman) {
                ps.setString(3, "Minuman");
                ps.setString(4, ((MenuMinuman) menu).getUkuran());
            }
            ps.executeUpdate();
            System.out.println("Data berhasil disimpan ke Database!");
        } catch (SQLException e) {
            System.out.println("Error Insert Database: " + e.getMessage());
        }
    }

    public void update(int id, String namaBaru, double hargaBaru) {
        String sql = "UPDATE menu SET nama = ?, harga = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, namaBaru);
            ps.setDouble(2, hargaBaru);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Data berhasil diperbarui di Database!");
            else System.out.println("ID tidak ditemukan di Database!");
        } catch (SQLException e) {
            System.out.println("Error Update Database: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM menu WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Data berhasil dihapus dari Database!");
            else System.out.println("ID tidak ditemukan di Database!");
        } catch (SQLException e) {
            System.out.println("Error Delete Database: " + e.getMessage());
        }
    }
}