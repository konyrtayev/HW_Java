package HW_1;

import java.util.Scanner;

public class Function {
  static void Task1() {
    System.out.println("1) Cумма чисел от 1 до n, произведение чисел от 1 до n.");
    Scanner sc = new Scanner(System.in);
    System.out.print("Введите число N: ");
    int n = sc.nextInt();
    sc.nextLine();
    // sc.close();

    int res1 = 0;
    int res2 = 1;
    if (n == 0)
      res2 = 0;

    while (n > 0) {
      res1 += n;
      res2 *= n--;
    }

    System.out.printf("Сумма чисел от 1 до N = %d\n", res1);
    System.out.printf("Произведение чисел от 1 до N = %d\n\n", res2);
  }

  static void Task2() {
    System.out.println("2) Вывести все простые числа от 1 до 1000.");
    int n = 1000;
    int count = 0;

    for (int i = 2; i < n; i++) {
      for (int j = 2; j < i; j++) {
        if (i % j == 0)
          count++;

      }
      if (count == 0)
        System.out.print(i + " ");

      count = 0;
    }
    System.out.println("\n");
  }

  static void Task3() {
    System.out.println("3) Реализовать простой калькулятор (+-/*).");
    Scanner sc = new Scanner(System.in);
    System.out.print("Введите первое число: ");
    int num1 = sc.nextInt();
    sc.nextLine();
    System.out.print("Введите символ: ");
    String symb = sc.next();
    sc.nextLine();
    System.out.print("Введите второе число: ");
    int num2 = sc.nextInt();
    sc.nextLine();
    // sc.close();

    switch (symb) {
      case "+":
        System.out.printf("%d + %d = %d\n\n", num1, num2, num1 + num2);
        break;

      case "-":
        System.out.printf("%d - %d = %d\n\n", num1, num2, num1 - num2);
        break;

      case "*":
        System.out.printf("%d * %d = %d\n\n", num1, num2, num1 * num2);
        break;

      case "/":
        System.out.printf("%d / %d = %d\n\n", num1, num2, num1 / num2);
        break;

      default:
        System.out.println("Калькулятор не умеет работать с таким символом(\n\n");
        break;
    }
  }

  static void Task4() {
    System.out.println("4) (дополнительное задание).");

    // 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства. Предложить хотя бы
    // одно решение или сообщить, что его нет.
    // Под знаком вопроса - одинаковые цифры

    Scanner sc = new Scanner(System.in);
    System.out.print("Введите уравнение: ");
    String s = sc.nextLine();

    String str = "";
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;

    for (int i = 0; i < 10; i++) {
      str = s.replace("?", Integer.toString(i));
      str = str.replace(" ", "");

      num1 = Integer.parseInt(str.substring(0, str.indexOf("+")));
      num2 = Integer.parseInt(str.substring(str.indexOf("+") + 1, str.indexOf("=")));
      num3 = Integer.parseInt(str.substring(str.indexOf("=") + 1, str.length()));

      if (num1 + num2 == num3) {
        System.out.printf("%d + %d = %d\n\n", num1, num2, num3);
      }
    }

    if (num1 + num2 == num3) {
      System.out.println("Решения нет!\n\n");
    }
  }
}