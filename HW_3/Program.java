package HW_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
    // Пусть дан произвольный список целых чисел.

    ArrayList<Integer> list = new ArrayList<>(
        Arrays.asList(1234, 452135, 2142, 234545, 235435, 5674, 23, 12, 13, 245, 4355, 56, 647, 6574, 57));

    System.out.println("Произвольный список: " + list);

    // 1) Нужно удалить из него чётные числа
    System.out.println("Список без чётных чисел: " + getOdd(list));

    // 2) Найти минимальное значение
    System.out.println("Минимальное значение в списке: " + getMinValue(list));

    // 3) Найти максимальное значение
    System.out.println("Максимальное значение в списке: " + getMaxValue(list));
    
    // 4) Найти среднее ариф. значение
    System.out.println("Среднее арифметическое: " + getAverage(list));

  }

  public static ArrayList<Integer> getOdd(ArrayList<Integer> list) {
    ArrayList<Integer> res = new ArrayList<>();
    res = (ArrayList<Integer>) list.clone();

    Iterator iter = res.iterator();
    while (iter.hasNext()) {
      if ((Integer) iter.next() % 2 == 0)
        iter.remove();
    }
    return res;
  }

  public static int getMinValue(ArrayList<Integer> list) {
    ArrayList<Integer> res = new ArrayList<>();
    res = (ArrayList<Integer>) list.clone();
    res.sort(null);
    return res.get(0);

  }
  
  public static int getMaxValue(ArrayList<Integer> list) {
    ArrayList<Integer> res = new ArrayList<>();
    res = (ArrayList<Integer>) list.clone();
    res.sort(Comparator.reverseOrder());
    return res.get(0);
  }

  public static int getAverage(ArrayList<Integer> list) {
    int sum = 0;
    for (int i : list) {
      sum += i;
    }
    return sum / list.size();
  }
}
