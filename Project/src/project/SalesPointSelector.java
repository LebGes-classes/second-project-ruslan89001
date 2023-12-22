package project;

import java.util.Scanner;

// Класс для выбора пункта продаж
class SalesPointSelector {
    static Scanner scanner = new Scanner(System.in);

    static SalesPoint selectSalesPoint() {
        System.out.println("Введите ID пункта продаж:");
        String salesPointId = scanner.nextLine();
        for (SalesPoint sp : SalesPoint.allSalesPoints) {
            if (sp.id.equals(salesPointId)) {
                return sp;
            }
        }
        System.out.println("Пункт продаж не найден.");
        return null;
    }
}
