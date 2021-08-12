package Amazon;
public class Gate {
    public static void main(String[] args) {
        int arr1[] = {1, 1, 1,1 , 2};
        System.out.println(gatewayThrotting(arr1));
        
        int arr2[] = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7};
        System.out.println(gatewayThrotting(arr2));
    }
    
    public static int gatewayThrotting(int arr[]) {
        // for this problem we just need one for loop
        // o(n). Keep a counter for the answer, the number of redirected person
        // go through each request. There will be 3 if-cases
        // 1. if the i > 2, meaning that at least 3 element have been passed && arr[i] == arr[i - 3]
        // meaning that the fourth same request, will be redirected
        
        // 2. if the i > 19, meaning that at least 20 element have been passed && arr[i] - arr[i - 20] <= 10
        // this means that within 10 second period, there is more than 20 requests. So we need to redirect
        
        // 3. finally if i > 59, meanig that there is at least 60 elements have passed  && arr[i] - arr[i - 60] <= 60
        // meaning that within 60 seconds period, there is more than 60 requests. so again need to redirect
        
        int ans = 0;
        for(int i=0;i<arr.length;i++) {
            if(i > 2 && arr[i] == arr[i -3]) {
                ans ++;
            }
            else if(i > 19 && arr[i] - arr[i - 20] < 10) {
                ans ++;
            }
            else if(i > 59 && arr[i] - arr[i - 60] < 20) {
                ans ++;
            }
        }
        return ans;
        
    }
}
