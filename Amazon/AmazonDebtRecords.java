package Amazon;
import java.util.ArrayList;
import java.util.HashMap;

public class AmazonDebtRecords {
    public static void main(String[] args) {
        ArrayList<ArrayList<Object>> input = new ArrayList<>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("user1");
        row1.add("user2");
        row1.add(100);
        input.add(row1);
        
        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("user1");
        row2.add("user3");
        row2.add(200);
        input.add(row2);
        
        ArrayList<Object> row3 = new ArrayList<>();
        row3.add("user3");
        row3.add("user1");
        row3.add(100);
        input.add(row3);
        
        ArrayList<Object> row4 = new ArrayList<>();
        row4.add("user1");
        row4.add("user2");
        row4.add(150);
        input.add(row4);
        
        System.out.println(amazonDebt(input));
    }
    
    public static String amazonDebt(ArrayList<ArrayList<Object>> input) {
        // map that maps the user to the current balance it has
        HashMap<String, Integer> map = new HashMap<>();
        
        // then we loop through the input arraylist to do parsing
        for(int i=0;i<input.size();i++) {
            ArrayList<Object> row = input.get(i);
            System.out.println(input);
            // gets us the borrower
            String borrower = (String)row.get(0);
            String lender = (String)row.get(1);
            
            int amount = (int)row.get(2);
            
            // the borrower doesn't exist yet we add it in
            if(!map.keySet().contains(borrower)) {
                map.put(borrower, -amount);
            }
            else {
                // it exist, we just add to the debt
                int beforeAmount = map.get(borrower);
                
                map.put(borrower, beforeAmount - amount);
            }
            
            // the lender doesn't exist
            if(!map.keySet().contains(lender)) {
                map.put(lender, amount);
            }
            else {
                // exist already
                int beforeAmount = map.get(lender);
                
                map.put(lender, beforeAmount + amount);
            }
        }
        
        // After we go through, we just have to see which one has the most negative value
        int min = Integer.MAX_VALUE;
        String output = "";
        
        for(String key: map.keySet()) {
            if(min > map.get(key)) {
                min = map.get(key);
                output = key;
            }
        }
        
        System.out.println("The debt is " + min);
        return output;
    }
}
