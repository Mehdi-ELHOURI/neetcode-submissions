class Solution {
    public boolean isValidSudoku(char[][] board) {
        var seenR = new ArrayList<HashSet<Character>>();
        var seenC = new ArrayList<HashSet<Character>>();
        var seenS = new ArrayList<HashSet<Character>>();
        for (int i = 0; i < board.length; i++) {
            seenR.add(new HashSet());
            seenC.add(new HashSet());
            seenS.add(new HashSet());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int s = i / 3 * 3 + j / 3;
                if (seenR.get(i).contains(board[i][j])
                || seenC.get(j).contains(board[i][j])
                || seenS.get(s).contains(board[i][j])) {
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
