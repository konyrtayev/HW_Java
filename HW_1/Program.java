package HW_1;

import java.util.Scanner;


public class Program {
  public static void main(String[] args) {
    boolean isActive = true;

    while (isActive) {
      System.out.print("Введите номер задачи, которую хотите проверить(от 1 до 4)\nДля выхода напишите 0: ");
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      sc.nextLine();

      switch (num) {
        case 1:
          System.out.println();
          Function.Task1();
          break;
          
          case 2:
          System.out.println();
          Function.Task2();
          break;
          
          case 3:
          System.out.println();
          Function.Task3();
          break;
          
          case 4:
          System.out.println();
          Function.Task4();
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