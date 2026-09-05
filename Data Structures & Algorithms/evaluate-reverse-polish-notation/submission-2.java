class Solution {
    private final Deque<Integer> stack = new LinkedList<>();

    public int evalRPN(String[] tokens) {
        for (var token : tokens) {
            if (isOperator(token)) {
                stack.push(evaluate(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int evaluate(int opd1, int opd2, String opt) {
        return switch (opt) {
            case "+" -> opd2 + opd1;
            case "-" -> opd2 - opd1;
            case "*" -> opd2* opd1;
            default -> opd2 / opd1;
        };
    }
}
