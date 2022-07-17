package _242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidAnagram {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 99);
        System.out.println(map.get(2));
        System.out.println(new Integer(1) != null);
        System.out.println("hehe");
        System.out.println(isAnagram2("rat", "car"));
        System.out.println(isAnagram2("", "naa"));
        System.out.println(isAnagram2("hehexd", "xdhehe"));
        System.out.println(isAnagram2("zxcvbnmmnbvcxz,./", "mnbvcxzzxcvbnm,./"));
    }
    
    public static boolean isAnagram(String s, String t) {
        char arrS[] = s.toCharArray();
        char arrT[] = t.toCharArray();
        
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        
        String outS = Stream.of(arrS).map(String::valueOf).collect(Collectors.joining());
        String outT = Stream.of(arrT).map(String::valueOf).collect(Collectors.joining());
        
        return outS.equals(outT) ? true : false;
    }
    
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        s.chars().forEach(e -> {
            char converted = (char)e;
            map1.put(converted, map1.getOrDefault(converted, 0) + 1);
        });
        
        t.chars().forEach(e -> {
            char converted = (char)e;
            map2.put(converted, map2.getOrDefault(converted, 0) + 1);
        });
        
        for(char l : s.toCharArray()) {
            if (map1.get(l) != map2.get(l)) {
                return false;
            }
        }        
        
        System.out.println(map1);
        
        return true;
    }
}
