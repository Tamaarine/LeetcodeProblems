// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.nio.charset.StandardCharsets;
// import java.util.HashMap;

// /**
//  * The Main class implements an application that reads lines from the standard
//  * input and prints them to the standard output.
//  */
// public class Main {
//   /**
//    * Iterate through each line of input.
//    */
//   public static void main(String[] args) throws IOException {
//     InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//     BufferedReader in = new BufferedReader(reader);
//     String line;
//     HashMap<Character, Integer> map = new HashMap<>();
//     while ((line = in.readLine()) != null) {
//       for(int i=0;i<line.length();i++) {
//         map.put(line.charAt(i), map.getOrDefault(line.charAt(i), 0) + 1);
//       }
      
//       String output = "";
//       String workingNumeral[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//       int mappedNumeral[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      
//       // Since each numeral are exclusively, can't reconstruct another numeral from one we check each one by one
//       // until we don't have any more letters left
//       boolean hasLetLeft = true;
//       int i = 0;
//       while(hasLetLeft) {
//         String s = workingNumeral[i];
//         boolean enoughLetter = true;
        
//         for(int i=0;i<s.length();i++) {
//             if(map.getOrDefault(s.charAt(i), 0) <= 0) {
//               enoughLetter = false; // if any letter is not enough then we will set the flag to false
//             }
//         }
        
//         // If the letter is still enough, we will subtract and concatenate to our output string
//         if(enoughLetter) {
//           for(int i=0;i<s.length();i++) {
//             map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
//             output += mappedNumeral[j];
//           }
//         }
        
//         i = (i + 1) % 10; 
//         // Check if we have any letter left again
//         hasLetLeft = hasLetterLeft(map);
//       }
      
//       System.out.println(output);
//     }
//   }
    
//     public static boolean hasLetterLeft(HashMap<Character, Integer> map) {
//       char i = 'a';
//       int count = 0;
//       while(i <= 'z') {
//         if(map.getOrDefault(i, 0) == 0) {
//           count++;
//         }
//       }
      
//       if(count == 26) {
//         return false;
//       }
//       else return true;
//     }
//   }
