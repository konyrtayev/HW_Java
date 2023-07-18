package HW_6;

import java.util.Map;
import java.util.Scanner;

public class Server {
    static Scanner sc = new Scanner(System.in);

    // #region show
    public static void showAll(Map<Integer, Laptop> laptopMap) {
        for (Laptop lt : laptopMap.values()) {
            System.out.println((lt.getId() + 1) + " " + lt);
        }
        System.out.println();
    }

    public static void showCompany(Map<Integer, Laptop> laptopMap, String company) {
        int count = 0;
        for (Laptop lt : laptopMap.values()) {
            if (lt.getCompany().equals(company)) {
                System.out.println(lt);
                count++;
            }
        }
        if (count == 0)
            System.out.println("Нет подходящих ноутбуков!");
        System.out.println();
    }

    public static void showCPU(Map<Integer, Laptop> laptopMap, String cpu) {
        int count = 0;
        for (Laptop lt : laptopMap.values()) {
            if (lt.getCpu().contains(cpu)) {
                System.out.println(lt);
                count++;
            }
        }
        if (count == 0)
            System.out.println("Нет подходящих ноутбуков!");
        System.out.println();
    }

    public static void showGPU(Map<Integer, Laptop> laptopMap, String card) {
        int count = 0;
        for (Laptop lt : laptopMap.values()) {
            if (lt.getCard().contains(card)) {
                System.out.println(lt);
                count++;
            }
        }
        if (count == 0)
            System.out.println("Нет подходящих ноутбуков!");
        System.out.println();
    }

    public static void showRAM(Map<Integer, Laptop> laptopMap, int ram) {
        int count = 0;
        for (Laptop lt : laptopMap.values()) {
            if (lt.getRam() == ram) {
                System.out.println(lt);
                count++;
            }
        }
        if (count == 0)
            System.out.println("Нет подходящих ноутбуков!");
        System.out.println();
    }

    public static void showHDD(Map<Integer, Laptop> laptopMap, int hdd) {
        int count = 0;
        for (Laptop lt : laptopMap.values()) {
            if (lt.getHdd() == hdd) {
                System.out.println(lt);
                count++;
            }
        }
        if (count == 0)
            System.out.println("Нет подходящих ноутбуков!");
        System.out.println();
    }
    //#endregion

    //#region filter
    public static void filterCompany(Map<Integer, Laptop> laptopMap) {
        System.out.print("1 - ASUS\n2 - Apple\n3 - Acer\n4 - Lenovo\n5 - Samsung\nВыберите компанию: ");
        int num = sc.nextInt();
        String company = "";
        switch (num) {
            case 1:
                company = "ASUS";
                break;
            case 2:
                company = "Apple";
                break;
            case 3:
                company = "Acer";
                break;
            case 4:
                company = "Lenovo";
                break;
            case 5:
                company = "Samsung";
                break;
            default:
                break;
        }

        showCompany(laptopMap, company);
    }

    public static void filterCPU(Map<Integer, Laptop> laptopMap) {
        System.out.print("1 - AMD\n2 - Apple\n3 - Intel\nВыберите производителя процессора: ");
        int num = sc.nextInt();
        String cpu = "";
        switch (num) {
            case 1:
                cpu = "AMD";
                break;
            case 2:
                cpu = "Apple";
                break;
            case 3:
                cpu = "Intel";
                break;
            default:
                break;
        }
        showCPU(laptopMap, cpu);
    }

    public static void filterCard(Map<Integer, Laptop> laptopMap) {
        System.out.print("1 - AMD\n2 - Apple\n3 - Intel\n4 - GeForce\nВыберите производителя видеокарты: ");
        int num = sc.nextInt();
        String card = "";
        switch (num) {
            case 1:
                card = "AMD";
                break;
            case 2:
                card = "Apple";
                break;
            case 3:
                card = "Intel";
                break;
            case 4:
                card = "GeForce";
                break;
            default:
                break;
        }
        showGPU(laptopMap, card);
    }

    public static void filterRAM(Map<Integer, Laptop> laptopMap) {
        System.out.print("Объём оперативной памяти: ");
        int ram = sc.nextInt();
        showRAM(laptopMap, ram);
    }

    public static void filterHDD(Map<Integer, Laptop> laptopMap) {
        System.out.print("Объём памяти жёсткого диска: ");
        int hdd = sc.nextInt();
        showHDD(laptopMap, hdd);
    }

    public static void filter(Map<Integer, Laptop> laptopMap) {
        System.out.println(
                "Введите цифру, соответствующую необходимому критерию:\n1 - Производитель\n2 - Процессор\n3 - Видеокарта\n4 - ОЗУ\n5 - ПЗУ");
        int num = sc.nextInt();
        sc.nextLine();

        switch (num) {
            case 1:
                System.out.println();
                filterCompany(laptopMap);
                break;

            case 2:
                System.out.println();
                filterCPU(laptopMap);
                break;

            case 3:
                System.out.println();
                filterCard(laptopMap);
                break;
            
            case 4:
                System.out.println();
                filterRAM(laptopMap);
                break;
            
            case 5:
                System.out.println();
                filterHDD(laptopMap);
                break;

            default:
                System.out.println();
                System.out.println("Задача не распознана, повторите!");
                break;
        }

    }
}
