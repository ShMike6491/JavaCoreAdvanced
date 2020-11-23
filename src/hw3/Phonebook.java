package hw3;

import java.util.*;

public class Phonebook {
    private Map<String, List<String>> map = new HashMap<>();

    public void getAll () {
        System.out.println(map.keySet());
    }

    public void get (String name) {
        System.out.println(map.get(name));
    }

    public void add (String name, String phoneNum) {
        List<String> list;
        if(map.containsKey(name)) {
            list = map.get(name);
            list.add(phoneNum);
        } else {
            list = Arrays.asList(phoneNum);
        }
        map.put(name, list);
    }

    public void add (String name, String[] numArray) {
        List<String> list;
        if(map.containsKey(name)) {
            list = map.get(name);
            for(String number : numArray) {
                list.add(number);
            }
        } else {
            list = Arrays.asList(numArray);
        }
        map.put(name, list);
    }
}
