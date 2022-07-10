package _49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        String strs2[] = {"a","a"};
        System.out.println(groupAnagrams(strs2));
        
        
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
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char arrS[] = s.toCharArray();
            Arrays.sort(arrS);
            
            String outS = String.valueOf(arrS);
            
            List<String> old = map.getOrDefault(outS, new ArrayList<String>());
            old.add(s);
            
            map.put(outS, old);
        }
        
        return new ArrayList(map.values());
    }
}
