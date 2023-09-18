package org.example;

public class Convertions {
    static boolean checkIfOperand(char ch)
    {
        return Character.isLetterOrDigit(ch);
    }
    static int precedence(char ch)
    {
        switch (ch)
        {
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

    static StringBuilder covertInfixToPostfix(String expr){
        int i;
        PilhaChar s = new PilhaChar();
        StringBuilder result = new StringBuilder(new String(""));

        for (i = 0; i < expr.length(); ++i)
        {
            if (checkIfOperand(expr.charAt(i)))
                result.append(expr.charAt(i));


            else if (expr.charAt(i) == '(' || expr.charAt(i) == '[' || expr.charAt(i) == '{')
                s.push(expr.charAt(i));

            else if (expr.charAt(i) == ')' || expr.charAt(i) == ']' || expr.charAt(i) == '}')
            {
                if(expr.charAt(i) == ')'){
                    while (!s.isEmpty() && s.peek() != '('){
                        result.append(s.peek());
                        s.pop();
                    }

                    s.pop();
                }

                if(expr.charAt(i) == ']'){
                    while (!s.isEmpty() && s.peek() != '['){
                        result.append(s.peek());
                        s.pop();
                    }

                    s.pop();
                }
                if(expr.charAt(i) == '}'){
                    while (!s.isEmpty() && s.peek() != '{'){
                        result.append(s.peek());
                        s.pop();
                    }

                    s.pop();
                }
            }
            else
            {
                while (!s.isEmpty() && precedence(expr.charAt(i)) <= precedence(s.peek())){
                    result.append(s.peek());
                    s.pop();
                }
                s.push(expr.charAt(i));
            }

        }
        return result;

    }

    String changeLetterToNum(int[] num , String equation, char[] letters){
        for(int i = 0; i<= letters.length; i++){
               equation= equation.replace(letters[i],(char) num[i]);
        }
        return equation;
    }
}
