class ShortestCompletingWordPrime {
        private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}; 

    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate.length() == 0 || words.length == 0) {
            return "";
        }
        String res = "aaaaaaaaaaaaaaaaaaaa";
        long product = helper(licensePlate.toLowerCase());
        System.out.println(product);
        for (String word : words) {
            if (res.length() > word.length() && helper(word) % product == 0) {
                res = word;
            }
        }
        
        
        return res;
    }
    
    private long helper(String word) {
        long res = 1L;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (index >= 0 && index <= 25) {
                res *= primes[index];    
            }
        }
        return res;
    }
}
