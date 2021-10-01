package _347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int input1[] = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequentBetter(input1, 2)));

        int input2[] = {1};
        System.out.println(Arrays.toString(topKFrequentBetter(input2, 1)));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Do a quick hash map
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }

        }
        int output[] = new int[k];
        int counter = 0;
        for(int i=0;i<k;i++) {
            Optional<Integer> max = map.keySet().stream().findFirst();
            int realMax = max.get();
            for(Integer j : map.keySet()) {
                if(map.get(j) > map.get(realMax)){
                    realMax = j;
                }
            }
            output[counter] = realMax;
            map.remove(realMax);
            counter++;
        }
        return output;
    }

    public static int[] topKFrequentBetter(int[] nums, int k) {
        // The better is approach is to first do the hashmap
        // element -> frequency
        // Then we can build a max heap (priority queue) where we dequeue
        // the element based on the frequency count

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Then we maintain a heap, the comparator that we will use is
        // put all the smaller frequency count elements in the beginning
        // How to decide which one is in front or which one is smaller;
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

        // Then we will basically build up the heap using the frequency count
        // and then dequeue to get our elements
        // Whenever the heap's size is greater than k we will dequeu
        // this is getting rid of the lower frequency count elements which we
        // don't care
        for(Integer key : map.keySet()) {
            heap.add(key); // add the key which is the actual element base on the frequency count
            // where the actual position is added
            if(heap.size() > k) heap.poll(); // dequeue whenever the size is > k, to get rid of the
            // smaller frequency count
        }

        // For example, we have
        /**
         * 1 -> 4
         * 2 -> 3
         * 3 -> 2
         * 4 -> 1
         * 5 -> 99
         * say k = 3, we only want the top 3 elements. Our queue's history would be
         * 1
         * 2, 1 (we put less frequent element in the front)
         * 3, 2, 1
         * 4, 3, 2, 1 -> 3, 2, 1 because we the size of queue is > k, we dequeue 4
         * 3, 2, 1, 5 -> 2, 1, 5 we dequeue 3 because it's frequent count is smaller
         */

        // Build our array
        int output[] = new int[k];
        for(int i=0;i<k;i++) {
            output[i] = heap.poll();
        }
        return output;
    }

    /**
     * def topKFrequent(self, nums, k):
    bucket = [[] for _ in range(len(nums) + 1)]
    Count = Counter(nums).items()
    for num, freq in Count: bucket[freq].append(num)
    flat_list = [item for sublist in bucket for item in sublist]
    return flat_list[::-1][:k]
     */
    public static int[] topKFrequentEvenBetter(int[] nums, int k) {
        // An even better implementation is to do bucket sort
        // basically we create a maximum of len(nums) + 1 buckets
        // each bucket holds elements that has i frequency
        // first example the first bucket hold elements with 0 frequency
        // second bucketh olds element with 1 frequency and so on
        // so we do a o(n) loop through the nums to collect each element
        // 's frequency through hashmap or a counter dictionary in python
        // then we can just loop through that dictionary to put it in our
        // bucket, collecting same frequency element together in a bucket
        // then flat out the bucket. [[], [1,2,3], [4,5,6]] -> [1,2,3,4,5,6]
        // and only grab the k elements from the back
        // insane algorithm
        return null;
    }

}