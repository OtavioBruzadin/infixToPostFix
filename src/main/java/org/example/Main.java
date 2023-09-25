package org.example;

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
        String PostFixWithNumbers = null;
        System.out.println("1. Entrada da expressão aritmética na notação infixa.\n" +
                "2. Entrada dos valores numéricos associados às variáveis.\n" +
                "3. Conversão da expressão, da notação infixa para a notação posfixa, e exibição da expressão\n" +
                "convertida para posfixa.\n" +
                "4. Avaliação da expressão (apresentação do resultado do cálculo, mostrando a expressão e os\n" +
                "valores das variáveis).\n" +
                "5. Encerramento do programa.");
        while (section != 5) {
            try {
                System.out.println("Qual seção deseja acessar?: ");
                section = scanner.nextInt();

                if (section == 1) {
                    // exemplo : ((a+(B*c))-D)
                    System.out.println("Qual o valor da expressao infixa ?: ");

                    String infixExpressionInput = scanner.next();
                    infixExpression = infixExpressionInput;
                    System.out.println("A expressao infixa é: " + infixExpression);

                }
                if (section == 2) {

                    variables = createVariableArray(infixExpression);
                    System.out.println(Arrays.toString(variables));
                    variableValues = assignValuesToLetterVariable(variables);
                    String infixWithNumbers = changeLetterToNum(variableValues, infixExpression, variables);
                    System.out.println("A expressao Infixa com numeros é: " + infixWithNumbers);
                }
                if (section == 3) {
                    String convertedToPostFix = String.valueOf(covertInfixToPostfix(infixExpression));
                    System.out.println("A Posfixa da expressão Infixa dada é: " + convertedToPostFix);

                    PostFixWithNumbers = changeLetterToNum(variableValues, convertedToPostFix, variables);
                    System.out.println("A versao posfixa com numeros é: " + PostFixWithNumbers);
                }
                if (section == 4) {
                    assert PostFixWithNumbers != null;
                    double result = evaluate(PostFixWithNumbers);
                    System.out.println("O resultado é: " + result);
                }
            }catch ( Exception Exception ){
                System.out.println("Epa algo deu errado :( , tente novamente! ");
                break;
            }
        }
        System.out.println("Obrigado por usar nosso software :) ");
    }
}