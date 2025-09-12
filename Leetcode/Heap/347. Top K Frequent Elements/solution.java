class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) //O(n)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        //Min-Heapz: elements are ordered by frequency (smallest frequency at the top)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue() 
        );
        
        //Iterates over frequency map, adding elements to the heap
        //O(n log k) Inserting into a heap takes O(log k) time, and we insert up to n elements
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            // keep k top frequent elements in the PriorityQueue.
            if (pq.size() > k) pq.poll();
        }
        
        // Extract elements in reverse order
        int[] arr = new int[k];
        int i=k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }
}
