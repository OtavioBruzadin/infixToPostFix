package org.example;

// Java code to convert infix expression to postfix

import static org.example.Convertions.covertInfixToPostfix;
import static org.example.Evaluate.PostfixEvaluation.evaluate;
import static org.example.Convertions.changeLetterToNum;


class Main{

    public static void main(String[] args)
    {
        String[] nums = {"10","20","30","40"};
        String[] letters = {"a","b","c","d"};

        String infixExpression = "((a+(b*c))-d)";
        System.out.println("The Infix Expression is: "+infixExpression);

        String infixWithNumbers = changeLetterToNum(nums,infixExpression,letters);
        System.out.println("The Infix Expression with numbers is: "+infixWithNumbers);


        String result = String.valueOf(covertInfixToPostfix(infixExpression));
        System.out.println("The Postfix of the given Infix Expression is: "+result);

        String postFixWithNumbers = changeLetterToNum(nums,result,letters);
        System.out.println("The PostFix Expression with numbers is: "+postFixWithNumbers);

        double value = evaluate(postFixWithNumbers);
        System.out.println("The Result is: "+value);
    }
}