public class CutArray {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 2, 2, 8, 1, 1, 1, 1};
        System.out.println(loadBalance(arr1));
        
        int arr2[] = {1, 1, 1, 1};
        System.out.println(loadBalance(arr2));
    }
    
    public static boolean loadBalance(int[] arr) {
        // The idea is we will be doing two for loops, the first loop representing
        // the first index, the second for loop representing the second index
        // to cut from, and for each of the three pieces we will do a sumation
        // see if all those three part sum are equal. If eqaul return true
        // else keep going and until loop ends we will return false
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                int firstPart = helper(arr, 0, i);
                int secondPart = helper(arr, i+1, j);
                int thirdPart = helper(arr, j + 1, arr.length);
                System.out.print(firstPart + " "+ secondPart + " " + thirdPart);
                System.out.println(String.format(" With i %d j %d",i, j));
                if(firstPart == secondPart && firstPart == thirdPart) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int helper(int arr[], int start, int end) {
        // sums up all the element from index start to index end not including end
        int result = 0;
        for(int i=start;i<end;i++) {
            result += arr[i];
        }
        return result;
    }
}
