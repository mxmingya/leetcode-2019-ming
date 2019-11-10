class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";  
        } 
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int numOfCurrence  = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int last = c - '0';
                numOfCurrence = numOfCurrence * 10 + last;
            }
            else if (c == '[') {
                strStack.push(currentStr);
                intStack.push(numOfCurrence);
                currentStr = new StringBuilder();
                numOfCurrence = 0;
            }
            else if (c == ']') {
                StringBuilder lastStr = currentStr;
                currentStr = strStack.pop();
                int times = intStack.pop();
                for (int i = 0; i < times; i++) {
                    currentStr.append(lastStr);
                }
            } else { // character
                currentStr.append(c);
            }
        }
        
        return currentStr.toString();
    }
}
