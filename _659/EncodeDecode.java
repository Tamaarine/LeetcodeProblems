package _659;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        EncodeDecode inst = new EncodeDecode();
        
        System.out.println(inst.encodeWord("hello:world"));
        System.out.println(inst.encodeWord("hello::world"));
        System.out.println(inst.encodeWord("hello::world:"));
        System.out.println(inst.encodeWord(":hello::world:"));
        
        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("world");
        list1.add("hehe");
        list1.add("hi!\\");
        list1.add("hiworld:");
        
        System.out.println(inst.encode(list1));
        
        System.out.println(inst.decode("hello:world:hehe:hi!\\:hiworld:::"));
        
        List<String> list2 = new ArrayList<>();
        
        System.out.println(inst.encode(list2));
        System.out.println(inst.decode(inst.encode(list2)));
        
        List<String> list3 = new ArrayList<>();
        list3.add(":::::");
        
        System.out.println(inst.encode(list3));
        System.out.println(inst.decode(inst.encode(list3)));
        
        List<String> list4 = new ArrayList<>();
        list4.add(":\\");
        
        System.out.println(inst.encode(list4));
        System.out.println(inst.decode(inst.encode(list4)));
    }
    
    /**
     * This function will encode the code, turning any : into \:
     */
    public String encodeWord(String word) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<word.length();i++) {
            if(word.charAt(i) == ':') {
                sb.append(":"); // Appends a double : to make it literal 
            }
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
    
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
                
        for(String str : strs) {
            sb.append(encodeWord(str) + ":");    
        }
        
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == ':') {
                if (i < str.length() - 1 && str.charAt(i + 1) == ':') {
                    // It is a literal colon not the colon that is used for separating the elements
                    sb.append(":");
                    i++; // Skips the colon
                }
                else {
                    output.add(sb.toString()); 
                    sb.setLength(0); // Clears the buffer
                }
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        
        return output;
    }
}
