package org.example;
class PilhaDouble {
    static final int MAX = 10;
    int top;
    double[] a = new double[MAX];
    PilhaDouble()
    {
        top = -1;
    }

    boolean push(double x)
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

    double pop()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        else {
            double  x = a[top--];
            return x;
        }
    }

    double peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            double x = a[top];
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

