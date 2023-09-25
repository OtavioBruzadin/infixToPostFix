package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    static String changeLetterToNum(String[] num , String equation, String[] letters){
        for(int i = 0; i<= letters.length - 1; i++){
               equation= equation.replace(letters[i],num[i]+" ");
        }
        return equation;
    }

    static String[] createVariableArray(String equation){
        List<String> variableList = new ArrayList<>();
        int nOfVariables = 0;
        for (int i = 0; i < equation.length(); i++) {
            if(Character.isLetter(equation.charAt(i))){
                if(variableList.isEmpty()) {
                    variableList.add(String.valueOf(equation.charAt(i)));
                }else {
                if(!variableList.contains(String.valueOf(equation.charAt(i)))){
                    variableList.add(String.valueOf(equation.charAt(i)));
                }
                }
            }
        }
        return turnListIntoArray(variableList);
    }

    static String[] turnListIntoArray(List<String> list){
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            array[i]= list.get(i);
        }
        return array;
    }

    static String[] assignValuesToLetterVariable(String[] variables){
        Scanner scanner = new Scanner(System.in);
        String[] variableValuesArray = new String[variables.length];
        for (int i = 0; i < variables.length ; i++) {
            System.out.println("Qual o valor da variavel "+variables[i]+" ?:");
            String variableValue = scanner.nextLine();
            variableValuesArray[i]=variableValue;
        }
        return variableValuesArray;
    }

}
