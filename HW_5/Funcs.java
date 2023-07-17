package HW_5;

import java.util.ArrayList;
import java.util.HashMap;

public class Funcs {
    public static HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
    public static int maxNum = 0;
    
    public static void addContact(String str, Integer n) {
        ArrayList<Integer> aList = new ArrayList<>();
        if (hm.containsKey(str) && hm.get(str).size() > 0) {
            aList = hm.get(str);
        }
        aList.add(n);
        hm.put(str, aList);

        if (maxNum < aList.size()) maxNum = aList.size();
    }

    public static void getContacts() {
        for (int i = maxNum; i > 0; i--) {
            for (String str : hm.keySet()) {
                if (i == hm.get(str).size()) {
                    System.out.println(str + ":" + hm.get(str).toString().replace('[', ' ').replace(']', ' '));
                }
            }
        }
    }
}
