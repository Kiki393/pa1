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

        System.out.println("\nWelcome to the Stack Machine.");
        System.out.println("Commands: \n1) Enter 'x' to stop. \n2) Enter 'd' to display the contents of the stack." + 
        "\n3) Enter '+' to sum the first two integer values. \n4) Enter 's' to swap the first two integer values. \n5) Enter 'e' to evaluate the stack.");
        System.out.println("\nEnter values to add to the stack machine.");

        // Exucute while the user has not entered 'x'
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
            else if (input.equals("d")) { // Displaying the contents of the stack
                    System.out.println("\nThe contents of the stack are:");
                    stc.display();
                    System.out.println();
            }
            else if (input.equals("s")) { // Swapping the the elements at the top of the stack
                if (!stc.isEmpty()) {
                    int tempNum1 = stc.pop();
                    int tempNum2 = stc.pop();

                    stc.push(tempNum1);
                    stc.push(tempNum2);

                    System.out.println("\nThe contents of the stack are:");
                    stc.display();
                }  
                else{
                    System.out.println("The stack is empty");
                }
            }
            else if (input.equals("e")) { // Evaluating the elements in the stack
                int sum = 0;
                Queue<Integer> queue = new LinkedList<>(); // Creating a linked list to hold the values in the stack

                while (!stc.isEmpty()) { // While the stack is not empty, remove the value from the stack, sum then send the value that was removed from the stack to the queue
                    int value = stc.pop();
                    sum += value;
                    queue.add(value);
                    }

                    // The queue reverses the order of the values  
                    queueToStack(queue, stc); // Move values to stack 
                    stackToQueue(stc, queue); // Values are now in reverse order from the stack
                    queueToStack(queue, stc); // Queue back to the stack to arrange values in the correct order

                System.out.println("\nThe total sum of values in the stack is: " + sum);
            }
        }while(!input.equals("x"));
        
        System.out.println("\nStack exited");
        
        keyboard.close();
    }

    // Converting the existing stack to a queue 
    private static void stackToQueue(StackCommands<Integer> stc, Queue<Integer> queue) {
        while (!stc.isEmpty()) {
            queue.add(stc.pop());
        }
    }

    // Moving the elements in the queue back into the stack
    private static void queueToStack(Queue<Integer> queue, StackCommands<Integer> stc) {
        while (!queue.isEmpty()) {
            stc.push(queue.remove());
        }
    }
}
