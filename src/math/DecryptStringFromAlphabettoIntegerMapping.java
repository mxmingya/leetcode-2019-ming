class DecryptStringFromAlphabettoIntegerMapping {
    char[] chars = {'a','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0) {
            return sb.toString();
        }
        int pointer = 0, len = s.length();
        while (pointer < s.length()) {
            if (pointer + 2 < len && s.charAt(pointer + 2) == '#') {
                sb.append(chars[Integer.parseInt(s.substring(pointer, pointer + 2))]);
                pointer += 3;
            } else {
                sb.append(chars[Integer.parseInt(s.substring(pointer, pointer + 1))]);
                pointer++;
            }
        }
        return sb.toString();
    }
}
