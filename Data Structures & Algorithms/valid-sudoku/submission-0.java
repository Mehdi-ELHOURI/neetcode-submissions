class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        char[] col = new char[n];
        for (int i = 0; i < n; i++) {
            if (hasDuplicateDigits(board[i])) {
                return false;
            }
            for (int j = 0; j < n; j++) {
                col[j] = board[j][i];
            }
            if (hasDuplicateDigits(col)) {
                return false;
            }
        }
        char[] subBox = new char[n];
        for (int i = 0; i < n; i+=3) {
            for (int j = 0; j < n; j+=3) {
                int s = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        subBox[s++] = board[i+k][j+l];
                    }
                }
                if (hasDuplicateDigits(subBox)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasDuplicateDigits(char[] line) {
        var occs = new HashMap<Character, Integer>();
        for (var cell : line) {
            if (occs.containsKey(cell) && cell != '.') {
                return true;
            }
            occs.put(cell, 1);
        }
        return false;
    }
}
