class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (isOpening(current)) stack.offerLast(current);
            else {
                if (stack.isEmpty()) return false;
                Character opening = stack.pollLast();
                if (!current.equals(closingParenthese(opening))) return false;
            }
        }
        return stack.isEmpty();
    }

    private static Character closingParenthese(Character parenthese) {
        return switch (parenthese) {
            case '{' -> '}';
            case '[' -> ']';
            case '(' -> ')';
            default -> null;
        };
    }

    private static boolean isOpening(Character parenthese) {
        return switch (parenthese) {
            case '{', '[', '(' -> true;
            default -> false;
        };
    }
}
