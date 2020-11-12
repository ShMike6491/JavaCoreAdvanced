package hw3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String[] testArray = {"test", "my", "test", "test", "code", "my", "test", "!", "code"};
//
//        Map<String, Integer> map = new HashMap<>();
//        for(String word : testArray) {
//            Integer value = map.getOrDefault(word, 0);
//            map.put(word, value+1);
//        }
//
//        System.out.println(map.keySet());
//        System.out.println(map);

        Phonebook myBook = new Phonebook();

        myBook.add("Edison", "+7231 321 42-64");
        myBook.get("Edison");
        String[] nums = {"+7312 452 32-54", "+7329 321 44-33"};
        myBook.add("Tesla", nums);
        myBook.get("Tesla");

        myBook.getAll();
    }
}
