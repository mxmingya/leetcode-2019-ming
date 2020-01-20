class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> trustPerson = new HashSet<>();
        for (int[] arr : trust) {
            trustPerson.add(arr[0]);
            if (!map.containsKey(arr[1])) {
                map.put(arr[0], 0); 
            }
            map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        }
        
        for (int i = 1; i <= N; i++) {
            if (!trustPerson.contains(i) && map.containsKey(i) && map.get(i) == N - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
