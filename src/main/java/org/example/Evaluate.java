package org.example;

public class Evaluate {
    class PostfixEvaluation {

        public static double evaluate(String postfix) {
            PilhaDouble pilhaDouble = new PilhaDouble();

            char[] chars = postfix.toCharArray();

            int N = chars.length;

            for (int i = 0; i < N; i++) {
                char ch = chars[i];

                if (isOperator(ch)) {

                    switch (ch) {
                        case '+': pilhaDouble.push(pilhaDouble.pop() + pilhaDouble.pop());     break;
                        case '*': pilhaDouble.push(pilhaDouble.pop() * pilhaDouble.pop());     break;
                        case '-': pilhaDouble.push(-pilhaDouble.pop() + pilhaDouble.pop());    break;
                        case '/': pilhaDouble.push(1 / pilhaDouble.pop() * pilhaDouble.pop()); break;
                    }
                } else if(Character.isDigit(ch)) {
                    pilhaDouble.push(0);
                    while (Character.isDigit(chars[i]))
                        pilhaDouble.push(10 * pilhaDouble.pop() + (chars[i++] - '0'));
                }
            }


            if (!pilhaDouble.isEmpty())
                return pilhaDouble.pop();
            else
                return 0;
        }

        private static boolean isOperator(char ch) {
            return ch == '*' || ch == '/' || ch == '+' || ch == '-';
        }
    }
}
