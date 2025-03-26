package com.java.stack;

import java.util.*;

public class EvaluateExpression {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("2", "1", "+", "3", "*");
        List<String> list = Arrays.asList("2", "2", "/");
        int ans = evalRPN(list);
        System.out.println(ans);

    }

    private static int evalRPN(List<String> list) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : list) {
            if (isOperator(token)) {
                // perform the operation
                int op2 = stack.pop(); // right hand side of
                int op1 = stack.pop(); // left hand side of operand
                int result = doOperation(token, op1, op2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static int doOperation(String token, int op1, int op2) {
        return switch (token) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> throw new IllegalArgumentException("Not valid operator");
        };
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }


}
