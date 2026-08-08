class Solution {
    public boolean isValidSudoku(char[][] board) {
        var seenR = new HashMap<Integer, HashSet<Character>>();
        var seenC = new HashMap<Integer, HashSet<Character>>();
        var seenS = new HashMap<Integer, HashSet<Character>>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int s = i / 3 * 3 + j / 3;
                if (seenR.computeIfAbsent(i, HashSet::new).contains(board[i][j])
                || seenC.computeIfAbsent(j, HashSet::new).contains(board[i][j])
                || seenS.computeIfAbsent(s, HashSet::new).contains(board[i][j])) {
                    return false;
                }             
                if ('.' != board[i][j]) {
                    seenR.get(i).add(board[i][j]);
                    seenC.get(j).add(board[i][j]);
                    seenS.get(s).add(board[i][j]);
                }            
            }
        }
        return true;
    }
}
