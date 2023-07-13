package HW_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
    /*
     * Даны два Deque, цифры в обратном порядке.
     * [3,1,7] - пример Deque
     * [4,9,5]- пример второго Deque
     * 713 * 594 = 423 522
     * 713 + 594 = 1307
     */

    Deque<String> num1 = new ArrayDeque<>();
    num1.add("3");
    num1.add("1");
    num1.add("7");
    // num1.add("-");
    System.out.println("Deque1 = " + num1);

    Deque<String> num2 = new ArrayDeque<>();
    num2.add("4");
    num2.add("9");
    num2.add("5");
    System.out.println("Deque2 = " + num2);

    LinkedList<String> res1 = new LinkedList<>();
    fillLinkedList(res1, getInt(num1) * getInt(num2));
    System.out.println("Произведение двух чисел = " + res1);

    LinkedList<String> res2 = new LinkedList<>();
    fillLinkedList(res2, getInt(num1) + getInt(num2));
    System.out.println("Сумма двух чисел = " + res2);
  }

  public static int getInt(Deque<String> num) {
    Deque<String> temp = new ArrayDeque<>();
    for (String str : num) {
      temp.add(str);
    }

    String res = "";
    while (!temp.isEmpty()) {
      res += temp.pollLast();
    }
    return Integer.parseInt(res);
  }

  public static void fillLinkedList(LinkedList<String> ll, int number) {
    int num = number;
    if (num < 0) {
      num *= -1;
    }

    String temp = "";
    while (num != 0) {
      temp += num % 10;
      ll.addFirst(temp);
      num /= 10;
      temp = "";
    }

    if (number < 0) {
        ll.addFirst("-");
      }
  }
}
