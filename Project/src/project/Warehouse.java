package project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Класс "Склад"
class Warehouse {
    String id;
    String address;
    Employee manager;
    List<WarehouseCell> cells;
    List<Employee> employees; // список сотрудников на складе
    static ArrayList<Warehouse> warehouses = new ArrayList<>(); // список всех складов

    Warehouse(String id, String address, Employee manager) {
        this.id = id;
        this.address = address;
        this.manager = manager;
        this.cells = new ArrayList<>();
        this.employees = new ArrayList<>();
        warehouses.add(this); // добавляем новый склад в список при создании
    }
    // Метод для перемещения товаров
    void moveProduct(Product product, int quantity, Warehouse destination) {
        // Найти ячейку с данным товаром
        for (WarehouseCell cell : cells) {
            if (cell.product.equals(product)) {
                // Уменьшить количество товара на складе
                cell.quantity -= quantity;

                // Добавить товар на склад-приемник
                destination.addProduct(product, quantity);
                return;
            }
        }
    }

    // Метод для добавления товара на склад
    void addProduct(Product product, int quantity) {
        // Найти ячейку с данным товаром или создать новую
        for (WarehouseCell cell : cells) {
            if (cell.product.equals(product)) {
                cell.quantity += quantity;
                return;
            }
        }
        cells.add(new WarehouseCell(UUID.randomUUID().toString(), product, quantity));
    }

    // Метод для смены ответственного лица
    void changeManager(Employee newManager) {
        this.manager = newManager;
    }
    // Метод для найма сотрудника
    void hireEmployee(Employee employee) {
        this.employees.add(employee);
    }

    // Метод для увольнения сотрудника
    void fireEmployee(Employee employee) {
        this.employees.remove(employee);
    }
    // Метод для получения информации о складе
    void getWarehouseInfo() {
        System.out.println("ID: " + id);
        System.out.println("Address: " + address);
        System.out.println("Manager: " + manager.name);
    }
    // Метод для перемещения товара на другой склад
    void transferProduct(Product product, int quantity, Warehouse destination) {
        // Найти ячейку с данным товаром
        for (WarehouseCell cell : cells) {
            if (cell.product.equals(product)) {
                // Уменьшить количество товара на текущем складе
                cell.quantity -= quantity;

                // Увеличить количество товара на складе-приемнике
                destination.addProduct(product, quantity);
                return;
            }
        }
    }
    // Метод для закрытия (удаления) склада
    void close() {
        warehouses.remove(this); // удаляем текущий склад из списка
    }
    // Метод для получения информации о товарах на складе
    void getProductsInfo() {
        for (WarehouseCell cell : cells) {
            System.out.println("Product ID: " + cell.product.id);
            System.out.println("Product Name: " + cell.product.name);
            System.out.println("Quantity: " + cell.quantity);
        }
    }
}