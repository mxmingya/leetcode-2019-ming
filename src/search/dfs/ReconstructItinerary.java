class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        LinkedList<String> iternary = new LinkedList<>();
        
        for (List<String> list : tickets) {
            if (!map.containsKey(list.get(0))) {
                map.put(list.get(0), new PriorityQueue<String>());
            }
            map.get(list.get(0)).add(list.get(1));
        }
        
        dfs(tickets, "JFK", iternary, map);
        
        return iternary;
    }
    
    void dfs(List<List<String>> tickets, String des, LinkedList<String> iternary, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> destinations = map.get(des);
        while (destinations != null && !destinations.isEmpty()) {
            String curDes = destinations.poll();
            dfs(tickets, curDes, iternary, map);
        }
        iternary.addFirst(des);
    }
}
