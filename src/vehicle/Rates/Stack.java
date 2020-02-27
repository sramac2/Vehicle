/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.Rates;

/**
 *
 * @author RXD0512A
 */
public class Stack {
    private int[] elements;
    private int top;

    public Stack(){
        elements = new int[10];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
         return top == elements.length-1;
    }

    public void push(int item){
        if (isFull())System.out.println("* STACK FULL- CANNOT PUSH *");
        else{
            top += top;
            elements[top] = item;
        }
    }

    public int pop(){
        if (top == -1)
            System.out.println("* STACK EMPTY - CANNOT POP *");
        else{
            int top_item = elements[top];

            
        }
        return 1;
    }
}
