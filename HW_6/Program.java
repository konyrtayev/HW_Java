package HW_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Laptop lt0 = new Laptop(0, "Apple", "MacBook Air 13", "Apple M2", "Apple graphics 10-core", 16, 512);
        Laptop lt1 = new Laptop(1, "Apple", "MacBook Air 13", "Apple M1", "Apple graphics 7-core", 8, 256);
        Laptop lt2 = new Laptop(2, "ASUS", "ROG Strix G15", "AMD Ryzen 9", "GeForce RTX 3070 Ti", 32, 1000);
        Laptop lt3 = new Laptop(3, "Acer", "Swift 3", "Intel Core i7 1165G7", "Intel Iris Xe Graphics", 16, 512);
        Laptop lt4 = new Laptop(4, "Apple", "MacBook Pro 16", "Apple M2 Max", "Apple graphics 32-core", 64, 2000);
        Laptop lt5 = new Laptop(5, "Lenovo", "IdeaPad 5", "AMD Ryzen 7 5700U", "AMD Radeon Graphics", 16, 256);
        Laptop lt6 = new Laptop(6, "ASUS", "VivoBook PRO 15", "AMD Ryzen 5", "GeForce RTX 3050", 16, 512);
        Laptop lt7 = new Laptop(7, "Lenovo", "Yoga 9i(Gen8)", "Intel Core i7 1360P", "Intel Iris Xe", 16, 512);
        Laptop lt8 = new Laptop(8, "Samsung", "Galaxy Book3 Ultra", "Intel Core i9", "GeForce RTX 4070", 32, 1000);

        Map<Integer, Laptop> laptopMap = new HashMap<>();
        laptopMap.put(lt0.getId(), lt0);
        laptopMap.put(lt1.getId(), lt1);
        laptopMap.put(lt2.getId(), lt2);
        laptopMap.put(lt3.getId(), lt3);
        laptopMap.put(lt4.getId(), lt4);
        laptopMap.put(lt5.getId(), lt5);
        laptopMap.put(lt6.getId(), lt6);
        laptopMap.put(lt7.getId(), lt7);
        laptopMap.put(lt8.getId(), lt8);

        boolean isActive = true;

        while (isActive) {
            System.out.print("Для вывода данных всех ноутбуков введите 1\nДля поиска с фильтром введите 2\nДля выхода введите 0: ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    System.out.println();
                    Server.showAll(laptopMap);
                    break;

                case 2:
                    System.out.println();
                    Server.filter(laptopMap);
                    break;

                case 0:
                    System.out.println();
                    isActive = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Задача не распознана, повторите!");
                    break;
            }
        }
    }
}
