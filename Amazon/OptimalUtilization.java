package Amazon;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class OptimalUtilization {
    public static void main(String[] args) {
        int a1[][] = {{1, 2},
              {2, 4},
              {3, 6}
            };
        int b1[][] = {{1, 2}};
        System.out.println(optimalUtilization(a1, b1, 7));
        
        int a2[][] = {{1, 3},
                      {2, 5},
                      {3, 7},
                      {4, 10}
                            };
        
        int b2[][] = {{1, 2},
                      {2, 3},
                      {3, 4},
                      {4, 5}
        };
        System.out.println(optimalUtilization(a2, b2, 10));
        
    }
    public static List<List<Integer>> optimalUtilization(int a[][], int b[][], int k) {
        // iniitalize the output
        List<List<Integer>> output = new ArrayList<>();
        
        // initailize the treemap
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b.length;j++) {
                // go through each of the entry
                // sum them up
                int sum = a[i][1] + b[j][1];
                
                // then if the sum is <= k we will add it to the mapping of sum -> that list
                // but we have to do it in a special way. If the key-value pair mapping doesn't
                // exist then we have to add the new entry, by initailzing an empty list
                // however, if it already exist then we can just append it to the same list easily
                List<List<Integer>> ret = map.computeIfAbsent(sum, value -> new ArrayList<>());
                
                List<Integer> toInsert = new ArrayList<>();
                toInsert.add(a[i][0]);
                toInsert.add(b[j][0]);
                
                // We put that list into the mapped value list
                ret.add(toInsert);
            }
        }
        
        // Then just have to call floorEntry
        return map.floorEntry(k).getValue();
        
    }
}
