package com.compiler;

import java.util.*;
public class StackMachine<E> {
    static int value;
    static String input;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Instance of the stack class
        var stc = new StackCommands<Integer>();

        System.out.println("Welcome to the Stack Machine.");
        System.out.println("Enter 'x' to Stop adding to the stack.");
        System.out.println("\nEnter a value to add to the stack machine.");

        do{
            input = keyboard.nextLine();

            if (input.equals("+")) {
            
                if (!stc.isEmpty()) {
                    int tempNum1 = stc.pop();
                    int tempNum2 = stc.pop();

                    int sum = tempNum1 + tempNum2;
                    stc.push(sum);
                }  
                else{
                    System.out.println("The stack is empty");
                    return;
                }

                System.out.println();
                stc.display();

            }
              else{
                value = Integer.parseInt(input);
                stc.push(value);
            }
            
        }while(!input.equals("x"));
        
        System.out.println("Exited");
        stc.display();

        keyboard.close();
    }
}
