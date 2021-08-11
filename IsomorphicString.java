import java.util.HashMap;

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("PEE", "egk"));
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("paper", "paper"));
    }
    
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> mapFrom = new HashMap<>();
        HashMap<Character, Character> mapTo = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);
            
            // Doesn't contain the mapping we will map it in both map
            if(!mapFrom.containsKey(from) && !mapTo.containsKey(to)) {
                mapFrom.put(from, to);
                mapTo.put(to, from);
            }
            else if(mapFrom.containsKey(from) && mapTo.containsKey(to)) {
                // Have to make sure the mapping is the reverse
                if(mapFrom.get(from) != to || mapTo.get(to) != from) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        // Now we will reconstruct t from using mapFrom
        String reconstructedT = "";
        for(char c : s.toCharArray()) {
            reconstructedT += mapFrom.get(c);
        }
        
        if(reconstructedT.equals(t)) {
            return true;
        }
        else {
            return false;
        }
    }
}
