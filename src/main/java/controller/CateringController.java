package controller;

import dao.MenuDAO;
import model.*;
import java.util.List;

public class CateringController {
    private final MenuDAO menuDAO = new MenuDAO();

    public void tampilkanSemuaMenu() {
        List<MenuCatering> list = menuDAO.getAll();
        if (list.isEmpty()) {
            System.out.println("Belum ada menu tersimpan di database.");
            return;
        }
        for (MenuCatering menu : list) {
            menu.tampilDetail();
        }
    }

    public void tambahData(MenuCatering menu) {
        menuDAO.insert(menu);
    }

    public void hapusData(int id) {
        menuDAO.delete(id);
    }

    public void updateData(int id, String namaBaru, double hargaBaru) {
        menuDAO.update(id, namaBaru, hargaBaru);
    }
}