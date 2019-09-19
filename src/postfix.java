import java.util.*;
class Test {
    static int value(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;

    }

    static String infixtopostfix(String exp) {
        int l = exp.length();
        String str = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < l; i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                str += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    str += stack.pop();
                stack.pop();


            } else {
                while (!stack.isEmpty() && value(c) <= value(stack.peek())) {
                    str += stack.pop();
                }
                stack.push(c);
            }
        }
            while (!stack.isEmpty()) {
                str += stack.pop();
            }


        return str;
    }


    public static void main(String[] args) {
        String s = "a*(b+c)-d/g*f";
        System.out.println(infixtopostfix(s));
        System.out.println(2*(5+4)-8/4*2);

    }
}