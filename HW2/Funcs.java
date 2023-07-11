package HW2;

import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Funcs {
  public static Scanner sc = new Scanner(System.in);
  public static Logger logger = Logger.getLogger(Program.class.getName());

  static void Task1() {

    /*
     * 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть
     * WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены
     * ниже в виде json-строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * Параметры для фильтрации:
     * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */

    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * from students");

    System.out.print("Укажите путь к файлу: ");
    String filePath = sc.nextLine(); // "HW2/task1.txt"
    File file = new File(filePath);
    FileReader fr;

    char[] arr = new char[(int) file.length()];

    try {
      fr = new FileReader(file);
      System.out.println("Файл найден!");
      fr.read(arr);
    } catch (Exception e) {
      System.out.println("Файл не найден!");
    }

    String key = "";
    String value = "";
    boolean isKey = true;
    boolean isWhereThere = false;

    if (file.isFile()) {
      for (char c : arr) {
        if (isKey && c != ' ' && c != '"' && c != '{' && c != '}' && c != ':') {
        key += c;
        } else if (c == ':' || c == ',') {
        isKey = !isKey;

        if (!key.isEmpty() && !isWhereThere) {
        isWhereThere = !isWhereThere;
        sb.append(" WHERE");
        }

        if (!isKey) {
        sb.append(" " + key);
        } else if (!value.equals("null")) {
        sb.append("='" + value + "'");
        } else {
        sb.append(" is null");
        }

        if (key.isEmpty()) {
        sb.append(" AND");
        }

        key = "";
        value = "";
        } else if (c != ' ' && c != '"' && c != '{' && c != '}' && c != ':') {
        value += c;
        }
      }

      if (!value.equals("null")) {
      sb.append("='" + value + "'");
      } else {
      sb.append(" is null");
      }

      System.out.println(sb + "\n");
    }
  }

  static void Task2() {
    /*
     * 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат
     * после каждой итерации запишите в лог-файл.
     */

    int n = 10;
    int[] arr = new int[n];

    System.out.print("Укажите путь к файлу: ");
    String filePath = sc.nextLine(); // "HW2/task2.txt"
    FileHandler fh;
    SimpleFormatter sf = new SimpleFormatter();

    try {
      fh = new FileHandler(filePath);
      System.out.println("Файл найден!");
      logger.addHandler(fh);
      fh.setFormatter(sf);
    } catch (Exception e) {
      System.out.println("Файл не найден!");
    }

    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(10);
      if (i == 0) {
        sb.append("[" + arr[i] + ", ");
      } else if (i == arr.length - 1) {
        sb.append(arr[i] + "]");
      } else {
        sb.append(arr[i] + ", ");
      }
    }
    logger.info("Создан массив: " + sb.toString());

    for (int j = 0; j < arr.length - 1; j++) {
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          logger.info("Элемент " + arr[i + 1] + " был перемещён на место элемента " + arr[i]);
        }
      }
    }

    sb.delete(0, sb.length());
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        sb.append("[" + arr[i] + ", ");
      } else if (i == arr.length - 1) {
        sb.append(arr[i] + "]");
      } else {
        sb.append(arr[i] + ", ");
      }
    }
    logger.info("Массив отсортирован: " + sb + "\n");
  }

  static void Task3() {
    /*
     * 3) Дана json-строка (можно сохранить в файл и читать из файла)
     * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":
     * "Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка"
     * :"5","предмет":"Физика"}]
     * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
     * строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
     * Пример вывода:
     * Студент Иванов получил 5 по предмету Математика.
     * Студент Петрова получил 4 по предмету Информатика.
     * Студент Краснов получил 5 по предмету Физика.
     */

    StringBuilder sb = new StringBuilder();
    System.out.print("Укажите путь к файлу: ");
    String filePath = sc.nextLine(); // "HW2/task3.txt"
    File file = new File(filePath);
    FileReader fr;

    char[] arr = new char[(int) file.length()];

    try {
      fr = new FileReader(file);
      System.out.println("Файл найден!");
      fr.read(arr);
    } catch (Exception e) {
      System.out.println("Файл не найден!");
    }

    String key = "";
    String value = "";
    boolean isKey = true;

    if (file.isFile()) {
      for (char c : arr) {
        if (c == ',' || c == ']') {
          isKey = true;
          switch (key) {
            case "фамилия":
              sb.append("Студент " + value);
              break;
            case "оценка":
              sb.append(" получил " + value);
              break;
            case "предмет":
              sb.append(" по предмету " + value + ".\n");
              break;
          }
          key = "";
          value = "";
        } else if (c == ':') {
          isKey = false;

        } else if (isKey && c != '[' && c != '{' && c != '}' && c != '"') {
          key += c;
        } else if (c != '[' && c != '{' && c != '}' && c != '"') {
          value += c;
        }
      }
      System.out.println(sb);
    }
  }

  static void Task4() {
    // 4) К калькулятору из предыдущего ДЗ добавить логирование.
    String filePath = "HW2/task4.txt";
    FileHandler fh;
    SimpleFormatter sf = new SimpleFormatter();

    try {
      fh = new FileHandler(filePath);
      System.out.println("Файл найден!");
      logger.addHandler(fh);
      fh.setFormatter(sf);
    } catch (Exception e) {
      System.out.println("Файл не найден!");
    }

    System.out.print("Введите первое число: ");
    int num1 = sc.nextInt();
    sc.nextLine();
    System.out.print("Введите символ: ");
    String symb = sc.next();
    sc.nextLine();
    System.out.print("Введите второе число: ");
    int num2 = sc.nextInt();
    sc.nextLine();

    switch (symb) {
      case "+":
        // System.out.printf("%d + %d = %d\n\n", num1, num2, num1 + num2);
        logger.info("Операция: " + num1 + symb + num2 + "=" + (num1 + num2));
        break;

      case "-":
        // System.out.printf("%d - %d = %d\n\n", num1, num2, num1 - num2);
        logger.info("Операция: " + num1 + symb + num2 + "=" + (num1 - num2));
        break;

      case "*":
        // System.out.printf("%d * %d = %d\n\n", num1, num2, num1 * num2);
        logger.info("Операция: " + num1 + symb + num2 + "=" + (num1 * num2));
        break;

      case "/":
        // System.out.printf("%d / %d = %d\n\n", num1, num2, num1 / num2);
        logger.info("Операция: " + num1 + symb + num2 + "=" + (num1 / num2));
        break;

      default:
        // System.out.println("Калькулятор не умеет работать с таким символом(\n\n");
        logger.info("Калькулятор не умеет работать с таким символом(\n\n");
        break;
    }
    System.out.println();
  }
  
  static int getInt() {
    int num = sc.nextInt();
    sc.nextLine();
    return num;
  }
}
