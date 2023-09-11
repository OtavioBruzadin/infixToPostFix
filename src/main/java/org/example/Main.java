package org.example;

// Java code to convert infix expression to postfix

import static org.example.Convertions.covertInfixToPostfix;

class Main{

    public static void main(String[] args)
    {
        String infixExpression = "((a+(b*c))-d)";
        System.out.println("The Infix Expression is: "+infixExpression);
        StringBuilder result = covertInfixToPostfix(infixExpression);
        System.out.println("The Postfix of the given Infix Expression is: "+result);
    }
}