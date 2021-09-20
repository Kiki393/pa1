package com.compiler;

import java.util.*;
public class StackMachine<E> {
    static int value;
    static String input;

    public static Scanner keyboard = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instance of the stack class
        var stc = new StackCommands<Integer>();

        System.out.println("Welcome to the Stack Machine.");
        System.out.println("Commands: \n1) Enter 'x' to stop. \n2) Enter 'd' to display the contents of the stack." + 
        "\n3) Enter '+' to sum the first two integer values. \n4) Enter 's' to swap the first two integer values. \n5) Enter 'e' to evaluate the stack." +
        "NOTE: This will remove all elements from the stack and sum them.");
        System.out.println("\nEnter values to add to the stack machine.");

        do{
            System.out.print("> ");
            input = keyboard.nextLine();

            if (Character.isDigit(input.charAt(0))) { // Checks if input from user is a digit or not
                value = Integer.parseInt(input);
                stc.push(value);
            }
            else if (input.equals("+")){
                if (!stc.isEmpty()) {
                    int tempNum1 = stc.pop();
                    int tempNum2 = stc.pop();

                    int sum = tempNum1 + tempNum2;
                    stc.push(sum);
                }  
                else{
                    System.out.println("The stack is empty");
                }

                // Displays stack after summing and pushing result
                System.out.println();
                stc.display();
            }   
            else if (input.equals("d")) {
                    System.out.println("\nThe contents of the stack are:");
                    stc.display();
                    System.out.println();
            }
            else if (input.equals("s")) {
                if (!stc.isEmpty()) {
                    int tempNum1 = stc.pop();
                    int tempNum2 = stc.pop();

                    stc.push(tempNum2);
                    stc.push(tempNum1);
                }  
                else{
                    System.out.println("The stack is empty");
                }
            }
            else if (input.equals("e")) {
                int sum = 0;
                for (int i = 0; i <= stc.size + 1; i++) {
                    sum = sum + stc.pop();
                }
                System.out.println("\nThe total sum of values in the stack is: " + sum);
            }
        }while(!input.equals("x"));
        
        System.out.println("\nStack exited");
        
        keyboard.close();
    }
}
