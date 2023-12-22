package project;

import java.util.Scanner;

// Класс для выбора склада
class WarehouseSelector {
    static Scanner scanner = new Scanner(System.in);

    static Warehouse selectWarehouse() {
        System.out.println("Введите ID склада:");
        String warehouseId = scanner.nextLine();
        for (Warehouse warehouse : Warehouse.warehouses) {
            if (warehouse.id.equals(warehouseId)) {
                return warehouse;
            }
        }
        System.out.println("Склад не найден.");
        return null;
    }
}