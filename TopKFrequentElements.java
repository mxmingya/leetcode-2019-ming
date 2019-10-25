package dfs;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return map.get(i2) - map.get(i1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (Integer num : map.keySet()) {
            pq.add(num);
        }

        for (int i = 0; i < k; i++) {
            list.add(pq.poll());
        }

        return list;
    }
}
