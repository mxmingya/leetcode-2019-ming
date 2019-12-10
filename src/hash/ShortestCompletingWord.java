class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate.length() == 0 || words.length == 0) {
            return "";
        }
        String res = "";
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if ( Character.isLetter(c) ) {
                counter.put(Character.toLowerCase(c), counter.getOrDefault(Character.toLowerCase(c), 0)+1);   
            }
        }
        // for (char c : counter.keySet()) {
        //     System.out.printf("%s %d\n", c+"", counter.get(c));
        // }
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Map<Character, Integer> current = new HashMap<>();
            for (char c : chars) {
                current.put(c, current.getOrDefault(c, 0)+1);
            }
            boolean exist = true;
            for (char c : counter.keySet()) {
                if (!current.containsKey(c) || (current.containsKey(c) && counter.get(c) > current.get(c))) {
                    exist = false;
                } 
            }
            if (exist && ( res.length() == 0 || chars.length < res.length() ) ) {
                res = new String(chars);
            }
        }
        return res;
    }
}
