class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;

    public KthLargest(int k, int[] nums) {
        this.cap = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
        
    }
    
    public int add(int val) {
        if (pq.size() < cap) {
            pq.add(val);
            return pq.peek();
        }
        if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }
}

