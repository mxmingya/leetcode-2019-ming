class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        String[] words = str.split("\\s");
        char[] chars = pattern.toCharArray();
        if (chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], words[i]);
                if (visited.contains(words[i])) {
                    return false;
                }
                visited.add(words[i]);
            }
            else {
                if (!map.get(chars[i]).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
