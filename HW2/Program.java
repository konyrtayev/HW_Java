package HW2;

public class Program {
  public static void main(String[] args) {
    boolean isActive = true;

    while (isActive) {
      System.out.print("Введите номер задачи, которую хотите проверить(от 1 до 4)\nДля выхода напишите 0: ");
      int num = Funcs.getInt();

      switch (num) {
        case 1:
          System.out.println();
          Funcs.Task1();
          break;

        case 2:
          System.out.println();
          Funcs.Task2();
          break;

        case 3:
          System.out.println();
          Funcs.Task3();
          break;

        case 4:
          System.out.println();
          Funcs.Task4();
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
