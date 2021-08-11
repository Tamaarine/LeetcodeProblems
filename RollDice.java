public class RollDice {
    public static void main(String[] args) {
        int arr1[] = {6, 5, 4};
        System.out.println(rollDice(arr1));
        
        int arr2[] = {6, 6, 1};
        System.out.println(rollDice(arr2));
        
        int arr3[] = {6, 1, 5, 4};
        System.out.println(rollDice(arr3));
    }
    
    public static int rollDice(int faces[]) {
        // The way to do this problem is not that bad
        // we first determine a face we will be comparing all the other faces
        // with, which we will just assume to be faces[0]
        // if the other faces isn't equal to 7 - faces[0] then we add one
        // otherwise we will be adding 2
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<faces.length;i++) {
            // i will be our anchor
            int anchor = faces[i];
            int rotations = 0;
            
            for(int j=0;j<faces.length;j++) {
                if(faces[j] == 7 - anchor) {
                    rotations += 2;
                }
                else if(i != j && faces[i] != faces[j]) {
                    rotations += 1;
                }
            }
            
            // then we update rotation
            if(min > rotations) {
                min = rotations;
            }
            
        }
        
        return min;
        
    }
}