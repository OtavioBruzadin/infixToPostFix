package org.example;

// Java code to convert infix expression to postfix

import static org.example.Convertions.covertInfixToPostfix;
import static org.example.Evaluate.PostfixEvaluation.evaluate;


class Main{

    public static void main(String[] args)
    {
        String infixExpression = "((a+(b*c))-d)";
        System.out.println("The Infix Expression is: "+infixExpression);
        StringBuilder result = covertInfixToPostfix(infixExpression);
        System.out.println("The Postfix of the given Infix Expression is: "+result);

        String postfix = "1 12 23 + * 4 5 / -";
        double value = evaluate(postfix);
        System.out.println(value);
    }
}