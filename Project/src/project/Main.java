package project;

import java.util.Scanner;
import java.util.UUID;

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Warehouse warehouse1 = new Warehouse("1", "Адрес склада", new Employee("1", "Менеджер склада"));
        Warehouse warehouse2 = new Warehouse("2", "Адрес склада 2", new Employee("2", "Менеджер склада 2"));
        SalesPoint salesPoint = SalesPoint.openNewSalesPoint("1", "Адрес пункта продаж", new Employee("2", "Менеджер пункта продаж"));
        Product product1 = new Product("1", "Товар 1", 100.0);
        warehouse1.addProduct(product1, 10);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Перемещение товаров");
            System.out.println("2. Смена ответственного лица");
            System.out.println("3. Продажа товара");
            System.out.println("4. Возврат товара");
            System.out.println("5. Закупка товара");
            System.out.println("6. Найм сотрудника");
            System.out.println("7. Увольнение сотрудника");
            System.out.println("8. Открытие нового склада");
            System.out.println("9. Закрытие склада");
            System.out.println("10. Открытие пункта продаж");
            System.out.println("11. Закрытие пункта продаж");
            System.out.println("12. Информация о складе");
            System.out.println("13. Информация о пункте продаж");
            System.out.println("14. Информация о товарах на складе");
            System.out.println("15. Информация о товарах на складе/пункте продаж");
            System.out.println("16. Информация о доходности пункта продаж");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Введите ID товара для перемещения:");
                    String productId = scanner.nextLine();
                    Product productToTransfer = null;
                    for (WarehouseCell cell : warehouse1.cells) {
                        if (cell.product.id.equals(productId)) {
                            productToTransfer = cell.product;
                            break;
                        }
                    }
                    if (productToTransfer == null) {
                        System.out.println("Товар не найден на складе 1.");
                        break;
                    }
                    System.out.println("Введите количество товара для перемещения:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    warehouse1.transferProduct(productToTransfer, quantity, warehouse2);
                    System.out.println("Товар успешно перемещен со склада 1 на склад 2.");
                    break;
                case "2":
                    System.out.println("Введите имя нового менеджера:");
                    String managerName = scanner.nextLine();
                    Employee newManager = new Employee(UUID.randomUUID().toString(), managerName);
                    warehouse1.changeManager(newManager);
                    System.out.println("Менеджер склада 1 успешно изменен.");
                    break;
                case "3":
                    System.out.println("Введите ID товара для продажи:");
                    String productIdToSell = scanner.nextLine();
                    Product productToSell = null;
                    for (Product product : salesPoint.products) {
                        if (product.id.equals(productIdToSell)) {
                            productToSell = product;
                            break;
                        }
                    }
                    if (productToSell == null) {
                        System.out.println("Товар не найден на пункте продаж.");
                        break;
                    }
                    System.out.println("Введите количество товара для продажи:");
                    int quantityToSell = Integer.parseInt(scanner.nextLine());
                    salesPoint.sellProduct(productToSell, quantityToSell);
                    System.out.println("Товар успешно продан.");
                    break;
                case "4":
                    System.out.println("Введите ID товара для возврата:");
                    String productIdToReturn = scanner.nextLine();
                    Product productToReturn = null;
                    for (Product product : salesPoint.products) {
                        if (product.id.equals(productIdToReturn)) {
                            productToReturn = product;
                            break;
                        }
                    }
                    if (productToReturn == null) {
                        System.out.println("Товар не найден на пункте продаж.");
                        break;
                    }
                    System.out.println("Введите количество товара для возврата:");
                    int quantityToReturn = Integer.parseInt(scanner.nextLine());
                    salesPoint.returnProduct(productToReturn, quantityToReturn);
                    System.out.println("Товар успешно возвращен.");
                    break;
                case "5":
                    System.out.println("Введите ID товара для закупки:");
                    String productIdToPurchase = scanner.nextLine();
                    Product productToPurchase = new Product(productIdToPurchase, "Новый товар", 100.0);
                    System.out.println("Введите количество товара для закупки:");
                    int quantityToPurchase = Integer.parseInt(scanner.nextLine());
                    salesPoint.purchaseProduct(productToPurchase, quantityToPurchase);
                    System.out.println("Товар успешно закуплен.");
                    break;
                case "6":
                    System.out.println("Введите имя нового сотрудника:");
                    String employeeName = scanner.nextLine();
                    Employee newEmployee = new Employee(UUID.randomUUID().toString(), employeeName);
                    warehouse1.hireEmployee(newEmployee);
                    System.out.println("Сотрудник успешно нанят на склад 1.");
                    break;
                case "7":
                    System.out.println("Введите ID сотрудника для увольнения:");
                    String employeeId = scanner.nextLine();
                    Employee employeeToFire = null;
                    for (Employee employee : warehouse1.employees) {
                        if (employee.id.equals(employeeId)) {
                            employeeToFire = employee;
                            break;
                        }
                    }
                    if (employeeToFire == null) {
                        System.out.println("Сотрудник не найден на складе 1.");
                        break;
                    }
                    warehouse1.fireEmployee(employeeToFire);
                    System.out.println("Сотрудник успешно уволен со склада 1.");
                    break;
                case "8":
                    System.out.println("Введите адрес нового склада:");
                    String newWarehouseAddress = scanner.nextLine();
                    System.out.println("Введите имя менеджера нового склада:");
                    String newWarehouseManagerName = scanner.nextLine();
                    Employee newWarehouseManager = new Employee(UUID.randomUUID().toString(), newWarehouseManagerName);
                    Warehouse newWarehouse = new Warehouse(UUID.randomUUID().toString(), newWarehouseAddress, newWarehouseManager);
                    System.out.println("Новый склад успешно открыт.");
                    break;
                case "9":
                    Warehouse selectedWarehouse = WarehouseSelector.selectWarehouse();
                    if (selectedWarehouse != null) {
                        selectedWarehouse.close();
                        System.out.println("Склад успешно закрыт.");
                    }
                    break;
                case "10":
                    System.out.println("Введите адрес нового пункта продаж:");
                    String newSalesPointAddress = scanner.nextLine();
                    System.out.println("Введите имя менеджера нового пункта продаж:");
                    String newSalesPointManagerName = scanner.nextLine();
                    Employee newSalesPointManager = new Employee(UUID.randomUUID().toString(), newSalesPointManagerName);
                    SalesPoint newSalesPoint = SalesPoint.openNewSalesPoint(UUID.randomUUID().toString(), newSalesPointAddress, newSalesPointManager);
                    System.out.println("Новый пункт продаж успешно открыт.");
                    break;
                case "11":
                    SalesPoint selectedSalesPoint = SalesPointSelector.selectSalesPoint();
                    if (selectedSalesPoint != null) {
                        selectedSalesPoint.close();
                    }
                    System.out.println("Пункт продаж успешно закрыт.");
                    break;
                case "12":
                    Warehouse selectedWarehouse2 = WarehouseSelector.selectWarehouse();
                    if (selectedWarehouse2 != null) {
                        selectedWarehouse2.getWarehouseInfo();
                    }
                    break;
                case "13":
                    SalesPoint selectedSalesPoint2 = SalesPointSelector.selectSalesPoint();
                    if (selectedSalesPoint2 != null) {
                        selectedSalesPoint2.getSalesPointInfo();
                    }
                    break;
                case "14":
                    Warehouse selectedWarehouse3 = WarehouseSelector.selectWarehouse();
                    if (selectedWarehouse3 != null) {
                        selectedWarehouse3.getProductsInfo();
                    }
                    break;
                case "15":
                    SalesPoint selectedSalesPoint3 = SalesPointSelector.selectSalesPoint();
                    if (selectedSalesPoint3 != null) {
                        selectedSalesPoint3.getProductsInfo();
                    }
                    break;
                case "16":
                    SalesPoint selectedSalesPoint4 = SalesPointSelector.selectSalesPoint();
                    if (selectedSalesPoint4 != null) {
                        selectedSalesPoint4.getProfitInfo();
                    }
                    break;
                case "17":
                    System.exit(0);
            }
        }
    }
}