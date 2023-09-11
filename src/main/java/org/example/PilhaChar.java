package org.example;
class PilhaChar {
    static final int MAX = 10;
    int top;
    char[] a = new char[MAX];
    PilhaChar()
    {
        top = -1;
    }

    boolean push(char x)
    {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top] = x;
            return true;
        }
    }

    int pop()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        else {
            int x = a[top--];
            return x;
        }
    }

    char peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            char x = a[top];
            return x;
        }
    }
    int size(){
        return (top+1);
    }

    boolean isEmpty(){
        return top==-1;
    }

    boolean isFull(){
        return top == MAX - 1;
    }
}