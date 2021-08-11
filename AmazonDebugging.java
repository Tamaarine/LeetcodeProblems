
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonDebugging {
    static class NodeBST {
        int key;
        NodeBST left, right;
        public NodeBST(int item) {
            key = item;
            left = right = null;
        }
    }
    
    static class NodeLinkedList {
        int key;
        NodeLinkedList left, right;
        public NodeLinkedList(int item) {
            key = item;
            left = right = null;
        }
    }
    public static void main(String [] args) {
//        int arr1[][] = {{1, 3, 5, 9},
//                        {5, 8, 1, 39}, 
//                        {12, 31, 32, 4}};
//        
//        System.out.println(checkPairSumExists(3, 4, arr1, 20));
//        
//        int arr2[] = {1,2,3,4,5,6 ,8};
//        System.out.println(evenMultiplication(8, arr2));
//        System.out.println(oddSum(0, 7, arr2));
     
        NodeBST root = new NodeBST(5);
        NodeBST node1 = new NodeBST(4);
        NodeBST node2 = new NodeBST(8);
        root.left = node1;
        root.right = node2;
        
        System.out.println(searchBST(root, 4));
        
        NodeLinkedList head = new NodeLinkedList(10);
        NodeLinkedList head1 = new NodeLinkedList(10);
        NodeLinkedList head2 = new NodeLinkedList(2);
        NodeLinkedList head3 = new NodeLinkedList(10);

        head.right = head1;
        head1.right = head2;
        head2.right = head3;
        
        System.out.println(searchKeyIndex(head, 10));
        
        int arr3[] = {1, 2, 3, 4, 2};
        System.out.println(calculateGeneralHCF(0, arr3));
        
        System.out.println(calculateSumOfNumbersInString("12how12"));
        System.out.println(removeConsecutiveVowels("haaallo"));
        System.out.println(countTripletSumPermutations(arr3.length, arr3, 4));
    }
    
    public static boolean checkPairSumExists(int rows, int cols, int arr[][], int sum) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(set.contains(sum - arr[i][j])) {
                    return true;
                }
                else {
                    set.add(arr[i][j]);
                }
            }
        }
        return false;
    }
    
    public static int evenMultiplication(int size, int list[]) {
        int evenMulti = 1;
        for(int i=0;i<size;i++) {
            if(list[i] % 2 == 0) {
                evenMulti *= list[i];
            }
        }
        return evenMulti;
    }
    
    public static int oddSum(int start, int end, int list[]) {
        int sum = 0;
        int i = start;
        while(i <= end) {
            if(list[i] % 2 != 0) {
                sum += list[i];
            }
            i++;
        }
        return sum;
    }
    
    public static int searchBST(NodeBST root, int key) {
        if(root == null) {
            return 0;
        }
        if(root.key == key) {
            return 1;
        }
        if(key <= root.key) {
            return searchBST(root.left, key);
        }
        else {
            return searchBST(root.right, key);
        }
    }
    
    public static List<Integer> searchKeyIndex(NodeLinkedList list_head, int key) {
        List<Integer> res = new ArrayList<>();
        int flag = 0;
        int index = -1;
        NodeLinkedList current = list_head;
        
        while(current != null) {
            index++;
            if(current.key == key) {
                res.add(index);
                flag = 1;
            }
            current = current.right;
        }
        
        if(flag == 1) {
            return res;
        }
        else {
            res.add(-1);
            return res;
        }
    }
    
    public static int calculateHCF(int a, int b) {
        if(a == 0){
            return b;
        }
        else {
            return calculateHCF(b % a, a);
        }
    }
    
    public static int calculateGeneralHCF(int len, int arr[]) {
        // we will be looping over arr and for every pair that we encounter,
        // we wil lcalculate the hcf
        int result = arr[0];
        
        for(int i=0;i<arr.length;i++) {
            result = calculateHCF(result, arr[i]);
        }

        return result;
    }
    

    public static int calculateSumOfNumbersInString(String inputString) {
        String temp = "";
        int sum = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch))
                temp += ch;
            else if(temp.length() != 0)
            {
                sum += Integer.parseInt(temp);
                temp = "";
            }
        }
        return sum + Integer.parseInt(temp);
    }
    
    public static boolean is_vowel(char ch) {
        return (ch == 'a') || (ch == 'e') ||
                (ch == 'i') || (ch == 'o') ||
                (ch == 'u');
    }

    public static String removeConsecutiveVowels(String str) {
        String str1 = "";
        str1 = str1+str.charAt(0);
        for(int i = 1; i < str.length(); i++)
            if((!is_vowel(str.charAt(i - 1))) ||
                    (!is_vowel(str.charAt(i)))) {
                char ch = str.charAt(i);
                str1 = str1 + ch;
            }
        return str1;
    }
    
    public static String reverseAlphabetCharsOnly(String inputString) {
        char[] inputChar = inputString.toCharArray();
        int right = inputString.length() - 1;
        int left = 0;
        while(left < right) {
            if(!Character.isAlphabetic(inputChar[left]))
                left++;
            else if(!Character.isAlphabetic(inputChar[right]))
                right--;
            else {
                char temp = inputChar[left];
                inputChar[left] = inputChar[right];
                inputChar[right] = temp;
            }
            left++;
            right--;
        }
        return new String(inputChar);
    }
    
    public static int countTripletSumPermutations(int size, int[] arr, int tripletSum)
    {
        int count = 0;
        for(int i = 0; i < size - 2; i++)
        {
            if(tripletSum % arr[i] == 0)
            {
                for(int j = i +1; j < size - 1; j++)
                {
                    if(tripletSum % (arr[i] * arr[j]) == 0)
                    {
                        int value = tripletSum / (arr[i] * arr[j]);
                        for(int k = j + 1; k < size; k++)
                            if((arr[i] * arr[j] * arr[k]) == tripletSum)
                            {
                                System.out.println(arr[i] + " " + arr[j] + " "+ arr[k]);
                                count ++;
                            }
                    }
                }
            }

        }
        return count;
    }

}
