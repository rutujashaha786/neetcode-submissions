class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq1.add(num);
        pq2.add(pq1.remove());

        if(pq2.size() > pq1.size()){
            pq1.add(pq2.remove());
        }
    }
    
    public double findMedian() {
        int total = pq1.size() + pq2.size();

        if(total % 2 == 1){
            return pq1.peek();
        }
        else{
            double median = (pq1.peek() + pq2.peek()) / 2.0;
            return median;
        }
    }
}
