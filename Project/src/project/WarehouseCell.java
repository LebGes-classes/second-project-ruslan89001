package project;

// Класс "Ячейка склада"
class WarehouseCell {
    String id;
    Product product;
    int quantity;

    WarehouseCell(String id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
}