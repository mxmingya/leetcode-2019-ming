class FindWinneronaTicTacToeGame {
    public String tictactoe(int[][] moves) {
        Map<Integer, Integer> rows = new HashMap<>();
        rows.put(0, 0);
        rows.put(1, 0);
        rows.put(2, 0);
        Map<Integer, Integer> cols = new HashMap<>();
        cols.put(0, 0);
        cols.put(1, 0);
        cols.put(2, 0);
        
        int diagonal = 0, antidiagonal = 0;
        if (moves.length == 0) {
            return "Pending";
        }
        boolean checkA = moves.length % 2 == 1;
        int i = 1;
        if (checkA) {
            i = 0;
        }
        for (; i < moves.length; i=i+2) {
            int[] currentMove = moves[i];
            rows.put(currentMove[0], rows.get(currentMove[0])+1);
            cols.put(currentMove[1], cols.get(currentMove[1]+1));
            if (currentMove[0] == currentMove[1]) {
                diagonal++;
            } else if (currentMove[1] == 0 - currentMove[0]) {
                antidiagonal++;
            }
        }
        boolean wining = diagonal == 3 || antidiagonal == 3 || rows.get(0) == 3 || rows.get(1) == 3 || rows.get(2) == 3 || cols.get(0) == 3 || cols.get(1) == 3 || cols.get(2) == 3;
        if ( wining && checkA) {
            return "A";
        }
        else if (wining ) {
            return "B";
        }
        else {
            return moves.length == 9 ? "Draw" : "Pending";
        }
    }
}
