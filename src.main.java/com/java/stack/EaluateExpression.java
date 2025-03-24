package com.java.stack;

import javax.naming.InitialContext;
import java.util.*;

public class EaluateExpression {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2", "1", "+", "3", "*");
        int ans = evalRPN(list);
        System.out.println(ans);

    }

    public static int evalRPN(List<String> A) {
        Deque<String> stack = new ArrayDeque<>();
        for (String op : A) {
            if (!Objects.equals(op, "+") && !Objects.equals(op, "*") && !Objects.equals(op, "-") && !Objects.equals(op, "/")) {
                stack.push(op);
            } else {
                if (Objects.equals(op, "+")) {
                    Integer result = doPoperation(op, stack.pop(), stack.pop());
                    stack.push(String.valueOf(result));

                } else if (Objects.equals(op, "*")) {
                    Integer result = doPoperation(op, stack.pop(), stack.pop());
                    stack.push(String.valueOf(result));

                } else if (Objects.equals(op, "-")) {
                    Integer result = doPoperation(op, stack.pop(), stack.pop());
                    stack.push(String.valueOf(result));

                } else {
                    Integer result = doPoperation(op, stack.pop(), stack.pop());
                    stack.push(String.valueOf(result));

                }
            }
        }

        return Integer.parseInt(Objects.requireNonNull(stack.poll()));
    }

    private static Integer doPoperation(String operator, String operand2, String operand1) {
        if (Objects.equals(operand1, "+")) {
            return Integer.parseInt(operand1) + Integer.parseInt(operand2);
        } else if (Objects.equals(operator, "*")) {
            return Integer.parseInt(operand1) * Integer.parseInt(operand2);
        } else if (Objects.equals(operator, "-")) {
            return Integer.parseInt(operand1) - Integer.parseInt(operand2);
        } else {
            return Integer.parseInt(operand1) / Integer.parseInt(operand2);
        }

    }
}
