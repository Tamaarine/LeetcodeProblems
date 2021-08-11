import java.util.ArrayList;

public class ChooseAFlask {
    
    static class PairInt {
        int first, second;
        public PairInt() {
            
        }
        public PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public static void main(String[] args) {
        int numOrders = 4;
        int requirements[] = {4 ,6 ,6 ,7};
        int flaskTypes = 3;
        int totalMarks = 9;
        PairInt markings[] = new PairInt[9];
        markings[0] = new PairInt(0, 3);
        markings[1] = new PairInt(0, 5);
        markings[2] = new PairInt(0, 9);
        markings[3] = new PairInt(1, 6);
        markings[4] = new PairInt(1, 8);
        markings[5] = new PairInt(1, 9);
        markings[6] = new PairInt(2, 3);
        markings[7] = new PairInt(2, 5);
        markings[8] = new PairInt(2, 6);
        
        System.out.println(chooseAFlask(numOrders, requirements, flaskTypes, totalMarks, markings));

    }
    
    public static int chooseAFlask(int numOrders, int requirements[], int flaskTypes, int totalMarks, PairInt markings[]) {
        // We first determine the biggest requirement in requirements as that
        // will determine which flask at minimum we need use
        int maxRequirement = 0;
        
        for(int i=0;i<numOrders;i++) {
            maxRequirement = maxRequirement < requirements[i] ? requirements[i] : maxRequirement;
        }
        
        // Use to store the markings we have collected so far
        ArrayList<Integer> flaskMark = new ArrayList<>();
        
        int minWasted = Integer.MAX_VALUE;
        int minIndex = 0;
        
        // Then we will use a for loop to find the last entry for that flask
        for(int i=0;i<totalMarks;i++) {
            PairInt currentPair = markings[i];
            PairInt nextPair;
            // The last entry, well it is special
            if(i == totalMarks - 1) {
                nextPair = new PairInt(-1, -1);
            }
            else {
                nextPair = markings[i + 1];
            }
            
            // That means the pair we are currently at right now serves as the maximum
            // we check whether or not this flask can satisfy our maxRequirement
            if(nextPair.first == -1 || currentPair.first != nextPair.first) {
                flaskMark.add(currentPair.second);
                
                if(currentPair.second >= maxRequirement) {
                    // This means that it can satisfy then we will have to loop through
                    // all of the requirements and do the math
                    int wasted = 0;
                    for(int j=0;j<numOrders;j++) {
                        wasted += findSuitableMark(flaskMark, requirements[j]);
                    }
                    // Update minwasted and the corresponding index
                    if(minWasted > wasted) {
                        minWasted = wasted;
                        minIndex = currentPair.first;
                    }
                    flaskMark.clear();
                    
                }
                else {
                    // It cannot satisfy it, clear the list and move on
                    flaskMark.clear();
                }
            }
            else {
                flaskMark.add(currentPair.second);
            }
        }
        
        System.out.println("With min wasted as " + minWasted);
        return minIndex;

    }
    
    // Return the left over after finding a suitable mark
    public static int findSuitableMark(ArrayList<Integer> marks, int target) {
        for(int i=0;i<marks.size();i++) {
            int currentMark = marks.get(i);
            
            if(currentMark >= target) {
                return currentMark - target;
            }
        }
        
        // Means that it cannot find a suitable mark
        return -1;
    }
}
