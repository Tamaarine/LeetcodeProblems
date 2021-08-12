package Amazon;
import java.util.*;

public class SecretFruitList {
    public static void main(String[] args) {
        List<List<String>> input1 = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("orange");
        row1.add("mango");
        
        List<String> row2 = new ArrayList<>();
        row2.add("watermelon");
        row2.add("mango");
        input1.add(row1);
        input1.add(row2);
        
        String arrcustomer1[] = {"orange", "mango", "strawberry", "watermelon", "mango"};
        List<String> customer1 = new ArrayList<>(Arrays.asList(arrcustomer1));
        
        System.out.println(matchSecretLists(input1, customer1));
        
        
        List<List<String>> input2 = new ArrayList<>();
        String row3[] = {"watermelon", "anything", "mango"};
        input2.add(Arrays.asList(row3));
        
        String arrcustomer2[] = {"watermelon", "orange", "mango"};
        
        System.out.println(matchSecretLists(input2, Arrays.asList(arrcustomer2)));
        
        
        List<List<String>> input3 = new ArrayList<>();
        String row4[] = {"watermelon", "anything", "mango"};
        input3.add(Arrays.asList(row4));
        
        String arrcustomer3[] = {"watermelon", "apple", "orange", "mango"};
        
        System.out.println(matchSecretLists(input3, Arrays.asList(arrcustomer3)));
        
        
    }
    public static boolean matchSecretLists(List<List<String>> secretFruitList, List<String> customerPurchasedList) {
        // The idea is simple, for every secret fruit list we will have a stack, two counters
        // one for the customer and one for the secret fruit sub list
        // if we see a matching purchase we will increment the secret fruit counter, other if it doesn't match
        // we will reset that counter
        // then when the forl oop ends we check whether or not the stack matches the size of the list
        // and boom solved
        
        Stack<Integer> stack = new Stack<>();
        
        int fruitCounter = 0;
        
        for(List<String> secret: secretFruitList) {
            // Loop over the customer's purchase
            fruitCounter = 0; // reset it
            
            for(int i=0;i<customerPurchasedList.size();i++) {
                String purchased = customerPurchasedList.get(i);
                if(purchased.equals(secret.get(fruitCounter)) || secret.get(fruitCounter).equals("anything")) {
                    // increment the fruitCounter
                    // and push something to the stack
                    stack.push(69);
                    fruitCounter ++;
                } 
                else {
                    // else reset it
                    fruitCounter = 0;
                }
                
                // if at any point the stack is equal to secret size return true
                if(stack.size() == secret.size()) {
                    return true;
                }
            }

        }
        // didn't find a winner
        return false;
    }
}
