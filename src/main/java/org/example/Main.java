package org.example;

// Java code to convert infix expression to postfix

import java.util.Arrays;

import static org.example.Convertions.*;
import static org.example.Evaluate.PostfixEvaluation.evaluate;


class Main{

    public static void main(String[] args)
    {

        String infixExpression = "((a+(B*c))-D)";

        System.out.println("The Infix Expression is: "+infixExpression);

        String[] variables = createVariableArray(infixExpression);
        String[] variableValues = assignValuesToLetterVariable(variables);


        String infixWithNumbers = changeLetterToNum(variableValues,infixExpression,variables);
        System.out.println("The Infix Expression with numbers is: "+infixWithNumbers);


        String convertedToPostFix = String.valueOf(covertInfixToPostfix(infixExpression));
        System.out.println("The Postfix of the given Infix Expression is: "+convertedToPostFix);


        String PostFixWhitNumbers = changeLetterToNum(variableValues,convertedToPostFix,variables);
        System.out.println("The Postfix of the given Infix Expression with numbers is: "+PostFixWhitNumbers);

        double result = evaluate(PostFixWhitNumbers);
        System.out.println("The Result is: "+result);

    }
}