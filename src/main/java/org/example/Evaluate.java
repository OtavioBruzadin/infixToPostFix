package org.example;

public class Evaluate {
    class PostfixEvaluation {


        /**
         * Evaluate postfix expression
         *
         * @param postfix The postfix expression
         */
        public static double evaluate(String postfix) {
            // Use a stack to track all the numbers and temporary results
            PilhaDouble pilhaDouble = new PilhaDouble();

            // Convert expression to char array
            char[] chars = postfix.toCharArray();

            // Cache the length of expression
            int N = chars.length;

            for (int i = 0; i < N; i++) {
                char ch = chars[i];

                if (isOperator(ch)) {
                    // Operator, simply pop out two numbers from stack and perfom operation
                    // Notice the order of operands
                    switch (ch) {
                        case '+': pilhaDouble.push(pilhaDouble.pop() + pilhaDouble.pop());     break;
                        case '*': pilhaDouble.push(pilhaDouble.pop() * pilhaDouble.pop());     break;
                        case '-': pilhaDouble.push(-pilhaDouble.pop() + pilhaDouble.pop());    break;
                        case '/': pilhaDouble.push(1 / pilhaDouble.pop() * pilhaDouble.pop()); break;
                    }
                } else if(Character.isDigit(ch)) {
                    // Number, push to the stack
                    pilhaDouble.push(0);
                    while (Character.isDigit(chars[i]))
                        pilhaDouble.push(10 * pilhaDouble.pop() + (chars[i++] - '0'));
                }
            }

            // The final result should be located in the bottom of stack
            // Otherwise return 0.0
            if (!pilhaDouble.isEmpty())
                return pilhaDouble.pop();
            else
                return 0;
        }

        /**
         * Check if the character is an operator
         */
        private static boolean isOperator(char ch) {
            return ch == '*' || ch == '/' || ch == '+' || ch == '-';
        }
    }
}
