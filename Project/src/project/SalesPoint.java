package project;

import java.util.ArrayList;
import java.util.List;

// Класс "Пункт продаж"
class SalesPoint {
    String id;
    String address;
    Employee manager;
    List<Product> products;
    static List<SalesPoint> allSalesPoints = new ArrayList<>(); // список всех пунктов продаж
    double profit; // доходность пункта продаж

    SalesPoint(String id, String address, Employee manager) {
        this.id = id;
        this.address = address;
        this.manager = manager;
        this.products = new ArrayList<>();
        allSalesPoints.add(this);
        this.profit = 0.0;
    }
    // Метод для закупки товара
    void purchaseProduct(Product product, int quantity) {
        // Добавляем закупленный товар на пункт продаж
        this.products.add(product);
        // Уменьшаем доходность пункта продаж
        this.profit -= product.price * quantity;
    }

    // Метод для продажи товара
    void sellProduct(Product product, int quantity) {
        // Найти товар и уменьшить его количество
        for (Product p : products) {
            if (p.equals(product)) {
                // Здесь должна быть логика уменьшения количества товара
                // При продаже товара увеличиваем доходность пункта продаж
                this.profit += product.price * quantity;
                return;
            }
        }
    }

    // Метод для возврата товара
    void returnProduct(Product product, int quantity) {
        // Найти товар и увеличить его количество
        for (Product p : products) {
            if (p.equals(product)) {
                // Здесь должна быть логика увеличения количества товара
                return;
            }
        }
    }
    // Статический метод для открытия нового пункта продаж
    static SalesPoint openNewSalesPoint(String id, String address, Employee manager) {
        SalesPoint newSalesPoint = new SalesPoint(id, address, manager);
        allSalesPoints.add(newSalesPoint);
        return newSalesPoint;
    }
    // Метод для закрытия пункта продаж
    void close() {
        allSalesPoints.remove(this); // при закрытии пункта продаж, удаляем его из списка всех пунктов продаж
    }

    // Метод для получения информации о всех пунктах продаж
    static void getSalesPointsInfo() {
        for (SalesPoint salesPoint : allSalesPoints) {
            // здесь можно выводить информацию о каждом пункте продаж
        }
    }
    // Метод для получения информации о пункте продаж
    void getSalesPointInfo() {
        System.out.println("ID: " + id);
        System.out.println("Address: " + address);
        System.out.println("Manager: " + manager.name);
    }

    // Метод для получения информации о товарах в пункте продаж
    void getProductsInfo() {
        for (Product product : products) {
            System.out.println("Product ID: " + product.id);
            System.out.println("Product Name: " + product.name);
        }
    }
    void getProfitInfo() {
        System.out.println("Profit: " + profit);
    }
    // Метод для смены ответственного лица
    void changeManager(Employee newManager) {
        this.manager = newManager;
    }
}