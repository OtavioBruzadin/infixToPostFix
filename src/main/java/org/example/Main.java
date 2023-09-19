package org.example;

// Java code to convert infix expression to postfix

import java.util.Arrays;
import java.util.Scanner;

import static org.example.Convertions.*;
import static org.example.Evaluate.PostfixEvaluation.evaluate;


class Main{

    public static void main(String[] args)
    {
        int section = 0;
        Scanner scanner = new Scanner(System.in);
        String  infixExpression = "";
        String[] variables = new String[0];
        String[] variableValues = new String[0];
        String PostFixWhitNumbers = null;
        while (section != 5) {
            System.out.println("1. Entrada da expressão aritmética na notação infixa.\n" +
                    "2. Entrada dos valores numéricos associados às variáveis.\n" +
                    "3. Conversão da expressão, da notação infixa para a notação posfixa, e exibição da expressão\n" +
                    "convertida para posfixa.\n" +
                    "4. Avaliação da expressão (apresentação do resultado do cálculo, mostrando a expressão e os\n" +
                    "valores das variáveis).\n" +
                    "5. Encerramento do programa.");
            System.out.println("Qual secao dexeja acessar?: ");
            section = scanner.nextInt();

            if (section == 1) {
                // exemplo : ((a+(B*c))-D)
                System.out.println("Qual o valor da expressao infixa ?: ");
                String infixExpressionInput = scanner.next();
                infixExpression = infixExpressionInput;
                System.out.println("The Infix Expression is: " + infixExpression);

            }
            if (section == 2) {

                variables = createVariableArray(infixExpression);
                System.out.println(Arrays.toString(variables));
                variableValues = assignValuesToLetterVariable(variables);
                String infixWithNumbers = changeLetterToNum(variableValues, infixExpression, variables);
                System.out.println("The Infix Expression with numbers is: " + infixWithNumbers);
            }
            if (section == 3) {
                String convertedToPostFix = String.valueOf(covertInfixToPostfix(infixExpression));
                System.out.println("The Postfix of the given Infix Expression is: " + convertedToPostFix);

                PostFixWhitNumbers = changeLetterToNum(variableValues, convertedToPostFix, variables);
                System.out.println("The Postfix of the given Infix Expression with numbers is: " + PostFixWhitNumbers);
            }
            if(section == 4) {
                double result = evaluate(PostFixWhitNumbers);
                System.out.println("The Result is: " + result);
            }
        }
    }
}