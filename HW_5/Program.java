package HW_5;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        boolean isActive = true;

        while (isActive) {
            System.out.println();
            System.out.print(
                    "Введите 1 для добавления контакта\nВведите 2 для просмотра списка контактов\nДля выхода введите 0: ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    System.out.println();
                    System.out.print("Введите имя контакта: ");
                    String name = sc.nextLine();
                    System.out.print("Введите номер контакта: ");
                    Integer number = sc.nextInt();
                    sc.nextLine();
                    Funcs.addContact(name, number);
                    break;

                case 2:
                    System.out.println();
                    Funcs.getContacts();
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
