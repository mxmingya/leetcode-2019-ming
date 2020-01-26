
class FilterRestaurantsbyVeganFriendlyPriceandDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                int[] a1 = restaurants[index1], a2 = restaurants[index2];
                if (a1[1] != a2[1]) {
                    return a2[1] - a1[1];
                } else {
                    return a2[0] - a1[0];
                }
            }
        });
        List<Integer> res = new ArrayList<>();
        
        //restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distance]. 
        for (int i = 0; i < restaurants.length; i++) {
            int[] r = restaurants[i];
            if ((veganFriendly == 1 && r[1] == 0) || r[3] > maxPrice || r[4] > maxDistance) {
                continue;
            }
            pq.offer(i);
        }
        while (!pq.isEmpty()) {
            int index = pq.poll();
            res.add(restaurants[index][0]);
        }
        return res;
    }
}
