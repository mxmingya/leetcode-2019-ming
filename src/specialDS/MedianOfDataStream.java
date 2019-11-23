class MedianFinder {

    //     TreeMap<Integer, Integer> treeMap;
    //     May.Entry<Integer, Integer> curMedian;
    //     int left = 0, right = 0;
    //     /** initialize your data structure here. */
    //     public MedianFinder() {
    //         treeMap = new TreeMap<Integer, Integer>();
    //         curMedian = null;
    //     }
        
    //     public void addNum(int num) {
    //         if (treeMap.keySet().size() == 0) {
    //             treeMap.put(num, 0);
    //             curMedian = Map.Entry(num, 0);
    //             return;
    //         }
    //         if (num < curMedian.getKey()) {
    //             // add to left
    //             if (left == right) {
    //                 treeMap.put(num, 0);
    //                 curMedian = treeMap.floorEntry(num);
    //             }
    //         } else {
                
    //         }
    //         treeMap.add(num);
            
    //     }
        
    //     public double findMedian() {
            
    //     }
        Queue<Integer> max = new PriorityQueue<>();
      Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
      // Adds a number into the data structure.
      public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()) {
          max.offer(min.poll());//we need to keep max.size() greater then min by 1, so that we can return peek() for median
        }
      }
    
      // Returns the median of current data stream
      public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return max.peek();
      }
    }
    
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */