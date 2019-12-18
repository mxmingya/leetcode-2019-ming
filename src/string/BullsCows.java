class BullsCows {
    public String getHint(String secret, String guess) {
        // number -> reminding times
        Map<Character, Integer> map = new HashMap<>();
        for (char c : secret.toCharArray()) {
            // String cur = c + "";
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int bull = 0, cow = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (secret.charAt(i) == c) {
                bull++;
                map.put(c, map.get(c)-1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c != secret.charAt(i) && map.containsKey(c) && map.get(c) > 0) {
                cow++;
                map.put(c, map.get(c)-1);
            }
        }
        
        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }
}
